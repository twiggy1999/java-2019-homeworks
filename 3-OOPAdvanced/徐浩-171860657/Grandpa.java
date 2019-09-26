public class Grandpa extends Leader
{
    public Grandpa()
    {
        super("爷爷",true);
    }
    public void setGrandpa(int x,int y,Map map)
    {
        map.setMap(x,y,true,false,"G");
    }
}
