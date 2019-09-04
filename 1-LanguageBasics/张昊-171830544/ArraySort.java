package ArraySort;

public class ArraySort {
    public static void main(string[] args){
        int[] array={-2,484,-13,21,234,46,654,6465,654,564};
        //sort(array,array.length);
        System.out.println(array.toString());
    }

    /*public static void sort(int[] array,int length) {
        for(int i = 0;i < length-1;i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[i] < array[j]) {
                    int tempt = array[i];
                    array[i] = array[j];
                    array[j] = tempt;
                }
            }
        }
    }*/
}
