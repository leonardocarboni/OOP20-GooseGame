package application.minigame.spaceshooter.entity;

import application.minigame.spaceshooter.info.InfoGame;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public class Enemy extends Player {


    public Enemy(int posX, int posY, int size, Image image_enemy) {
        super(posX,posY,size,image_enemy);
    }




    public void update(){
        super.update();
        if(!destroyed && !exploding){
            position_player = new Point2D(position_player.getX(), position_player.getY()+calcSpeed());
        }
        if(this.position_player.getY()> InfoGame.HEIGHT){
            destroyed = true;
        }
    }

    /**
     * Funzione che calcola la velocita in base allo score
     * @return un intero che è la velocita
     */
    private int calcSpeed(){
        return (InfoGame.score +2) / 2;
    }


}
