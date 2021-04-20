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
     * 
     * @param posX        position X of the enemy
     * @param posY        position Y of the enemy
     * @param size        of the enemy
     * @param imageEnemy image of the enemy
     */
    public Enemy(final int posX, final int posY, final int size, final Image imageEnemy) {
        super(posX, posY, size, imageEnemy);
    }

    /**
     * Update the enemy. If the shot goes out of the screen it is destroyed. If not
     * then update the position.
     */
    public void update() {
        super.update();
        if (!super.isDestroyed() && !super.isExploding()) {
            this.setPositionPlayer(new Point2D(super.getPositionPlayer().getX(), super.getPositionPlayer().getY() + calcSpeed()));
        }
        if (this.getPositionPlayer().getY() > InfoGame.HEIGHT) {
            super.setDestroyed(true);
        }
    }

    /**
     * Function that calculates the speed of the shot.
     * 
     * @return the speed.
     */
    private int calcSpeed() {
        return (InfoGame.getScore() + 2) / 2;
    }

}
