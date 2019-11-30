package sample;

import java.util.concurrent.TimeUnit;

public class Display implements Runnable{
    private Home home;
    public Display(Home home){
        this.home = home;
    }
    public void run(){
        while(true) {
            home.draw();
            try{
                TimeUnit.MILLISECONDS.sleep(500);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
    }
}
