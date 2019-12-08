package team;

import battle.Formation;
import battle.Ground;
import creature.CalabashBros;
import creature.Creature;
import creature.Grandpa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class GoodTeam extends Team {
    private Grandpa cheerer = new Grandpa();
    private List<CalabashBros> soldiers = new ArrayList<CalabashBros>();
    //TODO FORMATION
    public GoodTeam(){
        for(int i = 0;i<7;i++){
            soldiers.add(new CalabashBros(i+1));
        }
        Formation.changShe(soldiers);
        Ground.getInstance().update(this);
    }
    public void run(){
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(cheerer);
        for(CalabashBros soldier: soldiers){
            exec.execute(soldier);
        }
        exec.shutdown();
    }
    public List<Creature> getTeamMembers(){
        List<Creature> ret = new ArrayList<Creature>();
        ret.add(cheerer);
        ret.addAll(1, soldiers);
        return ret;
    }
}
