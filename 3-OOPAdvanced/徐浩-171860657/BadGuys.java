class BadGuy
{
   private Position pos;
    String name="BadGuy";
    double hp=100;

    public BadGuy(Position p)
    {
        pos=p;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public Position getPos() {
        return pos;
    }
}

public class BadGuys {
    private BadGuy[] badguy = new BadGuy[7];
    int num;

    public BadGuys(int mode, int n, Position centerPos, Map map) {
        badguy = new BadGuy[n];
        num=n;
        init(mode, n, centerPos, map);
    }

    public void setBadguy(Map map) {
        for (int i = 0; i < num; i++) {
            map.setMap(badguy[i].getPos().getX(), badguy[i].getPos().getY(), true, false,"x");
        }
    }

    //mode用于阵型选择，n为生成小喽啰的数量
    //TODO:边界检查
    void init(int mode, int n, Position center, Map map) {
        if (mode == 1)         //鹤翼
        {
            badguy[0] = new BadGuy(center);
            map.setMap(center.getX() , center.getY() , true, false,"x");
            for (int i = 1; i < n; i++) {
                if (i % 2 == 1) {
                    badguy[i] = new BadGuy(new Position(center.getX() + ((i + 1) / 2), center.getY() + ((i + 1) / 2)));
                    //map.setMap(center.getX() + ((i + 1) / 2), center.getY() + ((i + 1) / 2), true, false,"x");
                } else {
                    badguy[i] = new BadGuy(new Position(center.getX() - ((i + 1) / 2), center.getY() + ((i + 1) / 2)));
                    //map.setMap(center.getX() - ((i + 1) / 2), center.getY() + ((i + 1) / 2), true, false,"x");
                }
            }
        } else if (mode == 2)    //雁行
        {
            for (int i = 0; i < n; i++) {
                if(i%2==0)
                {
                    badguy[i] = new BadGuy(new Position(center.getX() + ((i + 1) / 2), center.getY() + ((i + 1) / 2)));
                    //map.setMap(center.getX() + ((i + 1) / 2), center.getY() + ((i + 1) / 2), true, false,"x");
                }
                else
                {
                    badguy[i] = new BadGuy(new Position(center.getX() - ((i + 1) / 2), center.getY() - ((i + 1) / 2)));
                   //map.setMap(center.getX() - ((i + 1) / 2), center.getY() - ((i + 1) / 2), true, false,"x");
                }
            }
        } else if (mode == 3)    //冲轭
        {
            for (int i = 0; i < n; i++)
            {
                if(((i+1)/2)%2==1)
                {//右方放点
                    if(i%2==1) { //上方(i+1)/2处
                        badguy[i] = new BadGuy(new Position(center.getX() - (i+1)/2, center.getY()+1));
                        //map.setMap(center.getX() - (i+1)/2, center.getY()+1, true, false,"x");
                    }
                    else
                    {
                        badguy[i] = new BadGuy(new Position(center.getX() +(i+1)/2 , center.getY()+1));
                        //map.setMap(center.getX() +(i+1)/2, center.getY()+1, true, false,"x");
                    }
                }
                else
                {
                    //左方
                    if(i%2==1) { //上方(i+1)/2处
                        badguy[i] = new BadGuy(new Position(center.getX() - (i+1)/2, center.getY()));
                        //map.setMap(center.getX() - (i+1)/2, center.getY(), true, false,"x");
                    }
                    else
                    {
                        badguy[i] = new BadGuy(new Position(center.getX() + (i+1)/2, center.getY()));
                        //map.setMap(center.getX() + (i+1)/2, center.getY(), true, false,"x");
                    }
                }
            }
        } else if (mode == 4)    //长蛇
        {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    badguy[i] = new BadGuy(new Position(center.getX() + ((i + 1) / 2), center.getY()));
                    //map.setMap(center.getX() + ((i + 1) / 2), center.getY(), true, false,"x");
                } else {
                    badguy[i] = new BadGuy(new Position(center.getX() - ((i + 1) / 2), center.getY()));
                    //map.setMap(center.getX() - ((i + 1) / 2), center.getY(), true, false,"x");
                }
            }
        } else if (mode == 5)    //鱼鳞，固定喽啰个数为10
        {
            int x = center.getX();
            int y = center.getY();
            badguy = new BadGuy[10];
            num=10;
            badguy[0] = new BadGuy(center);
            badguy[1] = new BadGuy(new Position(x - 1, y + 1));
            badguy[2] = new BadGuy(new Position(x - 2, y + 2));
            badguy[3] = new BadGuy(new Position(x, y + 2));
            badguy[4] = new BadGuy(new Position(x + 1, y + 2));
            badguy[5] = new BadGuy(new Position(x - 3, y + 3));
            badguy[6] = new BadGuy(new Position(x - 1, y + 3));
            badguy[7] = new BadGuy(new Position(x + 1, y + 3));
            badguy[8] = new BadGuy(new Position(x + 2, y + 3));
            badguy[9] = new BadGuy(new Position(x, y + 4));

            /*
            map.setMap(x, y, true, false,"x");
            map.setMap(x - 1, y + 1, true, false,"x");
            map.setMap(x - 2, y + 2, true, false,"x");
            map.setMap(x, y + 2, true, false,"x");
            map.setMap(x + 1, y + 2, true, false,"x");
            map.setMap(x - 3, y + 3, true, false,"x");
            map.setMap(x - 1, y + 3, true, false,"x");
            map.setMap(x + 1, y + 3, true, false,"x");
            map.setMap(x + 2, y + 3, true, false,"x");
            map.setMap(x, y + 4, true, false,"x");
             */
        } else if (mode == 6)    //方圆,固定喽啰个数为8个
        {
            badguy = new BadGuy[8];
            num=8;
            for (int i = 0; i < 5; i++) {
                if (i % 2 == 1) {
                    badguy[i] = new BadGuy(new Position(center.getX() + ((i + 1) / 2), center.getY() + ((i + 1) / 2)));
                    //map.setMap(center.getX() + ((i + 1) / 2), center.getY() + ((i + 1) / 2), true, false,"x");
                } else {
                    badguy[i] = new BadGuy(new Position(center.getX() - ((i + 1) / 2), center.getY() + ((i + 1) / 2)));
                    //map.setMap(center.getX() - ((i + 1) / 2), center.getY() + ((i + 1) / 2), true, false,"x");
                }
            }
            badguy[5] = new BadGuy(new Position(badguy[1].getPos().getX(), center.getY() + 3));
            badguy[6] = new BadGuy(new Position(badguy[2].getPos().getX(), center.getY() + 3));
            badguy[7] = new BadGuy(new Position(center.getX(), center.getY() + 4));

           /* map.setMap(badguy[1].getPos().getX(), center.getY() + 3, true, false,"x");
            map.setMap(badguy[2].getPos().getX(), center.getY() + 3, true, false,"x");
            map.setMap(center.getX(), center.getY() + 4, true, false,"x");

            */
        } else if (mode == 7)    //偃月，9个以内随机生成。大于9个固定数量为19个
        {
            int x = center.getX();
            int y = center.getY();
            if (n <= 9) {
                for (int i = 0; i < n; i++) {

                    if (i % 3 == 0) {
                        badguy[i] = new BadGuy(new Position(x, y + i / 3));
                       // map.setMap(x, y + i / 3, true, false,"x");
                    }
                    if (i % 3 == 1) {
                        badguy[i] = new BadGuy(new Position(x - 1, y + i / 3));
                       // map.setMap(x - 1, y + i / 3, true, false,"x");
                    }
                    if (i % 3 == 2) {
                        badguy[i] = new BadGuy(new Position(x + 1, y + i / 3));
                       // map.setMap(x + 1, y + i / 3, true, false,"x");
                    }
                }
            } else {
                badguy = new BadGuy[19];
                num=19;
                for (int i = 0; i < 9; i++) {

                    if (i % 3 == 0) {
                        badguy[i] = new BadGuy(new Position(x, y + i / 3));
                       // map.setMap(x, y + i / 3, true, false,"x");
                    }
                    if (i % 3 == 1) {
                        badguy[i] = new BadGuy(new Position(x - 1, y + i / 3));
                       // map.setMap(x - 1, y + i / 3, true, false,"x");
                    }
                    if (i % 3 == 2) {
                        badguy[i] = new BadGuy(new Position(x + 1, y + i / 3));
                       // map.setMap(x + 1, y + i / 3, true, false,"x");
                    }
                }
                badguy[9] = new BadGuy(new Position(x + 2, y + 1));
                badguy[10] = new BadGuy(new Position(x + 2, y + 2));
                badguy[11] = new BadGuy(new Position(x - 2, y + 1));
                badguy[12] = new BadGuy(new Position(x - 2, y + 2));
                badguy[13] = new BadGuy(new Position(x + 3, y + 2));
                badguy[14] = new BadGuy(new Position(x + 3, y + 3));
                badguy[15] = new BadGuy(new Position(x - 3, y + 2));
                badguy[16] = new BadGuy(new Position(x - 3, y + 3));
                badguy[17] = new BadGuy(new Position(x + 4, y + 3));
                badguy[18] = new BadGuy(new Position(x - 4, y + 3));
/*
                map.setMap(x + 2, y + 1, true, false,"x");
                map.setMap(x + 2, y + 2, true, false,"x");
                map.setMap(x - 2, y + 1, true, false,"x");
                map.setMap(x - 2, y + 2, true, false,"x");
                map.setMap(x + 3, y + 2, true, false,"x");
                map.setMap(x + 3, y + 3, true, false,"x");
                map.setMap(x - 3, y + 2, true, false,"x");
                map.setMap(x - 3, y + 3, true, false,"x");
                map.setMap(x + 4, y + 3, true, false,"x");
                map.setMap(x - 4, y + 3, true, false,"x");
*/
            }
        } else if (mode == 8)        //锋失，固定喽啰数量为12个
        {
            badguy = new BadGuy[12];
            num=12;
            badguy[0] = new BadGuy(center);
            for (int i = 1; i < 7; i++) {
                if (i % 2 == 1) {
                    badguy[i] = new BadGuy(new Position(center.getX() + ((i + 1) / 2), center.getY() + ((i + 1) / 2)));
                    //map.setMap(center.getX() + ((i + 1) / 2), center.getY() + ((i + 1) / 2), true, false,"x");
                } else {
                    badguy[i] = new BadGuy(new Position(center.getX() - ((i + 1) / 2), center.getY() + ((i + 1) / 2)));
                    //map.setMap(center.getX() - ((i + 1) / 2), center.getY() + ((i + 1) / 2), true, false,"x");
                }
            }
            for (int i = 7; i < 12; i++) {
                badguy[i] = new BadGuy(new Position(center.getX() , center.getY()+ i - 6));
               // map.setMap(center.getX(), center.getY() + i - 6, true, false,"x");
            }
        } else                    //默认为长蛇
        {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    badguy[i] = new BadGuy(new Position(center.getX() + ((i + 1) / 2), center.getY()));
                    //map.setMap(center.getX() + ((i + 1) / 2), center.getY(), true, false,"x");
                } else {
                    badguy[i] = new BadGuy(new Position(center.getX() - ((i + 1) / 2), center.getY()));
                   // map.setMap(center.getX() - ((i + 1) / 2), center.getY(), true, false,"x");
                }
            }
        }
    }
}