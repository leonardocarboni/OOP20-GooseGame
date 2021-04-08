package application.minigame.spaceshooter.entity;

import application.minigame.spaceshooter.info.Info;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public class Enemy extends Player {


    public Enemy(int posX, int posY, int size, Image image_enemy) {
        super(posX,posY,size,image_enemy);
    }

    /**
     * L'update aggiorna la posizione Y con la funzione calcSpeed()
     * E se raggiunge la fine dello schermo si distrugge automaticamente
     */
    public void update(){
        super.update();
        if(!destroyed && !exploding){
            position_player = new Point2D(position_player.getX(), position_player.getY()+calcSpeed());
        }
        if(this.position_player.getY()> Info.HEIGHT){
            destroyed = true;
        }
    }

    /**
     * Funzione che calcola la velocita in base allo score
     * @return un intero che è la velocita
     */
    private int calcSpeed(){
        return (int) (Info.score +2) / 2;
    }


}