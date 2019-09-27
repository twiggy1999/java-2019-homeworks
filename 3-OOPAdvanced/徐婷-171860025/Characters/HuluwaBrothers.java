public class HuluwaBrothers{
    private Huluwa[]  brothers;
    public HuluwaBrothers(){
        brothers=new Huluwa[7];
        List<Integer> list=new ArrayList<Integer>();
        for(int i=1;i<=7;i++)
            list.add(i);
        Collections.shuffle(list);
        for(int i=0;i<7;i++){
            String name;
            HuluwaColor color;
            switch(list(i)){
                case 1:name="老大";color=HuluwaColor.RED;break;
                case 2:name="老二";color=HuluwaColor.ORANGE;break;
                case 3:name="老三";color=HuluwaColor.YELLOW;break;
                case 4:name="老四";color=HuluwaColor.GREEN;break;
                case 5:name="老五";color=HuluwaColor.CYAN;break;
                case 6:name="老六";color=HuluwaColor.BLUE;break;
                case 7:name="老七";color=HuluwaColor.PURPLE;break;
            }
            brothers[i]=new Huluwa(new Position(2,i+3),name,list(i),color);
        }

    }
    public void Sort(){
        for(int i=6;i>=0;i--){
            for(int j=0;j<i;j++){
                if(brothers[j].getRank()>brothers[j+1].getRank()){
                    Huluwa tmp=brothers[j];
                    brothers[j].moveTo(brothers[j+1].getPos());
                    brothers[j+1].moveTo(tmp.getPos());
                }
            }
        }
    }
}