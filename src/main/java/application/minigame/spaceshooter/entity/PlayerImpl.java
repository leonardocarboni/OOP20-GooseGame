package application.minigame.spaceshooter.entity;

import application.minigame.spaceshooter.info.InfoGame;
import application.minigame.spaceshooter.interfaces.Player;
import application.minigame.spaceshooter.mainGame.SpaceShooter;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Implementation of {@link Player}.
 */
public class PlayerImpl implements Player {

    /**
     * I manage positions with a 2D vector.
     */
    public Point2D position_player;

    /**
     * Dimention of the player.
     */
    public final int size;

    /**
     * Boolean variables that say that: destroyed: the enemy is destroyed
     * exploding: if the variable is exploding.
     */
    public boolean destroyed;
    public boolean exploding;

    /**
     * The explosion animation is an image that has 14 sub-images This
     * variable takes into account which sub-image I am referring to
     */
    public int steps_img = 0;

    /**
     * Player image.
     */
    private final Image image;

    /**
     * Graphic context preso in maniera statica dalla classa SpaceShooter
     */
    private final GraphicsContext gc;

    /**
     * Create the player.
     * @param posX position X of the player.
     * @param posY position Y of the player.
     * @param size of the player.
     * @param player_image image of the player.
     */
    public PlayerImpl(final int posX, final int posY, final int size, Image player_image) {
        position_player = new Point2D(posX, posY);
        this.size = size;
        this.image = player_image;
        this.gc = SpaceShooter.gc;
    }

    @Override
    public void update() {
        if (exploding) {
            this.steps_img++;
        }
        destroyed = this.steps_img > InfoGame.EXPLOSION_IMG_NUM;
    }

    @Override
    public void draw() {
        if (!exploding) {
            gc.drawImage(this.image, position_player.getX(), position_player.getY(), this.size, this.size);
        } else {
            gc.drawImage(InfoGame.EXPLOSION_IMG, this.steps_img * InfoGame.EXPLOSION_WIDTH,
                    this.steps_img * InfoGame.EXPLOSION_HEIGHT + 1, InfoGame.EXPLOSION_WIDTH, InfoGame.EXPLOSION_HEIGHT,
                    position_player.getX(), position_player.getY(), size, size);
        }
    }

    @Override
    public ShotImpl shot() {
        return new ShotImpl((int) position_player.getX() + 5, (int) position_player.getY() + 5, InfoGame.SIZE_SHOT);
    }

    @Override
    public boolean touch(final Enemy enemy) {
        var distance_enemy_player = InfoGame.distance(this.position_player.getX() + size / (double) 3,
                this.position_player.getY() + size, enemy.position_player.getX() + enemy.size / (double) 3,
                enemy.position_player.getY() + enemy.size);
        return distance_enemy_player < enemy.size / (double) 3 + this.size / (double) 3;
    }

    @Override
    public void explode() {
        this.exploding = true;
        this.steps_img = -1;
    }

}
