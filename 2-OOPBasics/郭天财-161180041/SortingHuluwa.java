import java.util.*;




enum Order{
    老大(1),老二(2),老三(3),老四(4),老五(5),老六(6),老七(7);
    private int index;

    private Order(){this.index = 0;}
    private Order(int index){
        this.index = index;
    }

    public int getIndex(){return index;}
}

enum Color{
    红色(1),橙色(2),黄色(3),绿色(4),青色(5),蓝色(6),紫色(7);
    private int index;
    private Color(){this.index = 0;}
    private Color(int index){
        this.index = index;
    }

    public int getIndex(){return index;}
}

class Huluwa{
    String color;
    String order;
    Huluwa() {color = "红色"; order = "老大"; }
    Huluwa(String c, String Ord){
        color = c;
        order = Ord;
    }
    

    public void setID(String c, String Ord){
        color = c;
        order = Ord;
    }

    public String getOrder(){
        return order;
    }
    public String getColor(){
        return color;
    }
}

public class SortingHuluwa{
    public static void main(String[] args){
        Huluwa[] Brothers;
        Brothers = new Huluwa[7];
        
        randomSort(Brothers);
        BubbleSort(Brothers);
        randomSort(Brothers);
        BinarySort(Brothers);
    }

    //随机站队
    public static void randomSort(Huluwa[] Brothers){
        List<Integer> list = new ArrayList<Integer>();
        Random rand = new Random();
        int i = 0;
        while(list.size() < Brothers.length){
            int num = rand.nextInt(Brothers.length);
            if(!list.contains(num)){
                list.add(num);
                Brothers[num] = new Huluwa(Color.values()[i].name(), Order.values()[i].name());
                i++;
            }
        }
        System.out.println("**************************************************");
        System.out.println("Initialized order: ");
        for(i = 0; i < Brothers.length; i++)
            System.out.println("    "+Brothers[list.get(i)].getOrder()+": "+list.get(i));
        
        System.out.println("**************************************************");
    }

    //冒泡排序
    public static void BubbleSort(Huluwa[] Brothers){
        
        System.out.println("**************************************************");
        System.out.println("BubbleSort: ");
        for(int i = 0; i < Brothers.length; i++){
            for(int j = 0; j < Brothers.length - i - 1; j++){
                if(Order.valueOf(Brothers[j].getOrder()).getIndex() > Order.valueOf(Brothers[j+1].getOrder()).getIndex()){
                    System.out.println("    " + Brothers[j].getOrder()+": "+ j +"->"+ (j+1));
                    System.out.println("    " + Brothers[j+1].getOrder()+": "+ (j+1) +"->"+ j);
                    String color = Brothers[j].getColor(), order = Brothers[j].getOrder();
                    Brothers[j].setID(Brothers[j+1].getColor(), Brothers[j+1].getOrder());
                    Brothers[j+1].setID(color, order);
                }
            }
        }
        System.out.println("\n报数: ");
        for(int i = 0; i < Brothers.length; i++)
            System.out.println("    "+Brothers[i].getOrder());
        
        System.out.println("**************************************************");
    }

    public static void BinarySort(Huluwa[] Brothers){
        System.out.println("**************************************************");
        System.out.println("BinarySort: ");

        for(int i = 1; i < Brothers.length; i++){
            int value = Order.valueOf(Brothers[i].getOrder()).getIndex();
            Huluwa tmp = new Huluwa(Brothers[i].getColor(), Brothers[i].getOrder());
            int insertLoc = BinarySearch(Brothers, 0, i-1, value);
            for(int j = i; j > insertLoc; j--){
                System.out.println("    " + Brothers[j].getOrder()+": "+ j +"->"+ (j-1));
                String color = Brothers[j-1].getColor();
                String order = Brothers[j-1].getOrder();
                Brothers[j].setID(color, order);
            }
            System.out.println("    " + Brothers[insertLoc].getOrder()+": "+ insertLoc +"->"+ i);
            String color = tmp.getColor();
            String order = tmp.getOrder();
            Brothers[insertLoc].setID(color, order);
        }
        System.out.println("\n报数: ");
        for(int i = 0; i < Brothers.length; i++)
            System.out.println("    "+Brothers[i].getOrder());

        System.out.println("**************************************************");
    }

    public static int BinarySearch(Huluwa[] Brothers, int l, int r, int value){
        int mid = -1;
        while(l <= r){
            mid = (l + r)/2;
            if(Color.valueOf(Brothers[mid].getColor()).getIndex() < value)l = mid + 1;
            else if(Color.valueOf(Brothers[mid].getColor()).getIndex() > value)r = mid - 1;
            else break;
        }
        if(Color.valueOf(Brothers[mid].getColor()).getIndex() < value)return mid + 1;
        else if(Color.valueOf(Brothers[mid].getColor()).getIndex() > value)return mid;
        return mid + 1;
    }
}

