package application.minigame.spaceshooter.entity;

import application.minigame.spaceshooter.info.InfoGame;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;

/**
 * The enemy is a player with some changes. {@link PlayerImpl}
 */
public class Enemy extends PlayerImpl {

    /**
     * Create the enemy.
     * @param posX position X of the enemy
     * @param posY position Y of the enemy
     * @param size of the enemy
     * @param image_enemy image of the enemy
     */
    public Enemy(final int posX, final int posY, final int size, final Image image_enemy) {
        super(posX, posY, size, image_enemy);
    }

    /**
     * Update the enemy.
     * If the shot goes out of the screen it is destroyed.
     * If not then update the position.
     */
    public void update() {
        super.update();
        if (!destroyed && !exploding) {
            position_player = new Point2D(position_player.getX(), position_player.getY() + calcSpeed());
        }
        if (this.position_player.getY() > InfoGame.HEIGHT) {
            destroyed = true;
        }
    }

    /**
     * Function that calculates the speed of the shot.
     * 
     * @return the speed.
     */
    private int calcSpeed() {
        return (InfoGame.score + 2) / 2;
    }

}
