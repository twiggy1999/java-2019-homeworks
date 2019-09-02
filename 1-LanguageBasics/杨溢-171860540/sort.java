import java.util.Scanner;
//快排，首先输入数字的数量，然后输入整型数字
public class sort {
    int data[];
    int lenth;
    public static void main(String[] args){
        sort s = new sort();
        s.scan();
    }
    public void scan(){
        Scanner in = new Scanner(System.in);
        lenth = in.nextInt();
        data = new int[lenth];
        for(int i=0; i<= lenth-1; i++){
            data[i] = in.nextInt();
        }
        qsort(0,lenth-1);
        for(int i=0; i<= lenth-1; i++){
            System.out.print(data[i]);
            System.out.print(' ');
        }
        System.out.print('\n');
    }
    public void qsort(int s, int e){

    }
    public void merge(int s, int e){

    }
}
