public class SerpentDemon extends Leader
{
    public SerpentDemon()
    {
        super("蛇精",false);
    }
    public void setSerpentDemon(int x,int y,Map map)
    {
        map.setMap(x,y,true,false,"S");
    }
}
