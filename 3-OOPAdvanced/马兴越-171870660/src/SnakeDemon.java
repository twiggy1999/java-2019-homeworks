/*
 * 蛇精。总指挥。
 */

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public class SnakeDemon extends Living {
    private ScorpionDemon scorpionDemon;

    public SnakeDemon(Position pos, Field field_, int followCount_) {
        super(pos, field_);
        scorpionDemon=new ScorpionDemon(field_.randomPosition(),field_,followCount_);
        field_.addLiving(scorpionDemon);
    }

    public void standAsSwing(){
        scorpionDemon.standAsSwing();
    }

    public void standAsArrow(){
        scorpionDemon.standAsArrow();
    }

    @Override
    public String toString(){
        return "Sna";
    }
}
