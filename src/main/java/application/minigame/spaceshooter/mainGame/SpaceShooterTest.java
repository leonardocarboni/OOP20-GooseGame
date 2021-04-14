package application.minigame.spaceshooter.mainGame;

import application.minigame.spaceshooter.info.Info;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.*;
import java.util.Random;


class SpaceShooterTest {

    SpaceShooter game = new SpaceShooter();


    @Test
    @DisplayName("Test start of the game")
    public void start() {
        Assert.assertEquals(false, game.getOver() );
        Assert.assertNull(game.getEnemies());
        Assert.assertNull(game.getPlayer());
        Assert.assertNull(game.getShots());
        Assert.assertFalse(game.isStarted);

    }



    @Test
    @DisplayName("Check collision")
    public void checkCollisions(){
        System.out.println("Collision beetwen Rocket and Player");
        double distance ;
        boolean collision;
        double distance_Rocket_Shot = Info.SIZE_PLAYER / 2 + Info.SIZE_SHOT / 2;
        double distance_Rocket_Player = Info.SIZE_PLAYER / 2 + Info.SIZE_ENEMY / 2;
        Random rnd = new Random();

        for(int i = 0; i < 1000; i ++){
            int shotX = rnd.nextInt(400);
            int shotY = rnd.nextInt(400);

            distance = distance(shotX+rnd.nextInt((int)distance_Rocket_Player), shotY,shotX,shotY);
            collision = distance < distance_Rocket_Player;
            Assert.assertTrue(collision);
        }
        for(int i = 0; i < 1000; i ++){
            int shotX = rnd.nextInt(400);
            int shotY = rnd.nextInt(400);

            distance = distance(shotX, shotY+rnd.nextInt((int)distance_Rocket_Player),shotX,shotY );
            collision = distance < distance_Rocket_Player;
            Assert.assertTrue(collision);
        }
        for(int i = 0; i < 1000; i ++){
            int shotX = rnd.nextInt(400);
            int shotY = rnd.nextInt(400);

            distance = distance(shotX+distance_Rocket_Player+rnd.nextInt(400), shotY,shotX,shotY);
            collision = distance < distance_Rocket_Player;
            Assert.assertFalse(collision);
        }
        for(int i = 0; i < 1000; i ++){
            int shotX = rnd.nextInt(400);
            int shotY = rnd.nextInt(400);

            distance = distance(shotX, shotY+distance_Rocket_Player+rnd.nextInt(400),shotX,shotY);
            collision = distance < distance_Rocket_Player;
            Assert.assertFalse(collision);
        }
        System.out.println("Collision beetwen Rocket and Shot");
        for(int i = 0; i < 1000; i ++){
            int shotX = rnd.nextInt(400);
            int shotY = rnd.nextInt(400);

            distance = distance(shotX+rnd.nextInt((int)distance_Rocket_Shot), shotY,shotX,shotY);
            collision = distance < distance_Rocket_Shot;
            Assert.assertTrue(collision);
        }
        for(int i = 0; i < 1000; i ++){
            int shotX = rnd.nextInt(400);
            int shotY = rnd.nextInt(400);

            distance = distance(shotX, shotY+rnd.nextInt((int)distance_Rocket_Shot),shotX,shotY);
            collision = distance < distance_Rocket_Shot;
            Assert.assertTrue(collision);
        }
        for(int i = 0; i < 1000; i ++){
            int shotX = rnd.nextInt(400);
            int shotY = rnd.nextInt(400);

            distance = distance(distance_Rocket_Shot+shotX+rnd.nextInt(400), shotY,shotX,shotY);
            collision = distance < distance_Rocket_Shot;
            Assert.assertFalse(collision);
        }
        for(int i = 0; i < 1000; i ++){
            int shotX = rnd.nextInt(400);
            int shotY = rnd.nextInt(400);

            distance = distance(shotX, shotY+distance_Rocket_Shot+rnd.nextInt(400),shotX,shotY);
            collision = distance < distance_Rocket_Shot;
            Assert.assertFalse(collision);
        }

    }

    @Test
    public void startSpaceShooter() {
        Assert.assertFalse(game.isStarted);
    }

    private double distance(double x1, double y1, double x2, double y2) {
        return  Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }

}