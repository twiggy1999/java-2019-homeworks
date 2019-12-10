package creature;

import battle.Bullet;
import battle.Ground;
import battle.Status;
import config.Config;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.awt.*;
import java.io.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Creature implements Runnable, Serializable {
    protected transient Image image;
    protected State state = State.LIVE;
    protected int x,  y;
    protected int attack;
    protected int health;
    //每个生物要判断移动的位置，必须要知道关于全局的信息
    //所有生物共享一个全局信息
    protected transient static Image deadImage = new Image("DEAD.png");
    protected transient static Ground ground = Ground.getInstance();
    protected transient int direction;
    //TODO: 后期修改
    public void writeExternal(ObjectOutput out){
        try {
            out.writeObject(state);
            out.writeInt(x);
            out.writeInt(y);
            out.writeInt(attack);
            out.writeInt(health);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void readExternal(ObjectInput in){
        try {
            state = (State) in.readObject();
            x = in.readInt();
            y = in.readInt();
            attack = in.readInt();
            health = in.readInt();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void copy(Creature c){
        this.state = c.state;
        this.x = c.x;
        this.y = c.y;
        this.attack =c.attack;
        this.health = c.health;
    }
    public Creature(){
        attack = 10;
        health = 100;
    }
    public void setState(State state){
        if(state==State.DEAD){
            image = deadImage;
        }
        else {
            image = getLiveImage();
        }
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
                while(state==State.LIVE&&ground.whoWin()== Status.RUNNING){
                    Random rand = new Random();
                    synchronized (ground){
//                        if(ground.hasEnemy(Creature.this)) {
//                            //0.75的概率不动
//                            if(25<rand.nextInt(100)) continue;
//                        }
                        int i = rand.nextInt(4);
                        int x1 = x+moveX[i];
                        int y1 = y+moveY[i];
                        int incre = ground.findEnemy(Creature.this);
                        /*if(incre!=0&&canMove(x, y+incre)){
                            ground.setCreature(null, x, y);
                            ground.setCreature(Creature.this, x, y+incre);
                            y = y+incre;
                        }else*/ if(canMove(x1, y1)){
                            //System.out.println("before "+x+" "+y+" "+ground.getCreature(x,y).getClass().getSimpleName());
                            ground.setCreature(null, x, y);
                            ground.setCreature(Creature.this, x1, y1);
                            //System.out.println("after "+x+" "+y+" "+ ((ground.getCreature(x, y)==null)?"":ground.getCreature(x,y).getClass().getSimpleName()));
                            x = x1;
                            y = y1;
                            //System.out.println("over "+x+" "+y+" "+ground.getCreature(x,y).getClass().getSimpleName());
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
        Creature c = ground.getCreature(x, y);
        if(x>=s&&x<=e&&y>=0&&y<Config.N&&(c==null||c.getState()!=State.LIVE)){
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
            gc.drawImage(this.getLiveImage(), x* Config.IMAGEWIDTH, y*Config.IMAGEHEIGHT, Config.IMAGEWIDTH, Config.IMAGEHEIGHT);
            gc.setFill(Color.valueOf("red"));
            gc.fillRect(x*Config.IMAGEWIDTH, y*Config.IMAGEHEIGHT,Config.IMAGEWIDTH, (double)Config.IMAGEHEIGHT / 6);
            gc.setFill(Color.color(0, 1, 0));
            double hpRatio = (double)health/(double)100;
            double hpLength = Config.IMAGEWIDTH * hpRatio;
            gc.fillRect(x*Config.IMAGEWIDTH, y*Config.IMAGEHEIGHT, hpLength, Config.IMAGEWIDTH / 6);
        }else if (state==State.DEAD){
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
    public abstract Image getLiveImage();
    public abstract Image getHitImage();
    public abstract Image getFlyImage();
}
