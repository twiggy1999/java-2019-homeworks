class Snake extends Creature{
    Snake(Position p, String n){
        super(p,n);
    }
    public void cheer(){
        System.out.println(name+ ": 妖精加油!");
    }
    
}