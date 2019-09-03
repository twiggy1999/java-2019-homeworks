
import java.util.*;
import java.io.*;
public class IntegerSort {
    public static void main(String[] args) {
        int nums[];
        nums=new int[5];
        System.out.println("Please input five integers:");
        for(int i=0;i<5;i++)
        {
            Scanner in=new Scanner(System.in);
            nums[i]=in.nextInt();
        }
        Arrays.sort(nums);
        for(int i=0;i<5;i++)
        {
            System.out.println(nums[i]);
        }
    }

}

