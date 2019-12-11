package controllers;

import battle.Bullet;
import battle.Ground;
import battle.Status;
import config.Config;
import creature.Creature;
import creature.Good;
import creature.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import team.BadTeam;
import team.GoodTeam;
import team.Team;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Controller implements Initializable {

    @FXML
    private Canvas canvas;

    @FXML
    private Button startButton;

    @FXML
    private Button replayButton;

    @FXML
    private TextField saveTextField;
    private GoodTeam good;
    private BadTeam bad;
    private Ground ground;
    private Image backGround;

    public void initialize(URL location, ResourceBundle resources){
        Image bg = new Image("home.jpg");
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(bg, 0, 0, Config.WIDTH, Config.HEIGHT);

    }

    private List<Object> draw(ObjectOutputStream output) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(backGround, 0, 0, Config.WIDTH, Config.HEIGHT);
        List<Object> ret = new ArrayList<Object>();
        /*GoodTeam g1 = new GoodTeam();
        BadTeam b1 = new BadTeam();
        List<Bullet> bulletList = new ArrayList<Bullet>();*/
        synchronized (ground) {
            /*g1.copy(good);
            b1.copy(bad);*/
            drawCreature(good, State.DEAD);
            drawCreature(bad, State.DEAD);
            drawCreature(good, State.LIVE);
            drawCreature(bad, State.LIVE);
            for (Bullet bullet : ground.getBullets()) {
                bullet.draw(canvas.getGraphicsContext2D());
                Bullet b = new Bullet();
                b.copy(bullet);
                //bulletList.add(b);
            }
            /*ret.add(g1);
            ret.add(b1);
            ret.add(bulletList);*/
        }
        return ret;
    }


    private void drawCreature(Team t, State state){
        List<Creature> list = t.getTeamMembers();
        for(Creature c: list){
            if(c.getState()==state){
                c.draw(canvas.getGraphicsContext2D());
            }
        }
    }

    public void pressStartButton(ActionEvent event){
        ground = new Ground();
        good = new GoodTeam();
        bad = new BadTeam();
        backGround = new Image("background.jpg");
        new Thread(new Runnable() {
            public void run() {
                ExecutorService exec = Executors.newCachedThreadPool();
                exec.execute(good);
                exec.execute(bad);
                final List<Object>ret = new ArrayList<Object>();
                final ObjectOutputStream output;
                try {
                     output = new ObjectOutputStream(
                            new FileOutputStream(saveTextField.getText()));
                }catch (IOException e){
                    throw new RuntimeException(e);
                }
                exec.execute(new Thread(new Runnable() {
                    public void run() {
                        while(true) {
                            List<Object> t;
                            t = draw(output);
                            ret.add(t);
                            try{
                                TimeUnit.MILLISECONDS.sleep(100);
                            }catch (InterruptedException e){
                                throw new RuntimeException(e);
                            }
                            synchronized (ground) {
                                if (ground.whoWin() != Status.RUNNING) {
                                    ret.add(draw(output));
                                    System.out.println(ground.whoWin());
                                    try {
                                        output.writeObject(ret);
                                        output.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }));
                exec.shutdown();
            }
        }).start();

    }
    public void pressReplayButton(ActionEvent event){
        backGround = new Image("background.jpg");
        System.out.println("replay pressed");
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("out"));
            List l = (List)input.readObject();
            input.close();
            reDraw(l);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    @SuppressWarnings("unchecked")
    private void reDraw(final List list0){
        new Thread(new Runnable() {
            public void run() {
                for(Object obj: list0){
                    List lst = (List)obj;
                    GoodTeam g = (GoodTeam) lst.get(0);
                    BadTeam b = (BadTeam)lst.get(1);
                    List<Bullet>list = (List<Bullet>)lst.get(2);
//                    try {
//                        g = (GoodTeam) input.readObject();
//                        b = (BadTeam)input.readObject();
//                        list = (List<Bullet>)input.readObject();
//                    }catch (Exception e){
//                        throw new RuntimeException(e);
//                    }
                    GraphicsContext gc = canvas.getGraphicsContext2D();
                    gc.drawImage(backGround, 0, 0, Config.WIDTH, Config.HEIGHT);
                    drawCreature(g, State.DEAD);
                    drawCreature(b, State.DEAD);
                    drawCreature(g, State.LIVE);
                    drawCreature(b, State.LIVE);
                    for (Bullet bullet : list) {
                        bullet.draw(canvas.getGraphicsContext2D());
                    }
                    try{
                        TimeUnit.MILLISECONDS.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

}
