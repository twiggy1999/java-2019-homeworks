package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;

import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import sample.creatures.*;
import sample.formation.Formation;
import sample.ground.Ground;
import sample.position.Position;
import java.net.URL;
import java.util.ResourceBundle;

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

    //private Image myBI= new Image("file:///C:/Users/Mizar/Pictures/a.jpg",780,620,false,true);
    private Image myBI =new Image("file:///C:\\Users\\Mizar\\CS\\Java\\java projects\\java-2019-homeworks\\Final\\徐婷-171860025\\figures\\background.jpg");
    private String arrangeGood = "changShe";
    private String arrangeBad = "fangYuan";
    private static GoodTeam goods;
    private static BadTeam bads;
    private static Ground ground;
    public void draw(){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0,0,1200, 720);
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


    }
    class MyDialog extends Dialog{
        public MyDialog() {
            super();
            RadioButton []g;
            g = new RadioButton[5];
            g[0] = new RadioButton("鹤翼");
            g[1] = new RadioButton("雁行");
            g[2] = new RadioButton("衡轭");
            g[3] = new RadioButton("长蛇");
            g[4] = new RadioButton("锋矢");
            RadioButton []b;
            b = new RadioButton[8];
            b[0] = new RadioButton("鹤翼");
            b[1] = new RadioButton("雁行");
            b[2] = new RadioButton("衡轭");
            b[3] = new RadioButton("长蛇");
            b[4] = new RadioButton("鱼鳞");
            b[5] = new RadioButton("方円");
            b[6] = new RadioButton("偃月");
            b[7] = new RadioButton("锋矢");
        }

    }
    public void pressStartButton(ActionEvent event){
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
