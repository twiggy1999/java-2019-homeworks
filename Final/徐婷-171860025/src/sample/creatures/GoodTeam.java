package sample.creatures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoodTeam {
    private Grandpa grandpa = new Grandpa();
    private CalabashBros[] bros = new CalabashBros[7];
    public GoodTeam(){
        for(int i = 0;i<7;i++){
            bros[i] = new CalabashBros(i+1);
        }
    }
    public List<Good>getSoldier(){
        List<Good>ret = new ArrayList<>();

        ret.addAll(0, Arrays.asList(bros));
        return ret;
    }
    public List<Good>getTeamMember(){
        List<Good>ret = new ArrayList<>();
        ret.add(grandpa);
        ret.addAll(1, Arrays.asList(bros));
        return ret;
    }

}
