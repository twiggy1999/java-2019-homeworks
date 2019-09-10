### 171860622_吴晓阳_葫芦娃
1. 本次程序主要分为了三个模块：主模块、葫芦娃模块和排序模块。

2. 葫芦娃模块（Calabash）采取enum方式，具有名称（name）、辈分（seniority）、颜色（color）三个属性。
  a.  辈分和颜色采用enum方式，重置了toString方法
  b、 模块中同时添加了FROM_OLD_TO_YOUNG和FROM_RED_TO_PURPLE两个比较器（Comparator），目前的功能相同，但排序标准不同，使得其未来可以进行重载扩展。

3. 排序模块采用了策略模式（Strategy Model）。
  a.  每个排序类型（排序器）都继承自SortStrategy接口，实现对List进行排序的sort方法。
  b.  目前实现了系统默认排序器、快排排序器、归并排序器、冒泡排序器和二分排序器。
  c.  所有的排序类都放在SortStrategies类中，方便扩展。

4. 此外，还外置了一个Utility模块（Commands），其中有sort对象，通过传入List，比较器，排序器，即可自动进行排序。

5. 添加了查找器（SearchStrategy），使用Collections.indexOf(list, comparator, SearchStrategy，element)进行元素查找，与Collections.binarySearch功能相同。可用于二分查找中。

6. 最后，在主模块中，使用了Collections.shuffle方法打乱顺序，使用ArrayList来储存所有葫芦娃的引用（在enum中的元素都是static final的）。进行排序时，调用Commands.sort(list, comparator, SortStragegy)来进行排序，然后根据需要输出。

7. 输出结果：
原始序列：[大娃, 二娃, 三娃, 四娃, 五娃, 六娃, 七娃]
打乱序列：[大娃, 二娃, 七娃, 三娃, 四娃, 五娃, 六娃]
七娃: 2->3   三娃: 3->2
七娃: 3->4   四娃: 4->3
七娃: 4->5   五娃: 5->4
七娃: 5->6   六娃: 6->5
排序序列（冒泡算法）: [大娃, 二娃, 三娃, 四娃, 五娃, 六娃, 七娃]
打乱序列： [大娃, 五娃, 三娃, 六娃, 二娃, 七娃, 四娃]
五娃: 1->2    三娃: 2->1
六娃: 3->4    五娃: 2->3    三娃: 1->2    二娃: 4->1
七娃: 5->6    六娃: 4->5    五娃: 3->4    四娃: 6->3
排序序列（二分算法）： [红, 橙, 黄, 绿, 青, 蓝, 紫, ]
