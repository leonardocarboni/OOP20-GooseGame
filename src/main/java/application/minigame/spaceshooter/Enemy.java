package application.minigame.spaceshooter;

import javafx.scene.image.Image;

public class Enemy extends Player{


    private boolean destroyed;
    private int shot_received = 0;
    private int speed = Info.score+5;

    public Enemy(int posX, int posY, int size, Image image_enemy) {
        super(posX,posY,size,image_enemy);

    }

    public void update(){
        super.update();
        if(!destroyed){
            posY += speed;
        } else{
            this.destroyed = true;
        }
    }

}
