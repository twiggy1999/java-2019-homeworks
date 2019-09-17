/*
 * 用于维护生物的位置。作为生物的构成部分。
 */

import java.util.Random;

import static java.lang.Math.*;

public class Position {
    private int x,y;
    public Position(int _x,int _y){
        x=_x;
        y=_y;
    }

    public void setPos(int _x,int _y){
        x=_x;
        y=_y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    /*
     * 返回两个位置在8邻域下是否相邻。
     */
    public boolean adjacentWith(Position another){
        return abs(another.x-x)<=1 && abs(another.y-y)<=1;
    }

    public boolean equals(Position another){
        return another.x==x && another.y==y;
    }

    public Position adjacentPosition(Direction dir){
        return new Position(x+dir.dx(),y+dir.dy());
    }

    public String toString(){
        return "("+x+", "+y+")";
    }

    public Position copy(){
        return new Position(x,y);
    }

}
