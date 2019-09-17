/*
 * 蝎子精，领队。负责指挥喽啰排队。
 */

public class ScorpionDemon extends Living {
    private int followCount;
    private FollowDemon[] followDemons;

    public ScorpionDemon(Position pos, Field field_, int followCount_) {
        super(pos, field_);
        followCount = followCount_;
        followDemons=new FollowDemon[followCount];
        for(int i=0;i<followCount_;i++){
            Position position=field_.randomPosition();
            FollowDemon followDemon=new FollowDemon(position,field_,i+1);
            field.addLiving(followDemon);
            followDemons[i]=followDemon;
        }
    }

    /*
     * “鹤翼”阵型。
     */
    public void standAsSwing(){
        if(followCount%2!=0){
            System.out.println("Swing requires EVEN number follower!");
            return;
        }
        setMovable(false);
        for(Living f:followDemons) {
            f.setMovable(true);
        }
        if(!findPlaceForSwing()){
            System.out.println("没有空间排布鹤翼阵型！");
            return;
        }
        Position p=new Position(position.getX(),position.getY());
        Direction dir=new Direction(Direction.NW);
        for(int i=0;i<followCount/2;i++){
            p=p.adjacentPosition(dir);
            followDemons[i].walkTowards(p);
            followDemons[i].setMovable(false);
            assert followDemons[i].getPosition().equals(p);
        }
        p=new Position(position.getX(),position.getY());
        dir=new Direction(Direction.NE);
        for(int i=followCount/2;i<followCount;i++){
            p=p.adjacentPosition(dir);
            followDemons[i].walkTowards(p);
            followDemons[i].setMovable(false);
            assert followDemons[i].getPosition().equals(p);
        }
    }

    /*
     * 以蝎子精为参考位置，考察周边空位是否满足布局条件。
     * 条件是所需要范围内，没有不可移动障碍物。（其实就是葫芦娃）
     */
    private boolean readyForSwing(){
        int depth=followCount/2;
        //left
        Position p=position.copy();
        Direction d=new Direction(Direction.NW);
        for(int i=0;i<depth;i++){
            p=p.adjacentPosition(d);
            if(!field.inside(p)||
                    field.livingAt(p)!=null&&!field.livingAt(p).isMovable())
                return false;
        }
        d=new Direction(Direction.NE);
        p=position.copy();
        for(int i=0;i<depth;i++){
            p=p.adjacentPosition(d);
            if(!field.inside(p)||
                    field.livingAt(p)!=null&&!field.livingAt(p).isMovable())
                return false;
        }
        return true;
    }

    /*
     * 寻找一个位置来满足布阵条件。
     */
    private boolean findPlaceForSwing(){
        Field passed=new Field();
        return findPlaceForSwing(passed);
    }

    /*
     * 递归算法
     */
    private boolean findPlaceForSwing(Field passed){
        if(readyForSwing())
            return true;
        passed.addLiving(new Living(position.copy(),passed));
        Direction dir=new Direction(Direction.S);
        Position p;
        for(int i=0;i<8;i++){
            p=position.adjacentPosition(dir);
            if(field.inside(p) && passed.livingAt(p)==null && moveOrSwap(dir.dx(),dir.dy()))
                return findPlaceForSwing(passed);
            dir.next();
        }
        return false;
    }

    /*
     * “锋矢”阵型。
     */
    public void standAsArrow(){


    }


    @Override
    public String toString(){
        return "Sco";
    }
}
