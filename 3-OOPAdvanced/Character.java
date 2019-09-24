class Position{
    int x;
    int y;
    Position(int a, int b){
        x=a;
        y=b;
    }
    public String toString(){
        return "("+String.valueOf(x)+" ,"+String.valueOf(y)+" )";
    }
}

enum State{LIVE, DEAD};
public class Creature{
    protected Postion pos;
    protected State state;
    protected int health;  //生命值
    protected String name;
    protected void moveTo(Position to){
        System.out.println(name+" move from "+pos.toString()+" to " +to.toString());
        pos=to;
    }


}

public class Huluwa extends Creature{
    protected void moveTo()
}