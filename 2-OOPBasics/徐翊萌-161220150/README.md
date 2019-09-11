
# 第二次作业代码说明

## 枚举类型CalabashBrother
将每个葫芦娃设置如下所示的7个对象
'''Java
enum CalabashBrother {
	CB1("老大", "红色", 1),
	...
}
'''
并为获取名称、颜色与序号分别定义了相关方法

## CalabashSort类
该类中包含打乱顺序、冒泡排序、二分排序、按名称报数、按颜色报数等方法

## main函数
1、首先，创建一个数组，并添加7个枚举类型的对象，得到初始排列queue
2、其次，创建CalabashSort类的对象cs，由cs调用相关方法，对queue进行打乱顺序、排序、报数等
