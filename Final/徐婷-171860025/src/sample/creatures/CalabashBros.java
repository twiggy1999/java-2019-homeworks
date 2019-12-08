package sample.creatures;

import javafx.scene.image.Image;

public class CalabashBros extends Good {
    int rank;
    private String liveImage = "file:///C:\\Users\\Mizar\\CS\\Java\\java projects\\java-2019-homeworks\\Final\\徐婷-171860025\\figures\\brother";
    public CalabashBros(int rank){
        this.rank = rank;
        String filename = liveImage;
        String file = filename+rank+".PNG";
        image = new Image(file);
    }
    public void setState(State state){
        if(state==State.DEAD)image = new Image(deadImage);
        else image = new Image(liveImage+rank+".PNG");
        this.state = state;
    }


}
