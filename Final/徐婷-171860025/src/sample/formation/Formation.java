package sample.formation;
import sample.creatures.*;

import java.lang.reflect.Array;
import java.util.*;

public class Formation {
    /**可否直接生成一个生成队员的函数*/

    public static GoodTeam heYiGood(){
        GoodTeam good = new GoodTeam();
        List<Good> list = good.getSoldier();
        int x = 4, y = 4;
        list.get(0).setPos(x, y);
        list.get(1).setPos(x+1, y-1);
        list.get(2).setPos(x+1, y+1);
        list.get(3).setPos(x+2, y+2);
        list.get(4).setPos(x+2, y-2);
        list.get(5).setPos(x+3, y-3);
        list.get(6).setPos(x+3, y+3);
        return good;
    }

    public static BadTeam heYiBad(){
        BadTeam bad = new BadTeam(7);
        List<Bad> list = bad.getSoldier();
        list.get(0).setPos(10, 4);
        list.get(1).setPos(11, 3);
        list.get(2).setPos(11, 5);
        list.get(3).setPos(12, 3);
        list.get(4).setPos(12, 5);
        list.get(5).setPos(13, 3);
        list.get(6).setPos(12, 5);
        return bad;
    }
    public static GoodTeam yanXingGood(){
        GoodTeam good = new GoodTeam();
        List<Good>list = good.getSoldier();
        for(int i = 0;i<7;i++){
            list.get(i).setPos(i, i+1);
        }
        return good;
    }

    public static BadTeam yanXingBad(){
        BadTeam bad = new BadTeam(5);
        List<Bad> list = bad.getSoldier();
        list.get(0).setPos(11, 4);
        list.get(1).setPos(12, 3);
        list.get(2).setPos(13, 2);
        list.get(3).setPos(10, 5);
        list.get(4).setPos(9, 6);
        return bad;
    }

    public static GoodTeam hengEGood(){
        GoodTeam good = new GoodTeam();
        List<Good>list = good.getSoldier();
        list.get(0).setPos(2, 2);
        list.get(1).setPos(2, 4);
        list.get(2).setPos(2, 6);
        list.get(3).setPos(1, 1);
        list.get(4).setPos(1, 3);
        list.get(5).setPos(1, 5);
        list.get(6).setPos(1, 6);
        return good;
    }

    public static BadTeam hengEBad(){
        BadTeam bad = new BadTeam(6);
        List<Bad> list = bad.getSoldier();
        list.get(0).setPos(12, 2);
        list.get(1).setPos(12, 4);
        list.get(2).setPos(12, 6);
        list.get(3).setPos(13, 1);
        list.get(4).setPos(13, 3);
        list.get(5).setPos(13, 5);
        return bad;
    }

    public static GoodTeam changSheGood(){
        GoodTeam good = new GoodTeam();
        List<Good> list = good.getSoldier();
        for(int i = 0;i< 7;i++){
            list.get(i).setPos(1, i+1);
        }
        return good;
    }

    public static BadTeam changSheBad(){
        BadTeam bad = new BadTeam(7);
        List<Bad>list = bad.getSoldier();
        for(int i = 0;i<7;i++){
            list.get(i).setPos(13, i+1);
        }
        return bad;
    }

    public static BadTeam yuLingBad(){
        BadTeam bad = new BadTeam(10);
        List<Bad>list = bad.getSoldier();
        list.get(0).setPos(9,4);
        list.get(1).setPos(10, 3);
        list.get(2).setPos(11, 2);
        list.get(3).setPos(11, 4);
        list.get(4).setPos(11, 6);
        list.get(5).setPos(12, 1);
        list.get(6).setPos(12, 3);
        list.get(7).setPos(12, 5);
        list.get(8).setPos(12, 7);
        list.get(9).setPos(13, 4);
        return bad;
    }

    public static BadTeam fangYuanBad(){
        BadTeam bad = new BadTeam(8);
        List<Bad>list = bad.getSoldier();
        list.get(0).setPos(9, 4);
        list.get(1).setPos(10, 3);
        list.get(2).setPos(10, 5);
        list.get(3).setPos(11, 2);
        list.get(4).setPos(11, 6);
        list.get(5).setPos(12, 3);
        list.get(6).setPos(12, 5);
        list.get(7).setPos(13, 4);
        return bad;
    }

    public static BadTeam yanYueBad(){
        BadTeam bad = new BadTeam(19);
        List<Bad>list = bad.getSoldier();
        list.get(0).setPos(7, 4);
        list.get(1).setPos(7, 3);
        list.get(2).setPos(7, 5);
        list.get(3).setPos(9, 3);
        list.get(4).setPos(9, 4);
        list.get(5).setPos(9, 5);
        list.get(6).setPos(11, 3);
        list.get(7).setPos(11, 4);
        list.get(8).setPos(11, 5);
        list.get(9).setPos(10, 2);
        list.get(10).setPos(10, 6);
        list.get(11).setPos(11, 1);
        list.get(12).setPos(11, 7);
        list.get(13).setPos(12, 2);
        list.get(14).setPos(12, 6);
        list.get(15).setPos(13, 1);
        list.get(16).setPos(13, 7);
        list.get(17).setPos(14, 0);
        list.get(18).setPos(15, 8);
        return bad;
    }

