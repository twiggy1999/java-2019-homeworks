//妖精  蝎子+喽啰

public class Damon extends Creature {
    public Damon(Positon p, String n){
        super(p,n);
    }
    public void setDead(){
        health=0;
        state=State.DEAD;
    }
}
