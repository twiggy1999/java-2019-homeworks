package team;

import battle.Formation;
import battle.Ground;
import creature.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BadTeam extends Team{
    private Snake cheerer = new Snake();
    private List<Bad> soldiers = new ArrayList<Bad>();

    //TODO FORMATION
    public BadTeam(){
        soldiers.add(new Scorpion());
        for(int i = 0;i<7;i++){
            soldiers.add(new Lackey());
        }
        Formation.fangYuan(soldiers);
        Ground.getInstance().update(this);
    }
    public void run(){
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(cheerer);
        for(Bad soldier: soldiers){
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
