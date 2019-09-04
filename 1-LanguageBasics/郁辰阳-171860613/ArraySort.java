import java.util.Arrays;

public class ArraySort {
	
	public static void main(String[] args) {
		int [] array = {3,2,6,1,67,32,12,23,43};
		for(int cnt=1;cnt<array.length;cnt++) {
			int temp=0;
			for(int i=1;i<array.length;i++) {
				if(array[i]<array[i-1]) {
					temp=array[i];
					array[i]=array[i-1];
					array[i-1]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}
}
