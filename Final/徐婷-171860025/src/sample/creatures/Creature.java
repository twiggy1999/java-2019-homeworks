package sample.creatures;

import javafx.scene.image.Image;
import sample.ground.Ground;
import sample.position.Position;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Creature implements Runnable{

    protected Image image;
    protected State state = State.LIVE;
    protected Position pos = new Position();
    protected int attack;
    //每个生物要判断移动的位置，必须要知道关于全局的信息
    //所有生物共享一个全局信息
    protected static Ground ground;
    protected static Lock lock = new ReentrantLock();
    protected static String deadImage = "file:///C:\\Users\\Mizar\\CS\\Java\\java projects\\java-2019-homeworks\\Final\\徐婷-171860025\\figures\\DEAD.png";
    public void setState(State state){
        if(state==State.DEAD)image = new Image(deadImage);
        this.state = state;
    }
    public void setPos(Position pos){
        this.pos = pos;
    }
    public void setPos(int x, int y){
        pos.setY(y);
        pos.setX(x);
    }

    public Position getPos(){return pos;}
    public void setGround(Ground ground){
        this.ground = ground;
    }

    public State getState(){return state;}

    public void walk(){
        Position to = ground.findNearestEnemy(this);
        if(to==null)return;
        int toX = to.getX();
        int toY = to.getY();
        int fromX = this.getX();
        int fromY = this.getY();
        if(toX>fromX){
            Creature c = ground.getCreature(fromX+1, fromY);
            if(c==null||c.getState()==State.DEAD) {
                moveTo(new Position(fromX + 1, fromY));
                return;
            }
        }
        if(toX<fromX){
            Creature c = ground.getCreature(fromX-1, fromY);
            if(c==null||c.getState()==State.DEAD) {
                moveTo(new Position(fromX - 1, fromY));
                return;
            }
        }
        if(toY>fromY){
            Creature c = ground.getCreature(fromX, fromY+1);
            if(c==null||c.getState()==State.DEAD) {
                moveTo(new Position(fromX , fromY+1));
                return;
            }
        }
        if(toY<fromY){
            Creature c = ground.getCreature(fromX, fromY-1);
            if(c==null||c.getState()==State.DEAD) {
                moveTo(new Position(fromX , fromY-1));
                return;
            }
        }
    }
    public boolean isEnemy(Creature a){
        if (this instanceof Good&& a instanceof Bad || this instanceof Bad && a instanceof Good){
            return true;
        }
        return false;
    }

    //与另一敌人PK
    public void pk(){
        Creature enemy = ground.findEnemy(this);
        if(enemy!=null)pk(enemy);

    }
    private void pk(Creature enemy){
        double p1 = Math.random()*attack;
        double p2 = Math.random()*enemy.attack;
        if(p1>p2)enemy.setState(State.DEAD);
        else this.setState(State.DEAD);
    }

    public void run(){
        while(state!=State.DEAD) {
            lock.lock();
            walk();
            pk();
            lock.unlock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void moveTo(Position to){
        ground.moveTo(this, this.pos, to);
        pos = to;
    }
    public String toString(){
        return this.getClass().getSimpleName()+" : "+pos.getX()+" "+pos.getY();
    }


    /**decorator pattern*/
    public void setX(int x){
        pos.setX(x);
    }
    public void setY(int y){
        pos.setY(y);
    }
    public int getX(){return pos.getX();}
    public int getY(){return pos.getY();}
    public Image getImage(){return image;}
}
