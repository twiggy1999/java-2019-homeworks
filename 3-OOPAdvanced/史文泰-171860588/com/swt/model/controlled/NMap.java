package com.swt.model.controlled;

import com.swt.model.basic.Picture;
import com.swt.model.basic.Point;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NMap {
    private static Lock bufferLock = new ReentrantLock();
    private static int[][]NMap = //原始Map
            {{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
            {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
            {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
            {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
            {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
            {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
            {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
            {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
            {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
            {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}};
//    private static List<Point> occupiedList = new ArrayList<>();


    public static final int N = 10;    //10个格子
    private Picture picture1;
    private Picture picture2;

    public static void changeNMapLeft(Point point){
        bufferLock.lock();
        NMap[point.getPx() - 1][point.getPy()] = 1;
        NMap[point.getPx()][point.getPy()] = 0;
//        occupiedList.remove(point);
//        occupiedList.add(new Point(point.getPx() - 1, point.getPy()));
        bufferLock.unlock();
    }
    public static void changeNMapRight(Point point){
        bufferLock.lock();
        NMap[point.getPx() + 1][point.getPy()] = 1;
        NMap[point.getPx()][point.getPy()] = 0;
//        occupiedList.remove(point);
//        occupiedList.add(new Point(point.getPx() + 1, point.getPy()));
        bufferLock.unlock();
    }
    public static void changeNMapUp(Point point){
        bufferLock.lock();
        NMap[point.getPx()][point.getPy() - 1] = 1;
        NMap[point.getPx()][point.getPy()] = 0;
//        occupiedList.remove(point);
//        occupiedList.add(new Point(point.getPx(), point.getPy() - 1));
        bufferLock.unlock();
    }
    public static void changeNMapDown(Point point){
        bufferLock.lock();
        NMap[point.getPx()][point.getPy() + 1] = 1;
        NMap[point.getPx()][point.getPy()] = 0;
//        occupiedList.remove(point);
//        occupiedList.add(new Point(point.getPx(), point.getPy() + 1));
        bufferLock.unlock();
    }

    //检测要走的路径是否被占用
    public static boolean notOccupiedLeft(Point point) { return (NMap[point.getPx() - 1][point.getPy()] == 0); }
    public static boolean notOccupiedRight(Point point){ return (NMap[point.getPx() + 1][point.getPy()] == 0); }
    public static boolean notOccupiedUp(Point point){
        return (NMap[point.getPx()][point.getPy() - 1] == 0);
    }
    public static boolean notOccupiedDown(Point point){
        return (NMap[point.getPx()][point.getPy() + 1] == 0);
    }

    public NMap(String srcPath1, String srcPath2) throws IOException {
        FileInputStream fis;
        fis = new FileInputStream(new File(srcPath1));
        Image image1 = new Image(fis);
        fis = new FileInputStream(new File(srcPath2));
        Image image2 = new Image(fis);
        picture1 = new Picture(new Point(0, 0), image1);
        picture2 = new Picture(new Point(0, 0), image2);
        fis.close();
    }

    public Picture getPicture1(){
        return picture1;
    }
    public Picture getPicture2(){
        return picture2;
    }
}
