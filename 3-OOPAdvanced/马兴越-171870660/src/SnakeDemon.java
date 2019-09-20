/*
 * 蛇精。总指挥。
 */

public class SnakeDemon extends Living {
    private ScorpionDemon scorpionDemon;

    public SnakeDemon(Position pos, Field field_, int followCount_) {
        super(pos, field_);
        scorpionDemon=new ScorpionDemon(field_.rightRandomPosition(),field_,followCount_);
//        scorpionDemon=new ScorpionDemon(new Position(9,0),field_,followCount_);
        field_.addLiving(scorpionDemon,field_.rightRandomPosition());
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
