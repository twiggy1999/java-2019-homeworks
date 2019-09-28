package creature;

import java.util.Vector;
import command.Style;
import ground.*;

public class ScorpionField implements Style{
    public Scorpion scorpion = new Scorpion();
    public Snake snake = new Snake();
    public Vector<Potato> potatoes = new Vector<Potato>(17);
    {
        for(int i = 0; i < 17; i++)
            potatoes.addElement(new Potato());
    }
    public void randomSnake(){}

    public void wing(){
        int N = Ground.sizeOfTiles;
        int Central = N/2 + 1;
        
        snake.moveTo(Ground.tiles[Central][Central]);
        scorpion.moveTo(Ground.tiles[Central][Central-1]);
        potatoes.get(0).moveTo(Ground.tiles[Central][Central+1]);
        potatoes.get(1).moveTo(Ground.tiles[Central+1][Central]);
        potatoes.get(2).moveTo(Ground.tiles[Central+1][Central+1]);
        potatoes.get(3).moveTo(Ground.tiles[Central+1][Central-1]);
        potatoes.get(4).moveTo(Ground.tiles[Central+2][Central+2]);
        potatoes.get(5).moveTo(Ground.tiles[Central+2][Central+1]);
        potatoes.get(6).moveTo(Ground.tiles[Central+2][Central]);
        potatoes.get(7).moveTo(Ground.tiles[Central+2][Central-1]);
        potatoes.get(8).moveTo(Ground.tiles[Central+2][Central-2]);
        potatoes.get(9).moveTo(Ground.tiles[Central+3][Central+3]);
        potatoes.get(10).moveTo(Ground.tiles[Central+3][Central+2]);
        potatoes.get(11).moveTo(Ground.tiles[Central+3][Central-2]);
        potatoes.get(12).moveTo(Ground.tiles[Central+3][Central-3]);
        potatoes.get(13).moveTo(Ground.tiles[Central+4][Central+3]);
        potatoes.get(14).moveTo(Ground.tiles[Central+4][Central-3]);
        potatoes.get(15).moveTo(Ground.tiles[Central+5][Central+4]);
        potatoes.get(16).moveTo(Ground.tiles[Central+5][Central-4]);
    }
    public void goose(){

    }

    public void punch(){}

    public void snake(){}
    public void fishScale(){

    }
    public void square(){

    }
    public void moon(){

    }
    public void bee(){

    }

}