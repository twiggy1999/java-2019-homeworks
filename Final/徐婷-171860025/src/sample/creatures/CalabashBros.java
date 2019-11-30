package sample.creatures;

import javafx.scene.image.Image;

public class CalabashBros extends Good {
    int rank;

    public CalabashBros(int rank){

        this.rank = rank;
        String filename = "file:///C:\\Users\\Mizar\\CS\\Java\\java projects\\java-2019-homeworks\\Final\\徐婷-171860025\\figures\\brother";
        String file = filename+rank+".PNG";
        image = new Image(file);
    }

}
