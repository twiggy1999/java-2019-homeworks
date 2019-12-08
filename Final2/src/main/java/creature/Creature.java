package creature;

import battle.Bullet;
import battle.Ground;
import battle.Status;
import config.Config;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Creature implements Runnable{

    protected Image image;
    protected State state = State.LIVE;
    protected int x,  y;
    protected int attack;
    protected int health;
    //每个生物要判断移动的位置，必须要知道关于全局的信息
    //所有生物共享一个全局信息
    protected static Image deadImage = new Image("DEAD.png");
    protected Image liveImage;
    protected Ground ground = Ground.getInstance();
    protected int direction;
    //TODO: 后期修改
    public Creature(){
        attack = 5;
        health = 100;
    }
    public void setState(State state){
        if(state==State.DEAD)image = deadImage;
        else image = liveImage;
        this.state = state;
    }
    public void setPos(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean isEnemy(Creature c){
        if(c instanceof Good && this instanceof Bad || c instanceof Bad && this instanceof Good)
            return true;
        return false;
    }

    //TODO
    public void beAttacked(Creature from){
        health -= from.attack;
        if(health<0) {
            setState(State.DEAD);
        }
    }
    public State getState(){
        if(health<0)state = State.DEAD;
        return state;
    }
    protected void moveThread(){
        final int []moveX={0,0, 1, -1};
        final int []moveY ={1, -1, 0, 0};

        new Thread(new Runnable() {
            public void run() {
                while(state==State.LIVE||ground.whoWin()!= Status.RUNNING){
                    Random rand = new Random();
                    synchronized (ground){
                        if(ground.hasEnemy(Creature.this)) {
                            //0.75的概率不动
                            if(25<rand.nextInt(100)) continue;
                        }
                        int i = rand.nextInt(4);
                        int x1 = x+moveX[i];
                        int y1 = y+moveY[i];
                        if(canMove(x1, y1)){
                            //没有敌人，3/4概率不动
                            if(!ground.hasEnemy(Creature.this, y1)){
                                if(25<rand.nextInt(100))continue;
                            }
                            ground.setCreature(null, x, y);
                            ground.setCreature(Creature.this, x1, y1);
                            x = x1;
                            y = y1;
                        }
                    }
                    try{
                        TimeUnit.SECONDS.sleep(3);
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }

    private boolean canMove(int x, int y){
        int s = this instanceof Good? 0: 7;
        int e = this instanceof Good?6:14;
        if(x>=s&&x<=e&&y>=0&&y<Config.N&&ground.getCreature(x, y)==null){
            return true;
        }
        return false;
    }

    protected abstract void shootThread();
    public void run(){
        moveThread();
        shootThread();
    }
    public void draw(GraphicsContext gc){
        if(state==State.LIVE) {
//            System.out.println(getName() + "在画自个" + x + " " + y);
            gc.drawImage(this.liveImage, x* Config.IMAGEWIDTH, y*Config.IMAGEHEIGHT, Config.IMAGEWIDTH, Config.IMAGEHEIGHT);
            gc.setFill(Color.valueOf("red"));
            gc.fillRect(x*Config.IMAGEWIDTH, y*Config.IMAGEHEIGHT,Config.IMAGEWIDTH, (double)Config.IMAGEHEIGHT / 6);
            gc.setFill(Color.color(0, 1, 0));
            double hpRatio = (double)health/(double)100;
            double hpLength = Config.IMAGEWIDTH * hpRatio;
            gc.fillRect(x*Config.IMAGEWIDTH, y*Config.IMAGEHEIGHT, hpLength, Config.IMAGEWIDTH / 6);
        }else if (state==State.DEAD){
//            System.out.println(getName() + "画自己坟墓");
            gc.drawImage(deadImage, x* Config.IMAGEWIDTH, y*Config.IMAGEHEIGHT, Config.IMAGEWIDTH, Config.IMAGEHEIGHT);
        }
    }
    /**decorator pattern*/
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getX(){return x;}
    public int getY(){return y;}
    public Image getImage(){return image;}
}
