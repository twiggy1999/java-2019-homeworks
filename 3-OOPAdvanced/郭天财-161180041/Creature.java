import java.util.Random;

public class Creature {
    protected String name;
    protected Position position = new Position();

    public Creature(){
        this.name = null;
    }

    public String getName(){return name;}

    public void setPosition(int x, int y){
        this.position(x, y);
    }

    public int getX(){return position.getX();}
    public int getY(){return position.getY();}

    public void moveRandom(){
        Random rand = new Random();
        int dir = rand.nextInt(4);//0:up, 1:right, 2:down, 3:left
        int x = getX(), y = getY();
        switch(dir){
            case 0: y--;break;
            case 1: x++;break;
            case 2: y++;break;
            case 3: x--;break;
        }
        if(x < WIDTH && x > 0 && y < HIGHT && y > 0){
            
        }
    }
}