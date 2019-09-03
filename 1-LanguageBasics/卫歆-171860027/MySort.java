package bubblesort;

import java.util.Scanner;

public class MySort {
    private static int n;
    private static int array[];


    public static void sortArray() {//冒泡排序
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i] > array[j]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();//输入的数据个数
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        sortArray();
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");//输出排序后的数组
        }
        System.out.println();
    }
}
