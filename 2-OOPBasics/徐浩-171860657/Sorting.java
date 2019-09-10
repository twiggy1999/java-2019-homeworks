import java.util.*;

enum Color{RED,ORANGE,YELLOW,GREEN,CYAN,BLUE,PURPLE};

public class Sorting
{
    //get a n-size random array (min~max)
    public static int[] randomArray(int min, int max, int n){
        if (n > (max - min + 1) || max < min) {
            return null;
        }
        int[] result = new int[n];
        int count = 0;
        while(count < n) {
            int num = (int) (Math.random() * (max - min+1)) + min;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if(num == result[j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                result[count] = num;
                count++;
            }
        }
        for(int i=0;i<n;i++)
            result[i]--;
        return result;
    }

    //BubbleSort
    public static void bubbleSort(CalabashBrother[] bros)
    {
        for(int i=0;i<bros.length-1;i++)
        {
            for (int j = i + 1; j < bros.length; j++)
            {
                if (bros[i].getColor().ordinal() > bros[j].getColor().ordinal() )
                //if (bros[i].getPosition() > bros[j].getPosition() )
                {
                    CalabashBrother tmp = bros[i];
                    bros[i] = bros[j];
                    bros[j] = tmp;

                    System.out.println(bros[i].getRank()+":"+j+"->"+i);
                    System.out.println(bros[j].getRank()+":"+i+"->"+j);
                }
            }
        }
        for(CalabashBrother tmp:bros)
        {
            System.out.print(tmp.getRank()+"\t");
        }
        System.out.println();
    }

    public static int partition(CalabashBrother[] bros,int begin,int end)
    {
        CalabashBrother tmp=bros[begin];
        int i=begin,j=end;
        while(i<j)
        {
            while((i<j)&&(bros[j].getColor().ordinal()>=tmp.getColor().ordinal()))   j--;
            if(i<j)
            {
                System.out.println(bros[i].getRank()+":"+i+"->"+j);
                System.out.println(bros[j].getRank()+":"+j+"->"+i);
                bros[i] = bros[j];
            }
            while((i<j)&&(bros[i].getColor().ordinal()<=tmp.getColor().ordinal()))   i++;
            if(i<j)
            {
                System.out.println(bros[i].getRank()+":"+i+"->"+j);
                System.out.println(bros[j].getRank()+":"+j+"->"+i);
                bros[j] = bros[i];
            }
        }
        bros[i]=tmp;
        return i;
    }

    public static void binarySort(CalabashBrother[] bros,int begin,int end)
    {
        if(bros==null||begin>=end||bros.length<1)
            return;
        if(begin<end)
        {
            int mid = partition(bros, begin, end);
            binarySort(bros, begin, mid - 1);
            binarySort(bros, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        CalabashBrother[] bros = new CalabashBrother[7];
        int[] randomPos = randomArray(0, 7, 7);

/*print for testing
        for (int i : randomPos)
            System.out.print(i + "\t");
        System.out.println();
*/
        bros[randomPos[0]] = new CalabashBrother("RED","老大");
        bros[randomPos[1]] = new CalabashBrother("ORANGE", "老二");
        bros[randomPos[2]] = new CalabashBrother("YELLOW", "老三");
        bros[randomPos[3]] = new CalabashBrother("GREEN", "老四");
        bros[randomPos[4]] = new CalabashBrother("CYAN", "老五");
        bros[randomPos[5]] = new CalabashBrother("BLUE", "老六");
        bros[randomPos[6]] = new CalabashBrother("PURPLE", "老七");

        System.out.println("Bubble sort:");
        bubbleSort(bros);
        System.out.println();

        bros[randomPos[0]] = new CalabashBrother("RED","老大","红色");
        bros[randomPos[1]] = new CalabashBrother("ORANGE", "老二","橙色");
        bros[randomPos[2]] = new CalabashBrother("YELLOW", "老三","黄色");
        bros[randomPos[3]] = new CalabashBrother("GREEN", "老四","绿色");
        bros[randomPos[4]] = new CalabashBrother("CYAN", "老五","青色");
        bros[randomPos[5]] = new CalabashBrother("BLUE", "老六","蓝色");
        bros[randomPos[6]] = new CalabashBrother("PURPLE", "老七","紫色");

/*print for testing
        for (int i : randomPos)
            System.out.print(i + "\t");
        System.out.println();
*/

        System.out.println("Binary sort:");
        binarySort(bros,0,bros.length-1);
        for(CalabashBrother tmp:bros)
        {
            System.out.print(tmp.getColorName()+"\t");
        }
        System.out.println();
    }
}

class CalabashBrother
{
    private Color color;
    private String rank;
    private String colorName;

    public CalabashBrother(String col,String name)
    {
        color=Enum.valueOf(Color.class,col);
        rank=name;
    }
    public CalabashBrother(String col,String name,String colorname)
    {
        color=Enum.valueOf(Color.class,col);
        rank=name;
        colorName=colorname;
    }
    String getRank()
    {
        return rank;
    }
    Color getColor()
    {
        return color;
    }
    String getColorName()
    {
        return colorName;
    }
}