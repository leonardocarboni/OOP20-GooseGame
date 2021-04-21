package minigametest.spaceshooter;

import application.minigame.spaceshooter.info.InfoGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpaceshooterTest {
    private final int range = 400;

    @Test
    @DisplayName("Check collision")
    public void checkCollisions() {
        System.out.println("Collision beetwen Rocket and Player");
        double distance;
        boolean collision;
        double distanceRocketShot = InfoGame.SIZE_PLAYER / 2 + InfoGame.SIZE_SHOT / 2;
        double distanceRocketPlayer = InfoGame.SIZE_PLAYER / 2 + InfoGame.SIZE_ENEMY / 2;
        Random rnd = new Random();
        int shotX;
        int shotY;
        for (int i = 0; i < 1000; i++) {
            shotX = rnd.nextInt(range);
            shotY = rnd.nextInt(range);

            distance = distance(shotX + rnd.nextInt((int) distanceRocketPlayer), shotY, shotX, shotY);
            collision = distance < distanceRocketPlayer;
            assertTrue(collision);
        }
        for (int i = 0; i < 1000; i++) {
            shotX = rnd.nextInt(range);
            shotY = rnd.nextInt(range);

            distance = distance(shotX, shotY + rnd.nextInt((int) distanceRocketPlayer), shotX, shotY);
            collision = distance < distanceRocketPlayer;
            assertTrue(collision);
        }
        for (int i = 0; i < 1000; i++) {
             shotX = rnd.nextInt(range);
            shotY = rnd.nextInt(range);

            distance = distance(shotX + distanceRocketPlayer + rnd.nextInt(range), shotY, shotX, shotY);
            collision = distance < distanceRocketPlayer;
            assertFalse(collision);
        }
        for (int i = 0; i < 1000; i++) {
            shotX = rnd.nextInt(range);
            shotY = rnd.nextInt(range);

            distance = distance(shotX, shotY + distanceRocketPlayer + rnd.nextInt(range), shotX, shotY);
            collision = distance < distanceRocketPlayer;
            assertFalse(collision);
        }
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
