package firstprogramme;

public class Sorter {
    public static void main(String[] args)
    {
        int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};
        for(int i=0;i<numbers.length-1;i++)
        {
            int min=i;
            for(int j=i+1;j<numbers.length;j++)
            {
                if(numbers[j]<numbers[min]) min=j;
            }

            if(min!=i)
            {
                int temp = numbers[i];
                numbers[i] = numbers[min];
                numbers[min] = temp;
            }
        }

        for(int num : numbers) System.out.println(num);
    }
}
