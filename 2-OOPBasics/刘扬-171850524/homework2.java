//2019-9-10 homework2
//written by 171850524

public class homework2 {
    public static void main(String[] args){
        System.out.println("冒泡排序:");
        int[] nums1 = {1,3,6,2,7,5,4};
        Sorter sort1 = new Sorter(nums1);
        sort1.bubbleSort();
        System.out.println("二分排序:");
        int[] nums2 = {5,7,4,3,2,6,1};
        Sorter sort2 = new Sorter(nums2);
        sort2.insertionSort();
    }
}
class Sorter{
    Boy[] queue = new Boy[7];
    Sorter(int[] nums){//根据参数进行初始化
        for(int i=0; i<7; i++){
            queue[i] = new Boy(nums[i]);
        }
    }
    void bubbleSort(){//冒泡排序
        for(int i=0; i<7; i++){
            for(int j= 0; j<6; j++){
                //如果前后排行逆序，则交换相邻对象
                if(queue[j].getRank() > queue[j+1].getRank()){
                    Boy tmpBoy = queue[j+1];
                    queue[j].siteChange(queue, j,j+1);//j移动至j+1
                    tmpBoy.siteChange(queue, j+1, j);//j+1移动至j
                }
            }
        }
        for(int i=0;i<7;i++)
            queue[i].printName();//报数
    }
    void insertionSort(){//二分排序
        for(int i=1;i<7;i++){
            int low = 0, high = i - 1;
            int mid = 0;
            while(low <= high){//按照二分法寻找i应该插入的位置
                mid = low + (high-low) / 2;
                if(queue[i].getRank() >= queue[mid].getRank()){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
            //上述循环结束后，i应该插在high的后面
            Boy tmpBoy = queue[i];
            for(int j = i - 1; j > high; j --){//high后面的对象依次向后移动一位
                queue[j].siteChange(queue,j,j+1);
            }
            tmpBoy.siteChange(queue, i, high+1);
        }
        for(int i=0;i<7;i++)
            queue[i].printColor();//报颜色
    }
}
class Boy {
    int rank = 0;//排行
    String name = "";//姓名
    String color = "";//颜色
    Boy(int num){//构造函数，根据参数确定rank name color
        rank = num;
        switch(rank){
            case 1: name = "老大"; color = "红色"; break;
            case 2: name = "老二"; color = "橙色"; break;
            case 3: name = "老三"; color = "黄色"; break;
            case 4: name = "老四"; color = "绿色"; break;
            case 5: name = "老五"; color = "青色"; break;
            case 6: name = "老六"; color = "蓝色"; break;
            case 7: name = "老七"; color = "紫色"; break;
            default: System.out.println("创建葫芦娃失败");
        }
    }
    int getRank(){//返回排行的数字，用于排序
        return rank;
    }
    void printName(){//排序结束后报数
       System.out.println(name);
    }
    void printColor(){//排序结束后报颜色
        System.out.println(color);
    }
    void siteChange(Boy[] queue, int src, int dst){//执行并报告交换动作
        if(src == dst)
            return;
        queue[dst] = this;
        System.out.println(name+':'+(src+1)+"->"+(dst+1));
    }
}
