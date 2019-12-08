package sample.creatures;

import javafx.scene.image.Image;

public class Grandpa extends Good {
    private String liveImage = "file:///C:\\Users\\Mizar\\CS\\Java\\java projects\\java-2019-homeworks\\Final\\徐婷-171860025\\figures\\grandpa.png";
    public Grandpa(){
        this.setPos(7,0);
        String filename =  liveImage;
        image = new Image(filename);
    }
    public void setState(State state){
        if(state == State.DEAD)image = new Image(deadImage);
        else image = new Image(liveImage);
        this.state = state;
    }

}
