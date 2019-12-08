package creature;

import javafx.scene.image.Image;

public class CalabashBros extends Good {
    private int rank;
    public CalabashBros(int rank){
        this.rank = rank;
        liveImage = new Image("Brother"+rank+".png");
    }
}
