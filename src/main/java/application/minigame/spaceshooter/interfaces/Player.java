package application.minigame.spaceshooter.interfaces;

import application.minigame.spaceshooter.entity.Enemy;
import application.minigame.spaceshooter.entity.ShotImpl;

public interface Player {

    /**
     * I update the player. If it's exploding, I take the next sub-image until they
     * finish. The destroyed variable becomes true when I'm sure the sub-images they
     * ended.
     */
    void update();
    /**
     * IF it is NOT exploding, I draw the player (this.image) in the position where
     * is situated. (Managed by Point2D) IF IT'S exploding: 1) I take the picture
     * containing the sub-images 2) Since the image is 512x512 and there are 4
     * sub_images each line, I take 128px at a time, this.steps_img e WIDTH / HEGHT
     * 3) Then I draw this image in the position taken with getX / Y e of size size.
     */
    void draw();
    /**
     * Create a new Shot.
     *
     * @return Shot
     */
    ShotImpl shot();
    /**
     * @param enemy that can have a collision.
     * @return true if they touch.
     */
    boolean touch(Enemy enemy);
    /**
     * Explosion.
     */
    void explode();
}
