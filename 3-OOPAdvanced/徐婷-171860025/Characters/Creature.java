package character;

enum State{LIVE, DEAD};
public class Creature{
    protected Position pos;
    protected State state;
    protected int health;  //生命值
    protected String name;
    public Creature(Position p, String n){
        pos=p;
        name=n;
        health=100;
        state=State.LIVE;
    }
    public Creature(){
        pos=new Position(0,0);
        name="unknown name";
        health=100;
        state=State.LIVE;
    }
    public void moveTo(Position to){
        System.out.println(name+" move from "+pos.toString()+" to " +to.toString());
        pos=to;
    }
    public void setPos(Position p){
        pos=p;
    }


}

