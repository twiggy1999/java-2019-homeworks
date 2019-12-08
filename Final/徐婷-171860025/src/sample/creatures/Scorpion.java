package sample.creatures;

import javafx.scene.image.Image;

public class Scorpion extends Bad {
    private String liveImage = "file:///C:\\Users\\Mizar\\CS\\Java\\java projects\\java-2019-homeworks\\Final\\徐婷-171860025\\figures\\Scorpion.PNG";
    public Scorpion(){
        String filename = liveImage;
        image = new Image(filename);
    }
    @Override
    public void setState(State state){
        if(state == State.DEAD)image = new Image(deadImage);
        else image = new Image(liveImage);
        this.state = state;
    }

}
