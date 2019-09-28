package com.swt.model.advance;

import com.swt.model.basic.Character;
import com.swt.model.basic.Picture;
import com.swt.model.basic.Point;
import com.swt.model.controlled.EnemyTeam;
import com.swt.control.Formation;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Snake extends Character {
    private Picture orderPicture;
    public Snake(int px, int py, Image image, Picture orderPicture){
        super(px, py, image);
        this.orderPicture = orderPicture;
    }

    /**
     * 命令队伍改变阵型
     * @param enemyTeam
     * @param path
     * @throws IOException
     */
    public void Order(EnemyTeam enemyTeam, String path, String orderPath) throws IOException {
        FileInputStream fis = new FileInputStream(new File(orderPath));
        Image image = new Image(fis);
        orderPicture = new Picture(new Point(7, 0), image);
        enemyTeam.ChangeFormation(Formation.getPointList(path));
    }

    public Picture getOrderPicture(){
        return orderPicture;
    }

}
