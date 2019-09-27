enum HuluwaColor{RED,ORANGE,YELLOW,GREEN,CYAN,BLUE,PURPLE};

public class Huluwa extends Creature{
    private int rank;
    private HuluwaColor color;
    public Huluwa(Position p, String n, int r, HuluwaColor c){
        super(p,n);
        rank=r;
        color=c;
    }
    public int getRank(){
        return rank;
    }
    public Position getPos(){
        return pos;
    }
}

