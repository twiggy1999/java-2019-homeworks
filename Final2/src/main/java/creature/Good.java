package creature;

import battle.Bullet;
import battle.Status;
import javafx.scene.image.Image;

import java.util.concurrent.TimeUnit;

public abstract class Good extends Creature{
    private Image bulletImage = new Image("bulletGood.png");
    private Image hitBad = new Image("hitBad.png");
    protected void shootThread(){
        new Thread(new Runnable() {
            public void run() {
                while(state==State.LIVE&&ground.whoWin()== Status.RUNNING){
                    synchronized (ground) {
                        Bullet b = new Bullet(Good.this.x, Good.this.y, 1, bulletImage, hitBad, Good.this);
                        ground.addBullet(b);
                        new Thread(b).start();

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
}
