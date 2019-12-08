package sample.creatures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BadTeam {
    private Snake snake;
    private Scorpion scorpion;
    private Lackey[]lackeys;
    private List<Bad>soldiers = new ArrayList<>();
    public BadTeam(int num){
        snake = new Snake();
        scorpion = new Scorpion();
        soldiers.add(new Scorpion());
        for(int i = 0;i<num-1;i++)
            soldiers.add(new Lackey());
//        lackeys = new Lackey[num-1];
//        for(int i= 0;i<num-1;i++)
//            lackeys[i] = new Lackey();

    }

    public List<Bad>getSoldier(){
//        List<Bad>ret = new ArrayList<>();
//        ret.add(scorpion);
//        ret.addAll(1, Arrays.asList(lackeys));
//        return ret;
        return soldiers;
    }
    public List<Bad>getTeamMember(){
        List<Bad>ret = new ArrayList<>();
        ret.add(snake);
//        ret.add(scorpion);
//        ret.addAll(2, Arrays.asList(lackeys));
        ret.addAll(1, soldiers);
        return ret;
    }

}
