import java.util.*;

public class homework3 {
    public static void main(String[] args){
        int[] rank = {5,7,6,3,4,1,2};
        String[] name = {"蝎子精","炮灰1号","炮灰2号","炮灰3号","炮灰4号","炮灰5号","炮灰6号"};
        World world = new World();
        Boy[] boy = world.createBoy(rank);//创建七个葫芦娃
        Enemy[] enemy = world.createEnemy(name);//创建蝎子精等七个敌人
        Creature grandpa = new Creature("爷爷");
        Enemy snake = new Enemy("蛇精");
        world.snake(boy,0, 1);//葫芦娃站队：乱序的长蛇阵
        world.sortY(0,1, 7);//乱序葫芦娃排序
        world.wing(enemy, 7, 9);//敌人以鹤翼阵型站队
        world.move(grandpa, 0, 0);//放置爷爷
        world.move(snake, 8, 9);//放置蛇精
        world.show();//打印对峙局面

        world.goose(enemy, 0, 14);//敌人变化阵型为雁行
        world.move(snake, 7, 14);//蛇精移动
        world.show();//打印对峙局面
    }

}
/*class God{//用于创建生物的类
    Enemy[] createEnemy(String[] name){//创建敌人
        int len = name.length;
        Enemy[] enemy = new Enemy[len];
        for(int i = 0; i < len; i++){//循环进行实例初始化
            enemy[i] = new Enemy(name[i]);
        }
        return enemy;
    }
    Boy[] createBoy(int[] rank){//创建葫芦娃
        int len = rank.length;
        Boy[] boy = new Boy[len];
        for(int i = 0; i < len; i++){//循环进行实例初始化
            boy[i] = new Boy(rank[i]);
        }
        return boy;
    }
}*/
class World{//坐标类，定义代表地图的二维坐标和对数组的操作
    Creature[][] world;
    static final int N = 15;
    World(){
        world = new Creature[N][N];
    }
    void move(Creature creature, int x, int y){
        creature.walk(world, x, y);
    }
    //阵型函数，以xy作为起始坐标
    void snake(Creature[] queue, int x, int y){//xy是纵向长蛇的最上面一点的坐标
        int a = x, b = y;
        int len = queue.length;
        if((a+len-1) >= N || a >= N || b >= N || a < 0 || b < 0){
            System.out.println("坐标越界，无法创建长蛇阵型");
            return;
        }
        for(int i = 0; i < len; i++){
            boolean flag = queue[i].walk(world, a, b);
            if( flag == false)
                System.out.println("长蛇阵型排列失败,位置："+a+','+b);
            a++;
        }
    }
    void wing(Creature[] queue, int x, int y){//xy是鹤翼中心点的坐标
        int len = queue.length;
        int half1 = (len - 1) / 2;
        int half2 = len - 1 - half1;
        int i = 0;
        int a = x, b = y;
        if((a-half1) < 0 || (a-half2) < 0 || (b-half1) < 0 || (b+half2) >= N || a >= N || b >= N || a < 0 || b < 0){
            System.out.println("坐标越界，无法创建鹤翼阵型");
            return;
        }
        for(; i < half1 + 1; i++){
            boolean flag = queue[i].walk(world, a, b);
            if( flag == false)
                System.out.println("鹤翼阵型排列失败,位置："+a+','+b);
            a--; b--;
        }
        a = x - 1;
        b = y + 1;
        for(; i < len; i++){
            boolean flag = queue[i].walk(world, a, b);
            if( flag == false)
                System.out.println("鹤翼阵行排列失败,位置："+a+','+b);
            a--; b++;
        }
    }
    void goose(Creature[] queue, int x, int y){
        //(x,y)是雁行阵型的右上坐标
        int len = queue.length;
        int a = x, b = y;
        if( a < 0 || b >= N || (a+len-1) >= N || (y-len+1) < 0){
            System.out.println("坐标越界，无法创建雁行阵型");
            return;
        }
        for(int i = 0; i < len; i++){
            boolean flag = queue[i].walk(world, a, b);
            if( flag == false)
                System.out.println("雁行阵行排列失败,位置："+a+','+b);
            a++; b--;
        }
    }
    //两个排序函数
    void sortY(int x, int y, int len){//对纵向排列的葫芦娃进行排序
       if(len <= 0){//合法性检查
            System.out.println("排序元素个数非法, 排序失败");
            return;
        }
        if(x < 0 || y < 0 || x >= N || y >= N || x + len - 1 >= N){//越界检查
            System.out.println("坐标越界, 排序失败");
            return;
        }
        for(int i = 0; i < len; i++){//冒泡排序
            for(int j = x; j < x + len - 1; j++){
                //ab是两个相邻的葫芦娃
                Boy a = (Boy)world[j][y];
                Boy b = (Boy)world[j+1][y];
                if(a.tellRank()>b.tellRank()){//根据排行判断是否进行交换
                    int tmpX = -1, tmpY = -1;
                    int min = 2*N;
                    for(int m = 0; m < len; m++){//二重循环找到距离待交换的葫芦娃最近的坐标
                        for(int n = 0; n < len; n++){
                            if(world[m][n] == null){
                                int distance = Math.abs(m-j)+Math.abs(m-j-1)+Math.abs(n-y)*2;
                                if(distance<min){
                                    tmpX = m; tmpY = n;
                                    min = distance;
                                }
                            }
                        }
                    }
                    boolean flag = a.walk(world, tmpX, tmpY);
                    flag = flag & b.walk(world, j, y);
                    flag = flag & a.walk(world, j+1, y);
                    if(flag == false){//葫芦娃移动失败
                        System.out.println("排序失败");
                        return;
                    }
                }
            }
        }
    }
    void sortX(int x, int y, int len){//对横向排列的葫芦娃进行排序
        if(len <= 0){//合法性检查
            System.out.println("排序元素个数非法, 排序失败");
            return;
        }
        if(x < 0 || y < 0 || x >= N || y >= N || y + len - 1 >= N){//越界检查
            System.out.println("坐标越界, 排序失败");
            return;
        }
        for(int i = 0; i < len; i++){//冒泡排序
            for(int j = y; j < y + len - 1; j++){
                Boy a = (Boy)world[x][j];
                Boy b = (Boy)world[x][j+1];
                if(a.tellRank()>b.tellRank()){//进行交换
                    int tmpX = -1, tmpY = -1;
                    int min = 2*N;
                    for(int m = 0; m < len; m++){//二重循环找到距离待交换的葫芦娃最近的坐标
                        for(int n = 0; n < len; n++){
                            if(world[m][n] == null){
                                int distance = Math.abs(n-j)+Math.abs(n-j-1)+Math.abs(m-x)*2;
                                if(distance<min){
                                    tmpX = m; tmpY = n;
                                    min = distance;
                                }
                            }
                        }
                    }
                    boolean flag = a.walk(world, tmpX, tmpY);
                    flag = flag & b.walk(world, x, j);
                    flag = flag & a.walk(world, x, j+1);
                    if(flag == false){
                        System.out.println("排序失败");
                        return;
                    }
                }
            }
        }
    }
    //打印对峙局面
    void show(){
        //打印对峙局面
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (world[i][j] == null){
                    System.out.printf("%4s","");
                }
                else{
                    String name = world[i][j].tellName();
                    System.out.printf("%4s",name);
                }
            }
            System.out.println("");
        }
    }
    Enemy[] createEnemy(String[] name){//创建敌人
        int len = name.length;
        Enemy[] enemy = new Enemy[len];
        for(int i = 0; i < len; i++){//循环进行实例初始化
            enemy[i] = new Enemy(name[i]);
        }
        return enemy;
    }
    Boy[] createBoy(int[] rank){//创建葫芦娃
        int len = rank.length;
        Boy[] boy = new Boy[len];
        for(int i = 0; i < len; i++){//循环进行实例初始化
            boy[i] = new Boy(rank[i]);
        }
        return boy;
    }
}
class Creature{
    String name = "";
    int x = -1;
    int y = -1;
    Creature(){}
    Creature(String name){ this.name = name;}
    boolean walk(Creature[][] world, int x, int y){

        if (world[x][y] != null) {
            System.out.println("目的坐标存在生物，无法移动至目的坐标");
            world[x][y].tellName();
            return false;
        }
        world[x][y] = this;
        if (this.x >= 0 && this.y >= 0) {
            //该生物已经存在于坐标空间中
            world[this.x][this.y] = null;
        }
        this.x = x;
        this.y = y;
        return true;
    }
    String tellName(){ return name; }
}
class Boy extends Creature{
    String color = "";
    int rank = 0;
    Boy(int rank){
        this.rank = rank;
        switch(rank){
            case 1: name = "老大"; color = "红色"; break;
            case 2: name = "老二"; color = "橙色"; break;
            case 3: name = "老三"; color = "黄色"; break;
            case 4: name = "老四"; color = "绿色"; break;
            case 5: name = "老五"; color = "青色"; break;
            case 6: name = "老六"; color = "蓝色"; break;
            case 7: name = "老七"; color = "紫色"; break;
            default: System.out.println("创建葫芦娃失败");
        }
    }
    int tellRank(){ return rank;}
    String tellColor(){ return color;}
}
class Enemy extends Creature{
    Enemy(String name){
        this.name = name;
    }
}
