package field;

/*
 * 标注以一个格点为中心，另一个格点在本格点的什么方向。
 * 标号的逻辑是从+x开始，按正角方向增加。
 * 方向与dx皆是把原点坐标放在左上角的结果。
 */
public class Direction{
    public static final int E=0,NE=1,N=2,NW=3,W=4,SW=5,S=6,SE=7;
    private int dir;

    public Direction(Position center, Position another){
//        assert !center.equals(another);
        int dx=another.getX()-center.getX();
        int dy=another.getY()-center.getY();
        if(dx>0){
            if(dy<0)
                dir=NE;
            else if(dy==0)
                dir=E;
            else
                dir=SE;
        }
        else if(dx<0){
            if(dy<0)
                dir=NW;
            else if(dy==0)
                dir=W;
            else
                dir=SW;
        }
        else{
            if(dy<0)
                dir=N;
            else
                dir=S;
        }
    }

    public Direction(int dir_){
        assert 0<=dir_ && dir_<=7;
        dir=dir_;
    }

    public int dx(){
        switch (dir){
            case N: case S:return 0;
            case SW: case W: case NW:return -1;
            case SE: case E: case NE:return 1;
            default:return 0;//静默处理
        }
    }

    public int dy(){
        switch (dir){
            case W: case E:return 0;
            case N: case NE: case NW:return -1;
            case S: case SE: case SW:return 1;
            default:return 0;
        }
    }

    /*
     * 按顺序找下一个方向。
     */
    public void next(){
        dir=(dir+1)%8;
    }
}
