# 第三次作业代码说明

## 输出内容截图

## Class Diagram

## 设计思路
* 1、Battle类构建战场，私有成员的类型为Unit[][]。提供setUnit方法，将某生物体放置在某座标上<br>
* 2、Unit不需要实例，设为**抽象类**。GrandFather、CalabashBrother、Snake、Scorpion、Monster继承基类Unit<br>
* 3、为实现GrandFather、Snake为同阵营对象加油的功能，提供leader接口，实现相关功能
```Java
interface leader {
	void cheer();
	void instruction(); //发出“布阵/变阵”的指示
}
```
* 4、Camp类的对象用于存储单个阵营的所有对象
```Java
public calss Camp<T extends Unit> {
	private ArrayList<Unit> soldiers;
	private T leader;
	...
}
```
* 5、阵型变换在现阶段统一交给Controller类处理，相关的成员函数均为public static void。考虑在后续代码中提供caption接口，Scorpion实现该接口，指挥妖怪侧