package battle;

import config.Config;
import creature.Creature;
import creature.State;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.concurrent.TimeUnit;

public class Bullet implements Runnable{
    private int direction;  // 1 -1
    private int x, y;
    enum Status{flying, hit, over};
    private Status status;
    private Image flyImage;
    private Image hitImage;
    private Creature from;
    public Bullet(int x, int y, int direction, Image flyImage, Image hitImage, Creature from){
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.flyImage = flyImage;
        this.hitImage = hitImage;
        this.status = Status.flying;
        this.from = from;
    }
    public void run(){
        Ground ground = Ground.getInstance();
        while(status!= Status.over){
            synchronized (ground){
                this.x+= direction;
                if(!ground.inGround(this.x, this.y)){
                    status = Status.over;
                    break;
                }
                Creature c = ground.getCreature(this.x, this.y);
                if(c!=null&&c.isEnemy(from)&&c.getState()== State.LIVE){
                    c.beAttacked(from);
                    status = Status.hit;
                }
            }
            try {
                TimeUnit.MILLISECONDS.sleep(250);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            if(status==Status.hit)
                status = Status.over;
        }
        ground.removeBullet(this);
    }


    public void draw(GraphicsContext gc){
        gc.drawImage(getImage(), x* Config.IMAGEWIDTH, y*Config.IMAGEHEIGHT, Config.IMAGEWIDTH, Config.IMAGEHEIGHT);
    }
    private Image getImage(){
        Image ret ;
        if(status==Status.flying)
            ret = flyImage;
        else if(status== Status.hit)
            ret = hitImage;
        else ret = null;
        return ret;
    }

}
