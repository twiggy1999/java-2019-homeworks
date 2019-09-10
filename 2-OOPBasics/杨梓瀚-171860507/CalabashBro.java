/*
    Homework-2
 */

import java.util.*;

class Calabash{
    private int seq;
    private String  color;

    Calabash(int s, String c){
        seq = s;
        color = c;
    }

    int getSeq(){
        return seq;
    }

    String getColor(){
        return color;
    }
}

public class CalabashBro {
    private static final int size = 7;
    private List<Calabash> calabashBros;
    private static final String[] color = {"红色", "橙色", "黄色", "绿色", "青色", "蓝色", "紫色"};
    private static final String[] name = {"老大", "老二", "老三", "老四", "老五", "老六", "老七"};

    CalabashBro(){
        calabashBros = new ArrayList<>();
        for (int i = 0; i < size; ++i){
            calabashBros.add(new Calabash(i,color[i]));
        }

    }

    private static boolean cmp(String a, String b){ //a排在b前面 Return true
        int i,j;
        for (i = 0; i < size; i++){
            if (a.equals(color[i]))
                break;
        }
        for (j = 0; j < size; j++){
            if (b.equals(color[j]))
                break;
        }

        return i < j;
    }

    private void bubbleSort(){
        for (int i = 0; i < size - 1; i++){
            for (int j = 0; j < size - 1 - i; j++){
                if (calabashBros.get(j+1).getSeq() < calabashBros.get(j).getSeq()){
                    System.out.print(name[calabashBros.get(j).getSeq()]+":"+j+"->"+(j+1)+"  ");
                    Collections.swap(calabashBros,j+1,j);
                }
            }
        }
        System.out.print('\n');
    }

    private void binarySort(){
        int left, right, mid;
        for (int i = 1; i < size; i++){
            Calabash calabash = calabashBros.get(i);
            left = 0;
            right = i - 1;
            while (left <= right){
                mid =left + (right - left) / 2;
                if (cmp(calabashBros.get(mid).getColor(),calabash.getColor())){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
            for (int j = i - 1; j >= left; j--){
                calabashBros.set(j+1,calabashBros.get(j));
            }
            System.out.print(name[calabash.getSeq()]+":"+i+"->"+left+"  ");
            calabashBros.set(left,calabash);
        }
        System.out.print('\n');
    }

    private void print(int tag){
        if (tag == 0){      //报数
            System.out.println("报数:");
            for (Calabash calabash: calabashBros) {
                System.out.print(name[calabash.getSeq()] + "  ");
            }
        }else { //报颜色
            System.out.println("报颜色:");
            for (Calabash calabash: calabashBros) {
                System.out.print(calabash.getColor() + "  ");
            }
        }
        System.out.print('\n');
    }

    public static void main(String []args){
        CalabashBro calabashBro = new CalabashBro();

        Collections.shuffle(calabashBro.calabashBros);
        System.out.println("排序前：");
        calabashBro.print(0);
        calabashBro.bubbleSort();
        System.out.println("排序后:");
        calabashBro.print(0);

        System.out.println("************************");

        Collections.shuffle(calabashBro.calabashBros);
        System.out.println("排序前:");
        calabashBro.print(1);
        calabashBro.binarySort();
        System.out.println("排序后:");
        calabashBro.print(1);
    }
}
