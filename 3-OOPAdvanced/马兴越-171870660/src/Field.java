/*
 * N*N的场地。
 * 先行后列。x为横坐标。访问格式为map[x][y].
 */

public class Field {
    public static final int N=12;
    private Living[][] map;

    public Field(){
        map=new Living[N][N];
    }

    /*
     * 按Living指定的位置添加。用于初始化。
     */
    public boolean addLiving(Living living){
        if(livingAt(living.getPosition())!=null)
            return false;
        int x=living.getPosition().getX(),y=living.getPosition().getY();
        map[y][x]=living;
        return true;
    }

    /*
     * 将living添加到x,y指定的位置，返回是否成功。
     * 如果成功，修改living中的数据为x,y指定的位置。
     * 否则不做任何操作并返回false。
     */
    private boolean addLiving(Living living,int x,int y){
        if(livingAt(x,y)!=null)
            return false;
        map[y][x]=living;
        living.getPosition().setPos(x,y);
        return true;
    }

    private boolean addLiving(Living living,Position pos){
        return addLiving(living,pos.getX(),pos.getY());
    }

    private void removeLiving(Position position){
        map[position.getY()][position.getX()]=null;
    }

    public Living livingAt(Position pos){
        return map[pos.getY()][pos.getX()];
    }

    private Living livingAt(int x,int y){
        return map[y][x];
    }

    /*
     * 移动指定生物到指定位置。此函数由Living调用。
     * （移动应该是生物体主动的动作，故由Living主动，此处只是维护数据，
     * 顺便充当检测是否冲突。如果目标位置有生物体了，返回false，不做任何操作。）
     * 后续维护工作由Living自行完成。
     */
    public boolean moveLiving(Living living,int dx,int dy){
        //保证两边的数据一致
        assert livingAt(living.getPosition())==living;
        int nx=living.getPosition().getX()+dx;
        int ny=living.getPosition().getY()+dy;
        if(livingAt(nx,ny)!=null)
            return false;
        return addLiving(living,nx,ny);
    }

    /*
     * 交换两指定生物的位置，由Living调用，且已经保证位置相邻。
     */
    public boolean swapLiving(Living living1,Living living2){
        if(!living1.getPosition().adjacentWith(living2.getPosition()))
            return false;
        removeLiving(living1.getPosition());
        removeLiving(living2.getPosition());
        Position pos1=living1.getPosition(),pos2=living2.getPosition();
        assert addLiving(living1,pos2);
        assert addLiving(living2,pos1);
        return true;
    }
}
