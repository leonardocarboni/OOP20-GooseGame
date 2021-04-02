package application.minigame.spaceshooter;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public class Enemy extends Player{


    public boolean destroyed;
    public Point2D position_enemy;
    private int shot_received = 0;
    private int speed = Info.score+5;

    public Enemy(int posX, int posY, int size, Image image_enemy) {
        super(posX,posY,size,image_enemy);
        position_enemy = new Point2D(posX, posY);
    }

    public void update(){
        super.update();
        if(!destroyed){
            position_enemy = new Point2D(position_enemy.getX(), position_enemy.getY()+10);
        } else{
            this.destroyed = true;
        }
    }

}
