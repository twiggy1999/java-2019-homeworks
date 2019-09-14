package com.work.person;
import java.util.Random;

public class Process {
    //private Hulu []arr={new Hulu(),new Hulu(),new Hulu()};
    private Hulu []arr=new Hulu[7];

    /*public void Process(){
        String rstr=genSevenRandom();
        for(int i=0;i<7;i++){

            Hulu h=new Hulu(rstr.charAt(i)-'0');
            arr[i]=h;
        }
    }*/

    public String genSevenRandom(){
        Random r=new Random();
        String ret="";
        while(ret.length()<7){
            //
            int v=r.nextInt(7)+1;
            char ch=(char)(v+'0');
            if(ret.indexOf(ch)==-1){
                ret=ret+ch;
            }
        }
        return ret;
    }

    public void queueRandom(){
        //Random r=new Random();
        String rstr=genSevenRandom();
        for(int i=0;i<7;i++){

            Hulu h=new Hulu(rstr.charAt(i)-'0');
            arr[i]=h;
        }
        System.out.println("随机站队：");
        reportNum();
    }

    public void reportNum(){
        for(int i=0;i<7;i++){
            arr[i].reportNum();
        }
        System.out.print('\n');
    }

    public void reportColor(){
        for(int i=0;i<7;i++){
            arr[i].reportColor();
        }
        System.out.print('\n');
    }

    void swap(int i, int j){
        System.out.print("SWAP: ");
        arr[i].reportNum();
        System.out.print(": "+i+"->"+j+"    ");
        arr[j].reportNum();
        System.out.print(": "+j+"->"+i+'\n');
        int temp=arr[i].val;
        arr[i].val=arr[j].val;
        arr[j].val=temp;
         //arr[i].reportNum()
    }

    public void queueBubble(){
        System.out.println("冒泡排序：");
        int i=0,j=0;
        for(i=0;i<7-1;i++){
            for(j=0;j<7-i-1;j++){
                if(arr[j].val>arr[j+1].val){
                    swap(j,j+1);
                }
            }
        }
        reportNum();
    }

    public void BianryInsertSort(){
        System.out.println("二分法：");
        for(int i=1;i<7;i++){
            Hulu temp=arr[i];
            int left=0,right=i;
            while(left<right){
                int mid=(left+right)/2;
                if(temp.val>=arr[mid].val){
                    left=mid+1;
                }
                else{
                    right=mid;
                }
            }
            for(int j=i;j>left;--j){
                swap(j-1,j);
            }
        }
        reportColor();
    }

    /*int bSearch(Hulu h, int begin,int end){
        if(begin==end){
            return (h.val>arr[begin].val)?(begin+1):begin;
        }
        else if(end-begin+1<3){
            if(h.val>arr[begin].val) return begin+1;
            else return begin;
        }
        int mid=(begin+end)/2;
        if(arr[mid].val==h.val){
            return mid+1;
        }
        else if(arr[mid].val<h.val){
            return bSearch(h,mid+1,end);
        }
        else return bSearch(h,begin,mid-1);
    }

    void binarySort(int lo,int hi,int start){
        if(start==lo) start++;
        for(;start<hi;start++){
            Hulu pivot=arr[start];

            int left = lo;
            int right = start;

            while(left<right){
                int mid=(left+right)>>>1;
                if(pivot.val<arr[mid].val){
                    right=mid;
                }
                else
                    left=mid+1;
            }
            int n = start - left;
            switch (n) {
                case 2:  {
                    arr[left + 2] = arr[left + 1];
                    arr[left+1].reportNum();
                    System.out.println(": "+(left+1)+"->"+(left+2));
                }
                case 1:  {
                    arr[left + 1] = arr[left];
                    arr[left].reportNum();
                    System.out.println(": "+(left)+"->"+(left+1));
                }
                    break;
                default: {
                    //System.arraycopy(a, left, a, left + 1, n);
                    for(int i=0;i<n;i++){
                        arr[left+1+i]=arr[left+i];
                        arr[left+i].reportNum();
                        System.out.println(": "+(left+i)+"->"+(left+1+i));
                    }
                }
            }
            arr[left] = pivot;
            pivot.reportNum();
            System.out.println(": "+(start)+"->"+(left));
        }
        report();
    }

    public void queueBISort(){
        int i=0,j=0;
        for(i=1;i<7;i++){
            j=i-1;
            //int temp=arr[i].val;
            Hulu temp=arr[i];
            int pos=bSearch(arr[i],0,j);
            while(j>pos){
                arr[j+1].val=arr[j].val;
                arr[j].reportNum();
                System.out.println(": "+j+"->"+(j+1));
                j--;
            }
            temp.reportNum();
            System.out.println(": "+i+"->"+j+1);
            arr[j+1].val=temp.val;
        }
        report();
    }*/

}
