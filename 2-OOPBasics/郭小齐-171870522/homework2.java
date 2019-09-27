import java.util.*;
import java.util.Arrays;
import java.util.Scanner;

class huluwa
{
	int num;
	String name;
	String color;
	huluwa(int n)
	{
		num=n;
        switch(n)
        {
            case 1:name="老大";color="红色";break;
            case 2:name="老二";color="橙色";break;
            case 3:name="老三";color="黄色";break;
            case 4:name="老四";color="绿色";break;
            case 5:name="老五";color="青色";break;
            case 6:name="老六";color="蓝色";break;
            case 7:name="老七";color="紫色";break;
            default:break;
        }
	}
	
	void myName()
	{
		System.out.println(name);
	}
	
	void myColor()
	{
		System.out.println(color);
	}
}

public class huluwasort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] seven = new int[7];
		for(int i = 0; i<7; i++)
			seven[i]=i+1;
		int n = 7;
		int[] rank = new int[7];
		for(int i = 0; i < 7; i++)
		{
			int r = (int) (Math.random()*n);
			rank[i] = seven[r];
			seven[r] = seven[n-1];
			n--;
		}
		huluwa[] origin = new huluwa[7];
		huluwa h1 = new huluwa(rank[0]);origin[0] = h1;
		huluwa h2 = new huluwa(rank[1]);origin[1] = h2;
		huluwa h3 = new huluwa(rank[2]);origin[2] = h3;
		huluwa h4 = new huluwa(rank[3]);origin[3] = h4;
		huluwa h5 = new huluwa(rank[4]);origin[4] = h5;
		huluwa h6 = new huluwa(rank[5]);origin[5] = h6;
		huluwa h7 = new huluwa(rank[6]);origin[6] = h7;
		System.out.println("初始序列：");
		for(int i = 0; i<7; i++)
			origin[i].myName();
			
		//生成随机序列
		
		bubble(origin);
		//冒泡排序
		binary(origin);
		//二分法

	}
	
	public static void bubble(huluwa []a)
	{
		for(int i = 0;i<7;i++)
		{
			int j = i;
			for(int k = i+1;k<7;k++)
			{
				if(a[k].num<a[j].num)
					j = k;
					System.out.println(a[i].name+":"+(i+1)+"->"+(k+1));
					System.out.println(a[k].name+":"+(k+1)+"->"+(i+1));
					huluwa temp = a[i];
					a[i] = a[j];
					a[j] = temp;
			}
		}
		System.out.println("冒泡排序结果：");
		for(int i = 0; i<7; i++)
			a[i].myName();
	}
	//冒泡排序
	
	public static void binary(huluwa []a)
	{
		int start, mid, end;
		huluwa next;
		for(int i = 0; i<6; i++)
		{
			start = 0; mid = 0; end = i;
			next = a[i+1];
			while(start<=end)
			{
				mid=(start+end)/2;
				if(a[mid].num>next.num)
					end = mid-1;
				else
					start = mid+1;
			}
			for(int j = i; j>=end+1;j--)
			{
				System.out.println(a[j].name+":"+j+"->"+(j+1));
				a[j+1] = a[j];
			}
			if(end!=i)
				System.out.println(next.name+":"+(i+1)+"->"+(end+1));
			a[end+1] = next;
		}
		System.out.println("二分法结果");
		for(int i = 0;i<7;i++)
		{
			a[i].myName();a[i].myColor();
		}
	}
	//二分法排序

}
