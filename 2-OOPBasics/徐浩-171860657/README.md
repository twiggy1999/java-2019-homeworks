## 作业2:面向葫芦娃编程
***
##### 主要的类：
主要包含两个类，分别用于完成**对葫芦兄弟的描述**，以及**对葫芦兄弟完成的操作**。
`class CalabashBrother`用于描述单个葫芦兄弟，其中包含葫芦兄弟对应的颜色以及称呼。
`class Sorting`用于完成对葫芦兄弟们的排序操作。

+ 对于`class CalabashBrother`，成员变量如下：
    ```
    class CalabashBrother
    {
        private Color color;
        private String rank;
        private String colorName;
        ...
    }
    ```
  + 其中`Color`为枚举类型，用于描述葫芦兄弟各自对应的颜色。
    `enum Color{RED,ORANGE,YELLOW,GREEN,CYAN,BLUE,PURPLE};`
  + `String rank`表示葫芦兄弟的兄辈关系，如“老大”，“老二”等。
  + `String colorName`表示葫芦兄弟各自对应颜色的字符串形式，便于输出使用。

+ 对于`class Sorting`,包含对葫芦兄弟们的排序操作：
  ```
  //用于随机初始化葫芦兄弟的站队顺序
  public static int[] randomArray();  

  //冒泡排序    
  public static void bubbleSort(CalabashBrother[] bros);

  //二分排序
  public static int partition(CalabashBrother[] bros,int begin,int end);
  public static void binarySort(CalabashBrother[] bros,int begin,int end);

  //main方法
  public static void main(String[] args);
   ```
  + `int[] randomArray(int min, int max, int n)`    用于返回范围在[min,max]，含n个数的整型数组
  + `void bubbleSort(CalabashBrother[] bros)`   用于对数组bros进行冒泡排序
  + `void binarySort(CalabashBrother[] bros,int begin,int end)`</br>`int partition(CalabashBrother[] bros,int begin,int end);`  用于对数组bros进行二分排序
 
