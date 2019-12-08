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

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


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

    private void draw(){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(backGround, 0, 0, Config.WIDTH, Config.HEIGHT);
        synchronized (ground) {
            drawCreature(good, State.DEAD);
            drawCreature(bad, State.DEAD);
            drawCreature(good, State.LIVE);
            drawCreature(bad, State.LIVE);
            for (Bullet bullet : ground.getBullets()) {
                bullet.draw(canvas.getGraphicsContext2D());
            }
        }

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
                exec.execute(new Thread(new Runnable() {
                    public void run() {
                        while(true) {
                            draw();
                            try{
                                TimeUnit.MILLISECONDS.sleep(200);
                            }catch (InterruptedException e){
                                throw new RuntimeException(e);
                            }
                            if(ground.whoWin()!= Status.RUNNING)break;
                        }
                    }
                }));
                exec.shutdown();
            }
        }).start();

    }
    public void pressReplayButton(ActionEvent event){
        System.out.println("press replay Button");
    }


}
