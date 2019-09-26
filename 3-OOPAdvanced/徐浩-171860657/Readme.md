## 作业3：面向葫芦娃编程
---
### 主要的类
+ **地图类**
将地图初始化为20*20的矩阵，每一格通过`class Spot`来描述，400个格子构成`class Map`
`class Map`是现实中葫芦娃/蛇精等角色站位的映射，将现实中的角色映射为`Map`棋盘上的棋子
```
class Spot
{
    private String name;                //棋子/角色名字
    private boolean status=false;       //该坐标处是否被占,被占说明此处放置一颗棋子
    private boolean camp=false;         //站在该坐标处的是葫芦兄弟阵营/蛇精阵营
    ...                                 //false代表蛇精阵营,true为葫芦兄弟阵营
}
```
+ **角色类**
  + `class CalabashBrothers`
    ```
    public class CalabashBrothers
    {
        private CalabashBrother[] bros=new CalabashBrother[7];

        public CalabashBrothers(int centerXPosition,int centerYPosition, Map map)
        public void setCalabashBrothers(Map map)
        ...
    }
    ```
    + 以长蛇阵型初始化7个葫芦兄弟
    + 使用`setCalabashBrothers(Map map)`完成葫芦兄弟与地图的关联
  + `class BadGuys`

    ```
    public class BadGuys 
    {
        private BadGuy[] badguy = new BadGuy[7];

        public BadGuys(int mode, int n, Position centerPos, Map map) 
        void init(int mode, int n, Position center, Map map)        
        //阵型选择mode，阵型核心位置center，所映射的主地图map

        public void setBadguy(Map map)
        ...
    }
    ```
    + 通过mode选择阵型，进一步对蛇精阵营角色初始站位进行初始化（通过init()对角色站位进行初始化）
    + 通过`void setBadguy(Map map)`完成蛇精阵营角色与地图的关联

  + `class Leader`&`class Grandpa`&`class SerpentDemon`
    ```
    public class Leader
    {
        protected String name;      //名字
        protected boolean camp;     //阵营

        public Leader(String name,boolean camp)
    }
    ```
    `class Grandpa`与`class SerpentDemon`继承`class Leader`，分别用于描述爷爷与蛇精

### 设计思想
通过初始化蛇精/葫芦兄弟等角色的位置，将他们的位置信息传入主地图中，完成对现实角色的映射。

### 关系图
![Aaron Swartz](https://raw.githubusercontent.com/irronici/java-2019-homeworks/master/3-OOPAdvanced/%E5%BE%90%E6%B5%A9-171860657/ver1uml.png)
