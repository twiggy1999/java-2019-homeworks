import java.util.Random;
class Huluwa {
    private String rank;
    private String color;
    private int num;
    public Huluwa(int i) {
        num=i;
        switch(i){
            case 1:rank="老大";color="红";break;
            case 2:rank="老二";color="橙";break;
            case 3:rank="老三";color="黄";break;
            case 4:rank="老四";color="绿";break;
            case 5:rank="老五";color="青";break;
            case 6:rank="老六";color="蓝";break;
            case 7:rank="老七";color="紫";break;
            default: break;
        }
    }
    public void printRank()
    {
        System.out.printf("%s",rank);
    }
    public void printColor()
    {
        System.out.printf("%s",color);
    }
    public int getnum()
    {
        return num;
    }
    public String getRank()
    {
        return rank;
    }
    public String getColor()
    {
        return color;
    }
}
public class huluwaOrientedProgramming{
    private static Random rand = new Random();
    public static void random(Huluwa [] hulus)
    {
        for ( int i = 6; i > 0; i-- ){
            int randInd = rand.nextInt(i);
            swap(hulus, randInd, i - 1);
        }
    }
    public static void swap(Huluwa[] hulus, int i, int j) {
        Huluwa temp = hulus[i];
        hulus[i] = hulus[j];
        hulus[j] = temp;
    }
    public static void reportRank(Huluwa []hulus)
    {
        int i=0;
        for(;i<hulus.length-1;i++)
        {
            hulus[i].printRank();
            System.out.printf(" ");
        }
        hulus[i].printRank();
        System.out.printf("\n");
    }
    public static void reportColor(Huluwa []hulus)
    {
        int i=0;
        for(;i<hulus.length-1;i++)
        {
            hulus[i].printColor();
            System.out.printf(" ");
        }
        hulus[i].printColor();
        System.out.printf("\n");
    }
    public static void bubbleSort(Huluwa[] hulus) {
        int last=hulus.length-1;

        for(int i=0;i<hulus.length-1;i++)
        {
            boolean ifex=false;
            int tmp=0;
            for(int j=0;j<last;j++)
            {
                if(hulus[j].getnum()>hulus[j+1].getnum()) {
                    System.out.printf("%s:%d->%d\n",hulus[j].getRank(),j,j+1);
                    System.out.printf("%s:%d->%d\n\n",hulus[j+1].getRank(),j+1,j);
                    swap(hulus,j,j+1);
                    tmp=j;
                    ifex=true;
                }
            }

            if(!ifex)
                return;
            last=tmp;
        }
    }
    public static void dichotomySort(Huluwa[] hulus) {
        for(int i=0;i<hulus.length;i++)
        {
            int left=0,right=i-1;
            Huluwa tmp=hulus[i];
            while(left<=right)
            {
                int mid=(left+right)/2;
                if(hulus[mid].getnum()>tmp.getnum())
                    right=mid-1;
                else
                    left=mid+1;
            }
            System.out.printf("\n");
            for(int j=i;j>left;j--)
            {
                System.out.printf("%s:%d->%d\n",hulus[j-1].getRank(),j-1,j);
                hulus[j] = hulus[j - 1];
            }
            System.out.printf("%s:%d->%d\n",tmp.getRank(),i,left);
            if(left!=i)
                hulus[left]=tmp;

        }
    }

    public static void main(String[] args) {
        Huluwa hulus[]=new Huluwa[7];
        for(int i=1;i<=7;i++)
        {
            hulus[i-1]=new Huluwa(i);
            // hulus[i-1].printColor();
        }
        System.out.printf("random: ");
        random(hulus);
        reportRank(hulus);
        System.out.printf("bubbleSort: \n");
        bubbleSort(hulus);
        reportRank(hulus);

        System.out.printf("\nrandom: ");
        random(hulus);
        reportColor(hulus);
        System.out.printf("dichotomySort: ");
        dichotomySort(hulus);
        reportColor(hulus);

    }

}
