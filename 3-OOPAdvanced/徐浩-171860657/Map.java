class Spot
{
    private String name;
    private boolean status=false;       //该坐标处是否被占
    private boolean camp=false;         //站在该坐标处的是葫芦兄弟阵营/蛇精阵营
                                        //false代表蛇精阵营,true为葫芦兄弟阵营

    public Spot(boolean status, boolean camp,String name)
    {
        this.status=status;
        this.camp=camp;
        this.name=name;
    }

    public Spot()
    {
        this.status=false;
        this.camp=false;
        this.name="";
    }


    public boolean getStatus()
    {
        return status;
    }

    public boolean getCamp()
    {
        return camp;
    }

    public String getName() {
        return name;
    }

    public void setCamp(boolean camp) {
        this.camp = camp;
    }

    public void setStatus(boolean flag)
    {
        status=flag;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class Map
{
    final int N=20;
    private Spot[][] map;

    public Map()
    {
        map=new Spot[N][N];
        for (int i = 0; i < N; i++) {
            map[i]=new Spot[N];
            for (int j = 0; j < N; j++) {
                map[i][j]=new Spot();
            }
        }
    }

    public void printMap()
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j].getStatus())       //代表此坐标点被占有
                {
                    System.out.print(map[i][j].getName());
                }
                else
                    System.out.print(' ');
            }
            System.out.println();
        }
    }

    public void setMap(int i,int j,boolean status,boolean camp,String name)
    {
        map[i][j]=new Spot(status, camp,name);
    }

    public final Spot[][] getMap()
    {
        return map;
    }
}
