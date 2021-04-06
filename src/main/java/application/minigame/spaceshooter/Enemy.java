package application.minigame.spaceshooter;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public class Enemy extends Player{


    //private int speed = Info.score+1;


    public Enemy(int posX, int posY, int size, Image image_enemy) {
        super(posX,posY,size,image_enemy);
    }


    public void update(){
        super.update();
        if(!destroyed && !exploding){
            position_player = new Point2D(position_player.getX(), position_player.getY()+calcSpeed());
        }
        if(this.position_player.getY()>Info.HEIGHT){
            destroyed = true;
        }
    }

    private int calcSpeed(){
        return (int) (Info.score +2) / 2;
    }

}
