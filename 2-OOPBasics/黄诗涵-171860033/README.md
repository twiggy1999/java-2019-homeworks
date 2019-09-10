### homework2 面向葫芦娃编程
#### 171860033 黄诗涵


# 数据结构

## Huluwa类
&emsp;&ensp; 在main()方法以外定义一个Huluwa类，对main将七个葫芦娃抽象成具有不同参数的对象。
* 成员变量
>private String rank;  
    private String color;  
    private int num;  

rank表示葫芦娃的排行；color是代表色；num是1~7的编号方便排序。
* 成员函数

因为成员变量都对外不可见，需要调用成员函数访问数据。

## huluwaOrientedProgramming类
&emsp;&emsp; 这是main()所在的类，一个项目中有且仅有一个。
在该类中完成 <u>打乱数组、冒泡排序、二分排序等操作。</u>

* 创建长度为7的葫芦娃对象数组，在构造函数中根据传入的编号确定颜色和排行。
```
  Huluwa hulus[]=new Huluwa[7];
```
* 调用成员函数对葫芦娃数组进行操作


# 算法

### 随机打乱数组
```
private static Random rand = new Random();
```
java.util包中有Random类，创建一个Random对象rand，再调用rand.nextInt(int)来生成随机数。

### 冒泡排序
```
 public static void bubbleSort(Huluwa[] hulus)
```
采用了较优化的冒泡排序算法。

每次循环记录最后一次有元素交换的位置int last,则last之后位置上的元素都是有序的，下次循环就不需要再访问。

若某次循环没有发生元素交换，则表示整个数组已经有序，直接return。

### 二分法排序
```
public static void dichotomySort(Huluwa[] hulus)
```
二分法排序是二分查找与插入排序的结合。

一般的插入排序是从第i个元素依次向前查找，二分查找对前i个元素进行折半，每次比较缩小一半的查找量，能在log(i)的时间复杂度内找到第i个元素应该插入的位置，然后将之后的元素整体后移。


