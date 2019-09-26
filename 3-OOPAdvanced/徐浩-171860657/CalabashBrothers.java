enum Color{RED,ORANGE,YELLOW,GREEN,CYAN,BLUE,PURPLE};

class CalabashBrother
{
    private Color color;
    private String rank;
    private String colorName;
    Position pos;
    double hp=100;

    public CalabashBrother(String col,String name)
    {
        color=Enum.valueOf(Color.class,col);
        rank=name;
    }
    public CalabashBrother(String col,String name,Position pos)
    {
        color=Enum.valueOf(Color.class,col);
        rank=name;
        this.pos=pos;
    }
    public CalabashBrother(String col,String name,String colorname)
    {
        color=Enum.valueOf(Color.class,col);
        rank=name;
        colorName=colorname;
    }
    public CalabashBrother(String col, String name, String colorname, Position pos)
    {
        color=Enum.valueOf(Color.class,col);
        rank=name;
        colorName=colorname;
        this.pos=pos;
    }
    String getRank()
    {
        return rank;
    }
    Color getColor()
    {
        return color;
    }
    String getColorName()
    {
        return colorName;
    }
    double getHp()
    {
        return hp;
    }
    void setHp(double hp)
    {
        this.hp=hp;
    }
    public Position getPos() {
        return pos;
    }
}

public class CalabashBrothers
{
    private int[] ranPos;       //葫芦兄弟站位相对顺序
    private CalabashBrother[] bros=new CalabashBrother[7];

    int centerX=7,centerY=3;

    //得到一个大小为n,值介于(min,max]之间的int型数组
    public static int[] randomArray(int min, int max, int n){
        if (n > (max - min + 1) || max < min) {
            return null;
        }
        int[] result = new int[n];
        int count = 0;
        while(count < n) {
            int num = (int) (Math.random() * (max - min+1)) + min;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if(num == result[j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                result[count] = num;
                count++;
            }
        }
        for(int i=0;i<n;i++)
            result[i]--;
        return result;
    }

    public CalabashBrothers(Map map)
    {
        ranPos = randomArray(0, 7, 7);

        bros[0] = new CalabashBrother("RED","老大",new Position(ranPos[0]+7,3));
        bros[1] = new CalabashBrother("ORANGE", "老二",new Position(ranPos[1]+7,3));
        bros[2] = new CalabashBrother("YELLOW", "老三",new Position(ranPos[2]+7,3));
        bros[3] = new CalabashBrother("GREEN", "老四",new Position(ranPos[3]+7,3));
        bros[4] = new CalabashBrother("CYAN", "老五",new Position(ranPos[4]+7,3));
        bros[5] = new CalabashBrother("BLUE", "老六",new Position(ranPos[5]+7,3));
        bros[6] = new CalabashBrother("PURPLE", "老七",new Position(ranPos[6]+7,3));
    }

    public CalabashBrothers(int centerXPosition,int centerYPosition, Map map)
    {
        centerX=centerXPosition;
        centerY=centerYPosition;

        if(centerYPosition>9||centerYPosition<0||centerXPosition<3||centerXPosition>16)
        {
            System.out.println("Center position doesn't meet the requirements. Plz check.");
            return;
        }

        ranPos = randomArray(0, 7, 7);
        bros[0] = new CalabashBrother("RED","1",new Position(ranPos[0]+centerXPosition-3,centerYPosition));
        bros[1] = new CalabashBrother("ORANGE", "2",new Position(ranPos[1]+centerXPosition-3,centerYPosition));
        bros[2] = new CalabashBrother("YELLOW", "3",new Position(ranPos[2]+centerXPosition-3,centerYPosition));
        bros[3] = new CalabashBrother("GREEN", "4",new Position(ranPos[3]+centerXPosition-3,centerYPosition));
        bros[4] = new CalabashBrother("CYAN", "5",new Position(ranPos[4]+centerXPosition-3,centerYPosition));
        bros[5] = new CalabashBrother("BLUE", "6",new Position(ranPos[5]+centerXPosition-3,centerYPosition));
        bros[6] = new CalabashBrother("PURPLE", "7",new Position(ranPos[6]+centerXPosition-3,centerYPosition));
    }

    public void setCalabashBrothers(Map map)
    {
        for (int i = 0; i < 7; i++) {
            map.setMap(bros[i].getPos().getX(),bros[i].getPos().getY(),true, true,bros[i].getRank());
        }
        map.setMap(ranPos[0]+centerX-3,centerY, true, true,"1");
        map.setMap(ranPos[1]+centerX-3,centerY, true, true,"2");
        map.setMap(ranPos[2]+centerX-3,centerY, true, true,"3");
        map.setMap(ranPos[3]+centerX-3,centerY, true, true,"4");
        map.setMap(ranPos[4]+centerX-3,centerY, true, true,"5");
        map.setMap(ranPos[5]+centerX-3,centerY, true, true,"6");
        map.setMap(ranPos[6]+centerX-3,centerY, true, true,"7");
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }
}



//TODO:给Spot类加了name 记得修改