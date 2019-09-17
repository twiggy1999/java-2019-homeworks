/*
 * 老人家类。负责“指挥”葫芦娃，维护葫芦娃列表。
 */

import java.util.Random;
public class Elder extends Living{
    private Calabash[] calabashes;

    /*
     * 老人家“种”出了葫芦娃
     * 随机产生位置并添加葫芦娃。
     */
    public Elder(Position pos, Field field_) {
        super(pos, field_);
        calabashes=new Calabash[7];
        Random random=new Random();
        for(int i=0;i<7;i++){
            Position position=new Position(random.nextInt(Field.N),
                    random.nextInt(Field.N));
            while (field_.livingAt(position)!=null) {
                position.setPos(random.nextInt(Field.N),
                        random.nextInt(Field.N));
            }
            Calabash cal=new Calabash(position,field_,i+1);
            calabashes[i]=cal;
            field_.addLiving(cal);
        }
    }
}
