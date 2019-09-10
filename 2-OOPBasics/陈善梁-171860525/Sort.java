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

    public void mergeSort(Huluwa[]huluwas,int start,int end){
        if(start>=end){
            return;
        }
        else{
            int mid=(start+end)/2;
            mergeSort(huluwas,start,mid);
            mergeSort(huluwas,mid+1,end);
            Huluwa[]ret=new Huluwa[end-start+1];
            int i=start;
            int j=mid+1;
            int k=0;
            while(i<=mid&&j<=end){
                if(huluwas[i].compareTo(huluwas[j])<=0){
                    huluwas[i].descMove(i,k+start);
                    ret[k]=huluwas[i];
                    ++i;
                }
                else{
                    huluwas[j].descMove(j,k+start);
                    ret[k]=huluwas[j];
                    ++j;
                }
                ++k;
            }
            while(i<=mid){
                huluwas[i].descMove(i,k+start);
                ret[k]=huluwas[i];
                ++i;
                ++k;
            }
            while(j<=end){
                huluwas[j].descMove(j,k+start);
                ret[k]=huluwas[j];
                ++j;
                ++k;
            }
            System.arraycopy(ret,0,huluwas,start,end-start+1);


        }
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
        Huluwa[]huluwas=new Huluwa[7];
        for(int i=0;i<7;++i){
            huluwas[i]=new Huluwa(i,names[i],colors[i]);
        }

        Sort s=new Sort();
        System.out.println("bubbleSort:");
        s.shuffle(huluwas);
        s.bubbleSort(huluwas);
        s.showAllName(huluwas);
        System.out.println("mergeSort:");
        s.shuffle(huluwas);
        s.mergeSort(huluwas,0,huluwas.length-1);
        s.showAllColor(huluwas);
    }
}