    public static GoodTeam fengShiGood(){
        GoodTeam good = new GoodTeam();
        List<Good>list = good.getSoldier();
        list.get(0).setPos(4, 4);
        list.get(1).setPos(5, 3);
        list.get(2).setPos(5, 5);
        list.get(3).setPos(6, 2);
        list.get(4).setPos(6, 6);
        list.get(5).setPos(4, 6);
        list.get(6).setPos(4, 7);
        return good;
    }

    public static BadTeam fengShiBad(){

        BadTeam bad = new BadTeam(12);
        List<Bad>list = bad.getSoldier();
        list.get(0).setPos(9, 4);
        list.get(1).setPos(10, 3);
        list.get(2).setPos(10, 4);
        list.get(3).setPos(10, 5);
        list.get(4).setPos(11, 2);
        list.get(5).setPos(11, 4);
        list.get(6).setPos(11, 6);
        list.get(7).setPos(12, 1);
        list.get(8).setPos(12, 4);
        list.get(9).setPos(12, 7);
        list.get(10).setPos(13, 4);
        list.get(11).setPos(13, 4);
        return bad;
    }


//
//    private static <T extends Creature> void preprocess(List<T>list, int end){
//        for(T c :list){
//            c.setState(State.DEAD);
//        }
//        for(int i = 0;i<end;i++){
//            list.get(i).setState(State.LIVE);
//        }
//    }
//    public static <T extends Creature>void heYi(List<T>list, int x, int y){
//        preprocess(list, 7);
//        list.get(0).setPos(x, y);
//        list.get(1).setPos(x+1, y-1);
//        list.get(2).setPos(x+1, y+1);
//        list.get(3).setPos(x+2, y+2);
//        list.get(4).setPos(x+2, y-2);
//        list.get(5).setPos(x+3, y-3);
//        list.get(6).setPos(x+3, y+3);
//    }
//    public static <T extends Creature> void yanXing(List<T>list, int x, int y){
//        preprocess(list, 5);
//        list.get(0).setPos(x, y);
//        for(int i = 1;i<5;i++){
//            list.get(i).setPos(x+i, y+i);
//        }
//    }
//    public static<T extends Creature> void hengE(List<T> list, int x, int y){
//        preprocess(list, 6);
//        list.get(0).setPos(x, y);
//        list.get(1).setPos(x, y-2);
//        list.get(2).setPos(x, y+2);
//        list.get(3).setPos(x+1, y-1);
//        list.get(4).setPos(x+1, y+1);
//        list.get(5).setPos(x+1, y+3);
//    }
//    public static<T extends Creature> void yuLing(List<T>list, int x, int y){
//        preprocess(list, 10);
//        list.get(0).setPos(x, y);
//        list.get(1).setPos(x+1, y+1);
//        list.get(2).setPos(x+2, y-2);
//        list.get(3).setPos(x+2, y);
//        list.get(4).setPos(x+2, y+2);
//        list.get(5).setPos(x+3, y-3);
//        list.get(6).setPos(x+3, y-1);
//        list.get(7).setPos(x+3, y+1);
//        list.get(8).setPos(x+3, y+3);
//        list.get(9).setPos(x+4, y);
//    }
//    public static <T extends Creature> void fangYuan(List<T>list, int x, int y){
//        preprocess(list, 8);
//        list.get(0).setPos(x, y);
//        list.get(1).setPos(x+1, y-1);
//        list.get(2).setPos(x+1, y+1);
//        list.get(3).setPos(x+2, y-2);
//        list.get(4).setPos(x+2, y+2);
//        list.get(5).setPos(x+3, y-1);
//        list.get(6).setPos(x+3, y+1);
//        list.get(7).setPos(x+4, y);
//    }
//    public static <T extends Creature> void yanYue(List<T>list, int x, int y){
//        preprocess(list, 19);
//        list.get(0).setPos(x, y);
//        list.get(1).setPos(x, y+1);
//        list.get(2).setPos(x, y-1);
//        for(int i = -1;i<=1;i++){
//            list.get(4+i).setPos(x+2, y+i);
//        }
//        list.get(6).setPos(x+3,y+2);
//        list.get(7).setPos(x+3, y-2);
//        list.get(8).setPos(x+4, y+3);
//        list.get(9).setPos(x+4, y-3);
//        list.get(10).setPos(x+4, y+1);
//        list.get(11).setPos(x+4, y);
//        list.get(12).setPos(x+4, y-1);
//        list.get(13).setPos(x+5, y+2);
//        list.get(14).setPos(x+5, y-2);
//        list.get(15).setPos(x+6, y-3);
//        list.get(16).setPos(x+6, y+3);
//        list.get(17).setPos(x+7, y-4);
//        list.get(18).setPos(x+7, y+4);
//
//    }
//    public static <T extends Creature> void fengShi(List<T>list, int x, int y){
//        preprocess(list, 12);
//        list.get(0).setPos(x, y);
//        for(int i = 0;i<3;i++){
//            list.get(i*3+1).setPos(x+i+1, y);
//            list.get(i*3+2).setPos(x+i+1, y-i-1);
//            list.get(i*3+3).setPos(x+i+1, y+i+1);
//        }
//        list.get(10).setPos(x+4,y);
//        list.get(11).setPos(x+5, y);
//
//    }
//    public static <T extends Creature> void changShe(List<T>list, int x, int y){
//        preprocess(list, 7);
//        for(int i = 0;i<7;i++){
//            list.get(i).setPos(x, y+i);
//        }
//    }
}

