package application.minigame.spaceshooter.interfaces;

import application.minigame.spaceshooter.entity.Enemy;

public interface Shot {

    /**
     * Refresh the position , X is the same, Y is Y minus speed.
     */
    public void update();

    /**
     * Draw the Oval at the position specified in the Point2D. The size is specified.
     */
    public void draw();

    /**
     * @param enemy that can have a collision.
     * @return true is there is a collision.
     */
    public boolean collide(final Enemy enemy);
}
