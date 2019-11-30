package sample.ground;

import sample.creatures.Creature;
import sample.creatures.State;


public class Cell {
    private Creature creature;
    public void setCreature(Creature creature){
        this.creature = creature;
    }
    public Creature getCreature(){
        return creature;
    }
    public Creature getLiveCreature(){
        if (creature!=null&&creature.getState()== State.LIVE)
            return creature;
        else return null;
    }
}
