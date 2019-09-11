import java.util.Random;

//葫芦娃类
class HuLuWa{
    //葫芦娃的次序（排序的依据，老大为0，老二为1，以此类推）
    private int rank;
    //葫芦娃与次序对应的名字以及颜色
    private static String[] names={"老大","老二","老三","老四","老五","老六","老七"};
    private static String[] colors={"红色","橙色","黄色","绿色","青色","蓝色","紫色"};
    HuLuWa(int mRank){
        rank=mRank;
    }
    //公共接口，获取名字、颜色以及次序
    public String getName(){
        return HuLuWa.names[rank];
    }
    public String getColor(){
        return HuLuWa.colors[rank];
    }
    public int getRank(){
        return rank;
    }
    //葫芦娃位置移动
    public void runTo(HuLuWa[] huLuWaBrothers,int start,int end){
        huLuWaBrothers[end]=this;
        System.out.println(this.getName()+":"+(start+1)+"->"+(end+1));
    }
}

//实现本次作业所要求任务
public class Homework2 {
    //葫芦娃个数
    private static int HULUWA_NUM=7;
    private HuLuWa[] huLuWaBrothers;
    //枚举类型（区分报数的不同方式）
    enum countKind{
        NAME,COLOR
    }
    //初始化7个葫芦娃
    private void init(){
        for(int i=0;i<HULUWA_NUM;i++){
            huLuWaBrothers[i]=new HuLuWa(i);
        }
    }
    //交换下标为p1,p2处的两个葫芦娃的位置
    private void swap(int p1,int p2){
        HuLuWa temp=huLuWaBrothers[p2];
        huLuWaBrothers[p1].runTo(huLuWaBrothers,p1,p2);
        temp.runTo(huLuWaBrothers,p2,p1);
    }
    //葫芦娃随机排序
    private void shuffle(){
        Random rand=new Random();
        for(int i=HULUWA_NUM;i>0;i--){
            int randPos=rand.nextInt(i);
            swap(randPos,i-1);
        }
    }
    //冒泡排序
    private void bubbleSort(){
        for(int i=0;i<HULUWA_NUM-1;i++){
            for(int j=0;j<HULUWA_NUM-1-i;j++){
                if(huLuWaBrothers[j].getRank()>huLuWaBrothers[j+1].getRank())
                    swap(j,j+1);
            }
        }
    }
    //二分法插入排序
    private void binarySort(){
        int start,end,mid=-1,insertPos;
        HuLuWa temp=null;
        for(int i=1;i<HULUWA_NUM;i++){
            temp=huLuWaBrothers[i];
            start=0;
            end=i-1;
            while(start<=end){
                mid=(start+end)/2;
                if(huLuWaBrothers[mid].getRank()<huLuWaBrothers[i].getRank())
                    start=mid+1;
                else
                    end=mid-1;
            }
            if(huLuWaBrothers[mid].getRank()<huLuWaBrothers[i].getRank())
                insertPos=mid+1;
            else
                insertPos=mid;
            for(int j=i;j>insertPos;j--)
                huLuWaBrothers[j-1].runTo(huLuWaBrothers,j-1,j);
            temp.runTo(huLuWaBrothers,i,insertPos);
        }
    }
    //报数函数，传入的参数用来区分是根据名字报数还是根据颜色报数
    private void count(countKind kind){
        for(int i=0;i<HULUWA_NUM;i++){
            if(kind==countKind.NAME)
                System.out.println(huLuWaBrothers[i].getName());
            else
                System.out.println(huLuWaBrothers[i].getColor());
        }
    }
    public static void main(String[] args){
        Homework2 god=new Homework2();
        god.huLuWaBrothers=new HuLuWa[HULUWA_NUM];
        god.init();

        System.out.println("Shuffle Begins!");
        god.shuffle();
        System.out.println(" ");

        System.out.println("BubbleSort Begins!");
        god.bubbleSort();
        System.out.println(" ");

        System.out.println("Count Begins(according to names)!");
        god.count(countKind.NAME);
        System.out.println(" ");

        System.out.println("Shuffle Begins!");
        god.shuffle();
        System.out.println(" ");

        System.out.println("BinarySort Begins!");
        god.binarySort();
        System.out.println(" ");

        System.out.println("Count Begins(according to colors)!");
        god.count(countKind.COLOR);
        System.out.println(" ");
    }
}
