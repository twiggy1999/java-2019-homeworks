package com.swt.model.basic;

import com.swt.model.controlled.NMap;
import javafx.scene.image.Image;

public class Character {
    private Picture picture;
    private Point point;
    private Point destPoint;
    public Character(){}
    public Character(int px, int py, Image image){
        this.point = new Point(px, py);
        this.picture = new Picture(this.point, image);
        this.destPoint = null;
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

    private void moveLeft(){
        NMap.changeNMapLeft(this.point);
        this.picture.getPoint().setPx(this.point.getPx() - 1);
        this.point.setPx(this.point.getPx() - 1);
    }
    private void moveRight(){
        NMap.changeNMapRight(this.point);
        this.picture.getPoint().setPx(this.point.getPx() + 1);
        this.point.setPx(this.point.getPx() + 1);
    }
    private void moveUp(){
        NMap.changeNMapUp(this.point);
        this.picture.getPoint().setPy(this.point.getPy() - 1);
        this.point.setPy(this.point.getPy() - 1);
    }
    private void moveDown(){
        NMap.changeNMapDown(this.point);
        this.picture.getPoint().setPy(this.point.getPy() + 1);
        this.point.setPy(this.point.getPy() + 1);
    }

//    //检测要走的路径是否被占用
//    private boolean notOccupiedLeft(){
//        return (NMap.NMap[this.point.getPx() - 1][this.point.getPy()] == 0);
//    }
//    private boolean notOccupiedRight(){
//        return (NMap.NMap[this.point.getPx() + 1][this.point.getPy()] == 0);
//    }
//    private boolean notOccupiedUp(){
//        return (NMap.NMap[this.point.getPx()][this.point.getPy() - 1] == 0);
//    }
//    private boolean notOccupiedDown(){
//        return (NMap.NMap[this.point.getPx()][this.point.getPy() + 1] == 0);
//    }

//    public void draw(GraphicsContext graphicsContext){
//        this.SRCFile.draw(graphicsContext);
//    }

    public void changePosition(){
        int px = this.destPoint.getPx();
        int py = this.destPoint.getPy();
        boolean isChanged = false;
//        System.out.print("Current: (" + this.getPx() + ", " + this.getPy() + ")        ");
        if (this.getPx() != px || this.getPy() != py){
            if(this.getPx() < px && NMap.notOccupiedRight(this.point)){
                this.moveRight();
                isChanged = true;
            }else if(this.getPx() > px && NMap.notOccupiedLeft(this.point)){
                this.moveLeft();
                isChanged = true;
            }else if(this.getPy() < py && NMap.notOccupiedDown(this.point)){
                this.moveDown();
                isChanged = true;
            }else if(this.getPy() > py && NMap.notOccupiedUp(this.point)){
                this.moveUp();
                isChanged = true;
            }
            if(!isChanged){
                if(NMap.notOccupiedLeft(this.point)){
                    this.moveLeft();
                    isChanged = true;
                }else if(NMap.notOccupiedRight(this.point)){
                    this.moveRight();
                    isChanged = true;
                }else if(NMap.notOccupiedDown(this.point)){
                    this.moveDown();
                    isChanged = true;
                }else if(NMap.notOccupiedUp(this.point)){
                    this.moveUp();
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
     * @return
     */
    public boolean moveIsOver(){
        if(destPoint == null){
            return false;
        }
        return (this.point.getPx() == this.destPoint.getPx() && this.point.getPy() == this.destPoint.getPy());
    }

}
