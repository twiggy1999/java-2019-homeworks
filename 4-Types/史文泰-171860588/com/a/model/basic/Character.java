package com.a.model.basic;

import com.all.model.Picture;
import com.all.model.Point;
import com.all.model.NMap;
import com.all.move.MoveInterface;
import com.all.utils.ClassGenerator;
import javafx.scene.image.Image;

public class Character{
    private Picture picture;
    private Point point;
    private Point destPoint;
    private MoveInterface moveLeft;
    private MoveInterface moveRight;
    private MoveInterface moveUp;
    private MoveInterface moveDown;
    private MoveServer moveServer;

    public Character(){}
    public Character(int px, int py, Image image) throws Exception {
        this.point = new Point(px, py);
        this.picture = new Picture(this.point, image);
        this.destPoint = null;
        moveServer = new MoveServer();
//        moveLeft = new MoveLeft();
//        moveRight = new MoveRight();
//        moveUp = new MoveUp();
//        moveDown = new MoveDown();
        moveLeft = (MoveInterface)ClassGenerator.generateClassObject(
                ClassGenerator.generateClassConstructor(
                        "com.d.move.MoveLeft"));
        moveRight = (MoveInterface)ClassGenerator.generateClassObject(
                ClassGenerator.generateClassConstructor(
                        "com.d.move.MoveRight"));
        moveUp = (MoveInterface)ClassGenerator.generateClassObject(
                ClassGenerator.generateClassConstructor(
                        "com.d.move.MoveUp"));
        moveDown = (MoveInterface)ClassGenerator.generateClassObject(
                ClassGenerator.generateClassConstructor(
                        "com.d.move.MoveDown"));
    }

    public int getPx(){
        return this.point.getPx();
    }
    public int getPy() { return this.point.getPy(); }
    public Image getImage(){
        return this.picture.getImage();
    }
    public Picture getPicture(){
        return this.picture;
    }
    public Point getDestPoint(){
        return this.destPoint;
    }
    public void setDestPoint(int destPx, int destPy){
        destPoint = new Point(destPx, destPy);
    }

    public void changePosition(){
        int px = this.destPoint.getPx();
        int py = this.destPoint.getPy();
        boolean isChanged = false;
//        System.out.print("Current: (" + this.getPx() + ", " + this.getPy() + ")        ");
        if (this.getPx() != px || this.getPy() != py){
            if(this.getPx() < px && NMap.notOccupiedRight(this.point)){
                moveServer.move(moveRight, this.picture, this.point);
                isChanged = true;
            }else if(this.getPx() > px && NMap.notOccupiedLeft(this.point)){
                moveServer.move(moveLeft, this.picture, this.point);
                isChanged = true;
            }else if(this.getPy() < py && NMap.notOccupiedDown(this.point)){
                moveServer.move(moveDown, this.picture, this.point);
                isChanged = true;
            }else if(this.getPy() > py && NMap.notOccupiedUp(this.point)){
                moveServer.move(moveUp, this.picture, this.point);
                isChanged = true;
            }
            if(!isChanged){
                if(NMap.notOccupiedLeft(this.point)){
                    moveServer.move(moveLeft, this.picture, this.point);
                    isChanged = true;
                }else if(NMap.notOccupiedRight(this.point)){
                    moveServer.move(moveRight, this.picture, this.point);
                    isChanged = true;
                }else if(NMap.notOccupiedDown(this.point)){
                    moveServer.move(moveDown, this.picture, this.point);
                    isChanged = true;
                }else if(NMap.notOccupiedUp(this.point)){
                    moveServer.move(moveUp, this.picture, this.point);
                    isChanged = true;
                }
            }
        }
        if(isChanged){
            try {
                Thread.sleep(201);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        System.out.println("Destination: (" + px + ", " + py + ")");
//        System.out.println("After: (" + this.getPx() + ", " + this.getPy() + ")     isChanged = " + isChanged);
    }

    /**
     * 判断自身有没有移动到位
     */
    public boolean moveIsOver(){
        if(destPoint == null){
            return false;
        }
        return (this.point.getPx() == this.destPoint.getPx() && this.point.getPy() == this.destPoint.getPy());
    }

}
