package com.swt.control;

import com.swt.model.basic.Point;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 工具类，读取文件返回坐标
 */
public class Formation {
    public static List<Point> getPointList(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        List<Point> list = new ArrayList<>();
        int x, y;
        while (scanner.hasNext()){
            x = scanner.nextInt();
            y = scanner.nextInt();
            list.add(new Point(x, y));
        }
        return  list;
    }
}
