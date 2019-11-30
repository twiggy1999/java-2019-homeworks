package sample;
import javafx.geometry.Pos;
import sample.position.Position;

public class Config {
//    public static final int LAYOUTX = 100;
//    public static final int LAYOUTY = 50;
    public static final int IMAGEWIDTH = 80;
    public static final int IMAGEHEIGHT = 80;
    public static final int N = 9;
    public static final int M = 15;
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 720;
    public static Position calculatePos(Position pos){
        int x = pos.getX()*IMAGEWIDTH;
        int y = pos.getY()*IMAGEHEIGHT;
        Position ret = new Position(x, y);
        return ret;
    }
}
