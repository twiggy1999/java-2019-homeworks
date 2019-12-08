package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import sample.creatures.*;
import sample.formation.Formation;
import sample.ground.Ground;
import sample.position.Position;

import java.util.List;

public class Controller {

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

    //private Image myBI= new Image("file:///C:/Users/Mizar/Pictures/a.jpg",780,620,false,true);
    private Image myBI =new Image("file:///C:\\Users\\Mizar\\CS\\Java\\java projects\\java-2019-homeworks\\Final\\徐婷-171860025\\figures\\background.jpg");

    private static GoodTeam goods;
    private static BadTeam bads;
    private static Ground ground;
    public void init(){
        goods = new GoodTeam();
        bads = new BadTeam(25);
        Formation.changShe(goods.getSoldier());
        Formation.fangYuan(bads.getSoldier());
        ground = new Ground(goods, bads);
        ground.update();
        goods.getTeamMember().get(0).setGround(ground);
        draw();
    }
    public void pressSelectButton(ActionEvent event){
        System.out.println("press Select Button");
    }
    public void pressStartButton(ActionEvent event){
    }
    public void pressReplayButton(ActionEvent event){
        System.out.println("press replay Button");
    }
    private void draw(){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(myBI, 0,0,1200, 720);
        for(Good good: goods.getTeamMember()){
            if(good.getState()== State.DEAD) {
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
}
