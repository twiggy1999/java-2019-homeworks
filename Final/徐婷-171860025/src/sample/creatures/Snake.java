package sample.creatures;

import javafx.scene.image.Image;

public class Snake extends Bad {
    public Snake(){

        String filename = "file:///C:\\Users\\Mizar\\CS\\Java\\java projects\\java-2019-homeworks\\Final\\徐婷-171860025\\figures\\Snake.PNG";
        image = new Image(filename);
        this.setPos(14, 8);
    }

}
