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
     * Increment of the speed.
     */
    private static int incrementOfSpeed = 5;
    /**
     * I manage positions with a 2D vector.
     */
    private Point2D positionPlayer;

    /**
     * Dimention of the player.
     */
    private final int size;
    /**
     * Boolean variables that say that: destroyed: the enemy is destroyed.
     */
    private boolean destroyed;
    /**
     * Exploding:
     * if the variable is exploding.
     */
    private boolean exploding;

    /**
     * The explosion animation is an image that has 14 sub-images This variable takes into account which sub-image I am referring to.
     */
    private int stepsImg = 0;

    /**
     * Player image.
     */
    private final Image image;

    /**
     * Graphic context preso in maniera statica dalla classa SpaceShooter.
     */
    private final GraphicsContext gc;

    /**
     * Create the player.
     * 
     * @param posX         position X of the player.
     * @param posY         position Y of the player.
     * @param size         of the player.
     * @param playerImage image of the player.
     */
    public PlayerImpl(final int posX, final int posY, final int size, final Image playerImage) {
        positionPlayer = new Point2D(posX, posY);
        this.size = size;
        this.image = playerImage;
        this.gc = SpaceShooter.getGc();
    }

    @Override
    public void update() {
        if (exploding) {
            this.stepsImg++;
        }
        destroyed = this.stepsImg > InfoGame.EXPLOSION_IMG_NUM;
    }

    @Override
    public void draw() {
        if (!exploding) {
            gc.drawImage(this.image, positionPlayer.getX(), positionPlayer.getY(), this.size, this.size);
        } else {
            gc.drawImage(InfoGame.EXPLOSION_IMG, this.stepsImg * InfoGame.EXPLOSION_WIDTH,
                    this.stepsImg * InfoGame.EXPLOSION_HEIGHT + 1, InfoGame.EXPLOSION_WIDTH, InfoGame.EXPLOSION_HEIGHT,
                    positionPlayer.getX(), positionPlayer.getY(), size, size);
        }
    }

    @Override
    public ShotImpl shot() {
        return new ShotImpl((int) positionPlayer.getX() + incrementOfSpeed, (int) positionPlayer.getY() + incrementOfSpeed, InfoGame.SIZE_SHOT);
    }

    @Override
    public boolean touch(final Enemy enemy) {
        var distanceEnemyPlayer = InfoGame.distance(this.positionPlayer.getX() + size / (double) 3,
                this.positionPlayer.getY() + size, enemy.getPositionPlayer().getX() + enemy.getSize() / (double) 3,
                enemy.getPositionPlayer().getY() + enemy.getSize());
        return distanceEnemyPlayer < enemy.getSize() / (double) 3 + this.size / (double) 3;
    }

    @Override
    public void explode() {
        this.exploding = true;
        this.stepsImg = -1;
    }

    public Point2D getPositionPlayer() {
        return positionPlayer;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public boolean isExploding() {
        return exploding;
    }

    public void setDestroyed(final boolean destroyed) {
        this.destroyed = destroyed;
    }

    public void setPositionPlayer(final Point2D positionPlayer) {
        this.positionPlayer = positionPlayer;
    }

    public int getSize() {
        return size;
    }

}
