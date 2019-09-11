import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort {
    public void bubbleSort(Huluwa[]huluwas){
        for(int i=huluwas.length-1;i>=1;--i){//put ith huluwa in the right place
            for(int j=0;j<i;++j){
                if(huluwas[j+1].compareTo(huluwas[j])<0){
                    //j+1 < j
                    Huluwa temp=huluwas[j];
                    huluwas[j+1].descMove(j+1,j);
                    huluwas[j]=huluwas[j+1];
                    temp.descMove(j,j+1);
                    huluwas[j+1]=temp;
                }
            }
        }
//        System.out.println("bubbleSort:");
    }

    public int findPlace(ArrayList<Huluwa>list,int start,int end,Huluwa h){
        //[start,end] is sorted
        int left=start;
        int right=end;
        int mid=(left+right)/2;
        while(left<=right){
            mid=(left+right)/2;
            if(list.get(mid).compareTo(h)==0){
                //equals,insert h in mid position
                return mid+1;
            }
            else if(list.get(mid).compareTo(h)>0){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }

    public  void binarySort(Huluwa[]huluwas){
        ArrayList<Huluwa>list=new ArrayList<>(Arrays.asList(huluwas));
        for(int i=1;i<list.size();++i){
            //put the ith element in the right place
            //find right place in 0~i
            Huluwa h=list.get(i);
            int putIndex=findPlace(list,0,i-1,h);
            if(putIndex!=i){
                list.remove(i);
                list.add(putIndex,h);
                h.descMove(i,putIndex);
            }
        }
        System.arraycopy(list.toArray(),0,huluwas,0,huluwas.length);
//        showAllColor(huluwas);
    }

    public void shuffle(Huluwa[]huluwas){
        ArrayList<Huluwa>list=new ArrayList<>(Arrays.asList(huluwas));
        Collections.shuffle(list);//打乱
        int i=0;
        for(Huluwa h:list){
            huluwas[i]=h;
            ++i;
        }
//        System.out.println("打乱");
//        showAllName(huluwas);
//        System.out.println("");
    }

    public void showAllName(Huluwa[]huluwas){
        System.out.println("");
        for(int i=0;i<huluwas.length;++i){
            huluwas[i].descName();
        }
        System.out.println("");
    }

    public void showAllColor(Huluwa[]huluwas){
        System.out.println("");
        for(int i=0;i<huluwas.length;++i){
            huluwas[i].descColor();
        }
        System.out.println("");
    }

    public static  void main(String[]args){
        String[]names={"老大","老二","老三","老四","老五","老六","老七"};
        String[]colors={"红","橙","黄","绿","青","蓝","紫"};
        Huluwa[]huluwas=new Huluwa[7];//create huluwas
        for(int i=0;i<7;++i){
            huluwas[i]=new Huluwa(i,names[i],colors[i]);
        }

        Sort s=new Sort();
        System.out.println("bubbleSort:");
        s.shuffle(huluwas);
        s.bubbleSort(huluwas);
        s.showAllName(huluwas);
        System.out.println("binarySort:");
        s.shuffle(huluwas);
//        s.showAllName(huluwas);
        s.binarySort(huluwas);
        s.showAllColor(huluwas);
    }
}
