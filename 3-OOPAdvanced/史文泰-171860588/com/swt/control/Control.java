package com.swt.control;

import com.swt.model.basic.Picture;
import com.swt.model.basic.Point;
import com.swt.model.controlled.GrandFather;
import com.swt.model.controlled.CalabashTeam;
import com.swt.model.controlled.EnemyTeam;
import com.swt.model.controlled.NMap;
import com.swt.view.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Control{
    private static final int ALARMGAP = 6000;
    private NMap nMap;                                      //地图
    private CalabashTeam calabashTeam;                      //葫芦兄弟
    private EnemyTeam enemyTeam;                            //敌人队伍
    private GrandFather grandFather;                        //老爷爷
    private MyPaint myPaint;                                        //画笔
    private int PointIndex = 1;                                     //下一个阵型
    private int PointMax = 5;                                       //阵型总数

    public Control(double width, double height) throws IOException {
        nMap = new NMap("SRCFile/pic2.jpg", "SRCFile/pic3.jpg");
        calabashTeam = new CalabashTeam();
        enemyTeam = new EnemyTeam(Formation.getPointList("SRCFile/Point0.txt"));
        initGrandAndSnake();
        myPaint = new MyPaint(width, height, nMap, calabashTeam, enemyTeam, grandFather);
        myPaint.startDraw();
        setAlarm();
    }

    /**
     * 初始化老爷爷和蛇精
     * @throws IOException
     */
    private void initGrandAndSnake() throws IOException {
        FileInputStream fis0 = new FileInputStream(new File("SRCFile/grandFather.jpg"));
        Image image0 = new Image(fis0);
        fis0.close();
        FileInputStream fis1 = new FileInputStream(new File("SRCFile/yeye.jpg"));
        Image image1 = new Image(fis1);
        Picture goodPicture = new Picture(new Point(1, 0), image1);
        grandFather = new GrandFather(0, 0, image0, goodPicture);
        fis1.close();
    }

    /**
     * 设置定时器，6秒中改变一次阵型
     */
    private void setAlarm(){
        EventHandler<ActionEvent> eventHandler = e -> {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        enemyTeam.getSnake().Order(enemyTeam, "SRCFile/Point" + PointIndex + ".txt", "SRCFile/Form" + PointIndex + ".jpg");
                        PointIndex = (PointIndex + 1) % PointMax;
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }).start();
        };
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(ALARMGAP), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }

    public MyPaint getCanvas(){
        return this.myPaint;
    }

}
