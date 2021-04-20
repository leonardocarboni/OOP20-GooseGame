package application.minigame.spaceshooter.entity;

import application.minigame.spaceshooter.info.InfoGame;
import application.minigame.spaceshooter.interfaces.Shot;
import application.minigame.spaceshooter.mainGame.SpaceShooter;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

/**
 * Implementation of {@link Shot}.
 */
public class ShotImpl implements Shot {

    /**
     * Vector position.
     */
    private Point2D positionShot;
    private final int size;

    /**
     * Speed based on score.
     */
    private final int speed = InfoGame.getScore() + 5;

    /**
     * If true the shot must be removed from graphics.
     */
    private boolean noShot;

    private final GraphicsContext gc;

    /**
     * Create the shot.
     * 
     * @param posX of the shot.
     * @param posY of the shot.
     * @param size of the shot.
     */
    public ShotImpl(final int posX, final int posY, final int size) {
        positionShot = new Point2D(posX, posY);
        this.size = size;
        this.gc = SpaceShooter.getGc();
    }

    @Override
    public void update() {
        positionShot = new Point2D(positionShot.getX(), positionShot.getY() - speed);
    }

    @Override
    public void draw() {
        gc.fillOval(positionShot.getX(), positionShot.getY(), size, size);
    }

    @Override
    public boolean collide(final Enemy enemy) {
        double distanceEnemyShot = InfoGame.distance(this.positionShot.getX() + size / (double) 3,
                this.positionShot.getY() + size, enemy.getPositionPlayer().getX() + enemy.getSize() / (double) 3,
                enemy.getPositionPlayer().getY() + enemy.getSize());
        return distanceEnemyShot < enemy.getSize() / (double) 2 + this.size / (double) 2;
    }

    public Point2D getPositionShot() {
        return positionShot;
    }

    public boolean isNoShot() {
        return noShot;
    }

    public void setNoShot(final boolean noShot) {
        this.noShot = noShot;
    }

}
