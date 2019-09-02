package homeworks.sort.integer;

/**
 * Author:Wangmingxiao
 * Date:2019/9/2
 * Function:Implements sorting and outputting a given integer array
 */

public class SortInteger {

    public static void main(String[] args){
        int[] array = {5,2,8,4,6,9,1,7,3,0};
        System.out.print("Original array\n");
        print(array);
        System.out.print("After sorting(from small to large)\n");
        sort(array);
        print(array);
    }

    private static void sort(int[]array) {
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static void print(int[]array){
        System.out.print("Start printing\n");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i]+" ");
        System.out.print("\nFinish printing\n");
    }
}
