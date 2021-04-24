package minigame.spaceShooter;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpaceShooterTest {
    private final int range = 400;
    private final int sizePlayer = 60;
    private final int sizeShot = 10;
    private final int sizeEnemy = 60;

    @Test
    @DisplayName("Check collision")
    public void checkCollisions() {
        System.out.println("Collision beetwen Rocket and Player");
        double distance;
        boolean collision;
        double distanceRocketShot = sizePlayer / 2 + sizeShot / 2;
        double distanceRocketPlayer = sizePlayer / 2 + sizeEnemy / 2;
        Random rnd = new Random();
        int shotX;
        int shotY;
        for (int i = 0; i < 1000; i++) {
            shotX = rnd.nextInt(range);
            shotY = rnd.nextInt(range);

            /**
             * This is a collision; the Y is the same, but change the X, but not a lot, so the method see a collision.
             */
            distance = distance(shotX + rnd.nextInt((int) distanceRocketPlayer), shotY, shotX, shotY);
            collision = distance < distanceRocketPlayer;
            assertTrue(collision);
        }
        for (int i = 0; i < 1000; i++) {
            shotX = rnd.nextInt(range);
            shotY = rnd.nextInt(range);

            /**
             * This is a collision too, the X is the same but the Y varies.
             */
            distance = distance(shotX, shotY + rnd.nextInt((int) distanceRocketPlayer), shotX, shotY);
            collision = distance < distanceRocketPlayer;
            assertTrue(collision);
        }
        for (int i = 0; i < 1000; i++) {
             shotX = rnd.nextInt(range);
            shotY = rnd.nextInt(range);

            /**
             * This is NOT a collision, because the X various too much and the method can't see a collision happens.
             * In fact i sum: shotX + (casual number) + distanceRocketPlayer.
             */
            distance = distance(shotX + distanceRocketPlayer + rnd.nextInt(range), shotY, shotX, shotY);
            collision = distance < distanceRocketPlayer;
            assertFalse(collision);
        }
        for (int i = 0; i < 1000; i++) {
            shotX = rnd.nextInt(range);
            shotY = rnd.nextInt(range);

            /**
             * This is NOT a collision. Now the Y is too much and the method can't see a collision.
             */
            distance = distance(shotX, shotY + distanceRocketPlayer + rnd.nextInt(range), shotX, shotY);
            collision = distance < distanceRocketPlayer;
            assertFalse(collision);
        }

        /**
         * Now this test is the same as the previous test, but i use the distance between rocket and shot, and NOT rocket and player.
         */
        System.out.println("Collision beetwen Rocket and Shot");
        for (int i = 0; i < 1000; i++) {
            shotX = rnd.nextInt(range);
            shotY = rnd.nextInt(range);

            distance = distance(shotX + rnd.nextInt((int) distanceRocketShot), shotY, shotX, shotY);
            collision = distance < distanceRocketShot;
            assertTrue(collision);
        }
        for (int i = 0; i < 1000; i++) {
            shotX = rnd.nextInt(range);
            shotY = rnd.nextInt(range);

            distance = distance(shotX, shotY + rnd.nextInt((int) distanceRocketShot), shotX, shotY);
            collision = distance < distanceRocketShot;
            assertTrue(collision);
        }
        for (int i = 0; i < 1000; i++) {
            shotX = rnd.nextInt(range);
            shotY = rnd.nextInt(range);

            distance = distance(distanceRocketShot + shotX + rnd.nextInt(range), shotY, shotX, shotY);
            collision = distance < distanceRocketShot;
            assertFalse(collision);
        }
        for (int i = 0; i < 1000; i++) {
            shotX = rnd.nextInt(range);
            shotY = rnd.nextInt(range);

            distance = distance(shotX, shotY + distanceRocketShot + rnd.nextInt(range), shotX, shotY);
            collision = distance < distanceRocketShot;
            assertFalse(collision);
        }

    }
    private double distance(final double x1, final double y1, final double x2, final double y2) {
        return  Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }

}
