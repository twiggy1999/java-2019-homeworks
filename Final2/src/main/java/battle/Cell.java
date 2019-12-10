package battle;

import creature.Creature;

public class Cell {
    private volatile Creature creature;
    public Creature getCreature(){return creature;}
    public void setCreature(Creature c){creature = c;}
}
