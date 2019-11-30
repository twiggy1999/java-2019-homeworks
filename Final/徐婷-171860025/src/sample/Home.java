package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import sample.creatures.*;
import sample.formation.Formation;
import sample.ground.Ground;
import sample.position.Position;


import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class Home implements Initializable {

    @FXML
    private Canvas canvas;


    @FXML
    private Button selectButton;

    @FXML
    private Button startButton;

    @FXML
    private Button replayButton;

    @FXML
    private TextField saveTextField;

    private Image myBI= new Image("file:///C:/Users/Mizar/Pictures/a.jpg",780,620,false,true);
    //private Image myBI =new Image("file:///C:\\Users\\Mizar\\CS\\Java\\java projects\\java-2019-homeworks\\Final\\徐婷-171860025\\figures\\DEAD.jpg");

    private static GoodTeam goods;
    private static BadTeam bads;
    private static Ground ground;
    public void draw(){
        //System.out.println(canvas.getHeight()+" "+canvas.getWidth());
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(myBI, 0,0,1200, 720);
        for(Good good: goods.getTeamMember()){
            if(good.getState()==State.DEAD) {
                Position pos = Config.calculatePos(good.getPos());
                gc.drawImage(good.getImage(), pos.getX(), pos.getY(), Config.IMAGEWIDTH, Config.IMAGEHEIGHT);
            }
        }
        for(Bad bad: bads.getTeamMember()){
            if(bad.getState()==State.DEAD) {
                Position pos = Config.calculatePos(bad.getPos());
                gc.drawImage(bad.getImage(), pos.getX(), pos.getY(), Config.IMAGEWIDTH, Config.IMAGEHEIGHT);
            }
        }
        for(Good good: goods.getTeamMember()){
            if(good.getState()==State.LIVE) {
                Position pos = Config.calculatePos(good.getPos());
                gc.drawImage(good.getImage(), pos.getX(), pos.getY(), Config.IMAGEWIDTH, Config.IMAGEHEIGHT);
            }
        }
        for(Bad bad: bads.getTeamMember()){
            if(bad.getState()==State.LIVE) {
                Position pos = Config.calculatePos(bad.getPos());
                gc.drawImage(bad.getImage(), pos.getX(), pos.getY(), Config.IMAGEWIDTH, Config.IMAGEHEIGHT);
            }
        }

    }
    @Override
    public void initialize(URL location, ResourceBundle resources){
        //添加背景图


        //GraphicsContext gc = canvas.getGraphicsContext2D();
        //gc.drawImage(myBI, 0,0,Config.WIDTH, Config.HEIGHT);
        //Image image= new Image("file:///C:/Users/Mizar/Pictures/timg.jpg",780,620,false,true);
        //gc.drawImage(image, 0,0,Config.WIDTH, Config.HEIGHT);
        goods = Formation.changSheGood();
        bads = Formation.fangYuanBad();
        ground = new Ground(goods, bads);
        ground.update();
        goods.getTeamMember().get(0).setGround(ground);
        draw();

    }
    public void pressSelectButton(ActionEvent event){
        System.out.println("press Select Button");
    }
    public void pressStartButton(ActionEvent event){
//        draw();
//        if(true)return;
        for(Bad bad: bads.getTeamMember()){
            Thread t = new Thread(bad);
            t.start();
        }
        for(Good good: goods.getTeamMember()){
            Thread t = new Thread(good);
            t.start();
        }
        Display d = new Display(this);
        Thread t = new Thread(d);
        t.start();
        
    }
    public void pressReplayButton(ActionEvent event){
        System.out.println("press replay Button");
    }


}
