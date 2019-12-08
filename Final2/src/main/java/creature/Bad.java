package creature;

import battle.Bullet;
import battle.Status;
import javafx.scene.image.Image;

import java.util.concurrent.TimeUnit;

public abstract class Bad extends Creature{
    private Image bulletImage = new Image("bulletBad.png");
    private Image hitBad = new Image("hitGood.png");
    protected void shootThread(){
        new Thread(new Runnable() {
            public void run() {
                while(state==State.LIVE&&ground.whoWin()== Status.RUNNING) {
                    synchronized (ground) {
                        Bullet b = new Bullet(Bad.this.x, Bad.this.y, -1, bulletImage, hitBad, Bad.this);
                        ground.addBullet(b);
                        new Thread(b).start();

                    }
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }
}
