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
    public Point2D position_shot;
    private final int size;

    /**
     * Speed based on score.
     */
    private final int speed = InfoGame.score + 5;

    /**
     * If true the shot must be removed from graphics.
     */
    public boolean noShot;

    private final GraphicsContext gc;

    /**
     * Create the shot.
     * @param posX of the shot.
     * @param posY of the shot.
     * @param size of the shot.
     */
    public ShotImpl(final int posX, final int posY, final int size) {
        position_shot = new Point2D(posX, posY);
        this.size = size;
        this.gc = SpaceShooter.gc;
    }


    @Override
    public void update() {
        position_shot = new Point2D(position_shot.getX(), position_shot.getY() - speed);
    }


    @Override
    public void draw() {
        gc.fillOval(position_shot.getX(), position_shot.getY(), size, size);
    }


    @Override
    public boolean collide(final Enemy enemy) {
        double distance_enemy_shot = InfoGame.distance(this.position_shot.getX() + size / (double) 3,
                this.position_shot.getY() + size, enemy.position_player.getX() + enemy.size / (double) 3,
                enemy.position_player.getY() + enemy.size);
        return distance_enemy_shot < enemy.size / (double) 2 + this.size / (double) 2;
    }

}
