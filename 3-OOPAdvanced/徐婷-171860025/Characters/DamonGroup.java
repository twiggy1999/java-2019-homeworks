enum ArrangeMent{HeYi,YanXing,HengE}

class DamonGroup{
    private Damon damons[];
    private ArrangeMent arrangement;
    public DamonGroup(int num){
        damons=new Damon[num];
        Heyi(7,6);
        arrangement=ArrangeMent.HeYi;
    }
    private void heYi(int x, int y){
        //7,6
        damons[0].setPos(new Position(x,y));
        damons[1].setPos(new Position(x+1,y-1));
        Damon[2].setPos(new Position(x+1,y+1));
        Damon[3].setPos(new Position(x+2,y+2));
        Damon[4].setPos(new Position(x+3,y+3));
        Damon[5].setPos(new Position(x+3,y-3));

    }

    private void yanXing(int x, int y){
        Damon[0].setPos(new Position(x,y));
        for(int i=1;i<=5;i++){
            Damon[i].setPos(new Position(x+i,y+i));
       }
    }

    public void hengE(int x, int y){
        Damon[0].setPos(new Position(x,y));
        Damon[1].setPos(new Position(x,y-2));
        Damon[2].setPos(new Position(x,y+2));
        Damon[3].setPos(new Position(x+1,y-1));
        Damon[4].setPos(new Position(x+1,y+1));
        Damon[5].setPos(new Position(x+1,y+3));
    }
    private void arrange(){
        switch(arrangement){
            case HeYi: yanXing(3,3);break;
            case YanXing:hengE(7,7);break;
            case hengE:heYi(7,6);break;
        }
    }
}