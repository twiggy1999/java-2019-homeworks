import java.util.Collections;
import java.util.ArrayList;

public class CalabashRank {
    public static void main(String[] args) {
        ArrayList<Calabash> calabashbrothers = new ArrayList<Calabash>();//创建葫芦兄弟的ArrayList
        calabashbrothers.add(new Calabash("红娃", "老大", "红色", 1));
        calabashbrothers.add(new Calabash("橙娃", "老二", "橙色", 2));
        calabashbrothers.add(new Calabash("黄娃", "老三", "黄色", 3));
        calabashbrothers.add(new Calabash("绿娃", "老四", "绿色", 4));
        calabashbrothers.add(new Calabash("青娃", "老五", "青色", 5));
        calabashbrothers.add(new Calabash("蓝娃", "老六", "蓝色", 6));
        calabashbrothers.add(new Calabash("紫娃", "老七", "紫色", 7));

        Collections.shuffle(calabashbrothers);//利用Collection根体系的shuffle方法打乱顺序
        System.out.println("打乱顺序，冒泡排序：");
        Calabash.bubbleSort(calabashbrothers);
        System.out.println("报数！");
        for (int i = 0; i < 7; i++) {
            System.out.println(calabashbrothers.get(i).rank);
        }

        System.out.println();

        Collections.shuffle(calabashbrothers);//再次打乱顺序
        System.out.println("再次打乱顺序，二分法排序：");
        Calabash.bubbleSort(calabashbrothers);
        System.out.println("报数！");
        for (int i = 0; i < 7; i++) {
            System.out.println(calabashbrothers.get(i).color);
        }
    }
}

class Calabash {    //葫芦娃类
    public String name;
    public String rank;//辈分
    public String color;
    public int id;
    Calabash(String name, String rank, String color, int id){             //构造器
        this.name = name;
        this.rank = rank;
        this.color = color;
        this.id = id;
    }

    public void skill(){}//虚方法：“独特的本领”

    public static void bubbleSort(ArrayList<Calabash> calabashList){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6 - i; j++) {
                if(calabashList.get(j).id > calabashList.get(j + 1).id) {
                    System.out.println(calabashList.get(j).rank + "：" + j + "→" + (j + 1));
                    System.out.println(calabashList.get(j + 1).rank + "：" + (j + 1) + "→" + j);//报告交换动作
                    Collections.swap(calabashList, j, j + 1);//交换两个元素
                }
            }
        }
    }//冒泡排序

    public static void binaryInsertSort(ArrayList<Calabash> calabashList){
        for (int i = 1; i < 7; i++) {   //默认第一个为已经排好的序列，对1到6个元素进行二分法插入
            int low = 0, high = i - 1;
            int mid = -1;
            while (low <= high) {
                mid = (high + low) / 2;
                if (calabashList.get(mid).id > calabashList.get(i).id) {
                    high = mid - 1;
                } else { // 元素相同时，也插入在后面的位置
                    low = mid + 1;
                }
            }
            System.out.println(calabashList.get(i).rank + "：" + i + "→" + low);
            calabashList.add(low, calabashList.get(i));
            calabashList.remove(i + 1);
        }
    }//二分法排序
}
