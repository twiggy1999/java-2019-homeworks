import java.util.Scanner;

public class Confrontation
{
    private static Map mainMap;
    private static CalabashBrothers cbs;
    private static BadGuys bgs;

    public static void main(String[] args)
    {
        initFight();
    }

    public static void initFight()
    {/*
        System.out.println("Plz initialize the number of bad guys:");
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();

        System.out.println("Plz choose the type of formation(1~8):");
        int mode=in.nextInt();

        System.out.println("Plz set the center of the bad guys(eg:10 10):");
        int x1=in.nextInt();
        int y1=in.nextInt();
        Position pos1=new Position(x1,y1);

        System.out.println("Plz set the center of the Calabash Brothers(eg:10 3):");
        int x2=in.nextInt();
        int y2=in.nextInt();

        bgs=new BadGuys(mode,n,pos1,mainMap);
        cbs=new CalabashBrothers(x2,y2,mainMap);
*/
        for (int i =1; i < 9; i++) {
            mainMap=new Map();
            bgs=new BadGuys(i,10,new Position(10,11),mainMap);
            bgs.setBadguy(mainMap);
            cbs=new CalabashBrothers(10,4,mainMap);
            cbs.setCalabashBrothers(mainMap);

            Grandpa gp=new Grandpa();
            gp.setGrandpa(10,0,mainMap);

            SerpentDemon sd=new SerpentDemon();
            sd.setSerpentDemon(10,19,mainMap);

            mainMap.printMap();

            try
            {Thread.sleep(900);
            }
            catch (InterruptedException e)
            {
                System.out.println("----------------------------");
            }
        }

    }

}



