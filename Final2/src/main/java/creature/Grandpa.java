package creature;

import javafx.scene.image.Image;

public class Grandpa extends Good {
    private static Image liveImage = new Image("grandpa.png");

    public Grandpa(){
        x = 6;
        y = 0;
    }
    public Image getLiveImage(){
        return liveImage;
    }
}
