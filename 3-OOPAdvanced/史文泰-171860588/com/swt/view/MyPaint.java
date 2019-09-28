package com.swt.view;

import com.swt.model.basic.Picture;
import com.swt.model.advance.Calabash;
import com.swt.model.controlled.GrandFather;
import com.swt.model.advance.SmallEnemy;
import com.swt.model.controlled.CalabashTeam;
import com.swt.model.controlled.EnemyTeam;
import com.swt.model.controlled.NMap;
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class MyPaint extends Canvas {
    private static final int SLEEPTIME = 50;                //睡眠100ms
    private GraphicsContext graphicsContext = getGraphicsContext2D();
    private NMap nMap;                                      //地图
    private CalabashTeam calabashTeam;                      //葫芦兄弟
    private EnemyTeam enemyTeam;                            //敌人队伍
    private GrandFather grandFather;                        //老爷爷
    private boolean isRunning = true;
    private DrawThread drawThread;

    public MyPaint(double width, double height, NMap nMap, CalabashTeam calabashTeam, EnemyTeam enemyTeam, GrandFather grandFather) {
        super(width, height);
        this.nMap = nMap;
        this.calabashTeam = calabashTeam;
        this.enemyTeam = enemyTeam;
        this.grandFather = grandFather;
    }

    /**
     * 绘画线程
     */
    private class DrawThread extends Thread{
        @Override
        public void run() {
            while (isRunning){
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        drawMap();
                        drawcalabashTeam();
                        drawenemyTeam();
                        drawSnake();
                        drawGrand();
                    }
                });
                //画完后休息一段时间，避免阻塞
                try {
                    Thread.sleep(SLEEPTIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void drawMapStop(){
        isRunning = false;
    }

    public void startDraw(){
        this.drawThread = new DrawThread();
        this.drawThread.start();
    }

    /**
     * 画出图片
     */
    private void draw(Picture picture, GraphicsContext graphicsContext){
        graphicsContext.drawImage(picture.getImage(),
                0, 0, picture.getWidth(), picture.getHeight(),
                picture.getPoint().getPx() * this.nMap.getPicture1().getWidth(),
                picture.getPoint().getPy() * this.nMap.getPicture1().getHeight(),
                picture.getWidth(), picture.getHeight());
    }

    private void drawMap(){
        for (int i = 0; i < NMap.N; i++) {
            for (int j = 0; j < NMap.N; j++) {
                if((i + j) % 2 == 0){
                    graphicsContext.drawImage(this.nMap.getPicture1().getImage(),
                            0, 0, this.nMap.getPicture1().getWidth(), this.nMap.getPicture1().getHeight(),
                            j * this.nMap.getPicture1().getWidth(), i * this.nMap.getPicture1().getHeight()
                            , this.nMap.getPicture1().getWidth(), this.nMap.getPicture1().getHeight());
                }else{
                    graphicsContext.drawImage(this.nMap.getPicture2().getImage(),
                            0, 0, this.nMap.getPicture2().getWidth(), this.nMap.getPicture2().getHeight(),
                            j * this.nMap.getPicture2().getWidth(), i * this.nMap.getPicture2().getHeight()
                            , this.nMap.getPicture2().getWidth(), this.nMap.getPicture2().getHeight());
                }
            }
        }
    }

    private void drawcalabashTeam(){
        for(Calabash calabash: calabashTeam.getCalabashes()){
            draw(calabash.getPicture(), graphicsContext);
        }
    }

    private void drawenemyTeam(){
        draw(enemyTeam.getScorpion().getPicture(), graphicsContext);
        for(SmallEnemy smallEnemy: enemyTeam.getSmallEnemyList()){
            draw(smallEnemy.getPicture(), graphicsContext);
        }
    }

    private void drawSnake(){
        draw(enemyTeam.getSnake().getPicture(), graphicsContext);
        draw(enemyTeam.getSnake().getOrderPicture(), graphicsContext);
    }

    private void drawGrand(){
        draw(grandFather.getPicture(), graphicsContext);
        draw(grandFather.getGoodPicture(), graphicsContext);
    }

}
