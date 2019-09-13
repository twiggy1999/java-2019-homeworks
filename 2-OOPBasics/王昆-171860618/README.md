# 王昆-171860618 第二次作业说明

本次作业，我的代码中总共包含三个类：
* main入口方法的OOPBasics类
* 完成题目要求动作的HuluwaSolution类
* 定义葫芦娃对象的Huluwa类  

其中HuluWa类定义了葫芦娃的名字、颜色等属性，以及葫芦娃的报数、报告交换位置等动作
'''Java
class HuluWa{
    //葫芦娃的名字:
    private String name; 
    //葫芦娃的颜色:
    private String color;
    //葫芦娃的序号，用来排序: 
    private int number;
    //按照名字报数：
    public void printName();
    //按照颜色报数：
    public void printColor();
    //交换位置时报告交换动作"name:b->e":
    public void printMovement(int b,int e);
    //返回该葫芦娃的序号:
    public int key();
}
'''
