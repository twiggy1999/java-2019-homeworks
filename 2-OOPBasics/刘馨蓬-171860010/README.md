# 作业：面向葫芦娃编程

一、问题的对象
1.葫芦兄弟
2.进行排序的“上帝之手”
二、对象的属性和行为
1.葫芦兄弟
a.有姓名、位置编号、颜色和排序的优先级（按照年龄，年龄越大优先级越小）
    String name;
    int place;
    String color;
    int priority;
b.葫芦兄弟可以进行位置的改变、报出自己的名字、报出自己的颜色三种行为，其中位置改变包括更改位置以及说出更改的内容
void nameOff(){}
void colorOff(){}
void swapAction(int x){}
void placeChange(int x){}
2.上帝视角
a.上帝创造了七个葫芦兄弟，并且给他们名字、颜色与相应的优先值
Brother[] members;
void initialize(){}
b.让七个葫芦兄弟随意站街
void disruptTheOrder(){}
c.让七个葫芦兄弟按照冒泡法排序，并报名字
void bubbleSort(){}
d.让七个兄弟按照二分法进行排序，并报颜色
void dichotomy(){}