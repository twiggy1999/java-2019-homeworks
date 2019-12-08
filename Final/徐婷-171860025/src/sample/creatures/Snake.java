package sample.creatures;

import javafx.scene.image.Image;

public class Snake extends Bad {
    private String liveImage = "file:///C:\\Users\\Mizar\\CS\\Java\\java projects\\java-2019-homeworks\\Final\\徐婷-171860025\\figures\\Snake.PNG";

    public Snake(){
        String filename = liveImage;
        image = new Image(filename);
        this.setPos(14, 8);
    }
    public void setState(State state){
        if(state==State.DEAD)image = new Image(deadImage);
        else image = new Image(liveImage);
        this.state = state;
    }

}
