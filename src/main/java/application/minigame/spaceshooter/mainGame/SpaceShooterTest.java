package application.minigame.spaceshooter.mainGame;

import application.minigame.spaceshooter.info.InfoGame;
import application.minigame.spaceshooter.mainGame.SpaceShooter;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.*;
import java.util.Random;


public class SpaceShooterTest {

    SpaceShooter game = new SpaceShooter();


    @Test
    @DisplayName("Test start of the game")
    @Before
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
        double distance_Rocket_Shot = InfoGame.SIZE_PLAYER / 2 + InfoGame.SIZE_SHOT / 2;
        double distance_Rocket_Player = InfoGame.SIZE_PLAYER / 2 + InfoGame.SIZE_ENEMY / 2;
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
    @DisplayName("test loading info")
    @AfterAll
    public void testInfoLoad(){

        new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                Platform.runLater(new Runnable() {
                    public void run() {
                        System.out.println("Check initialize of the game");
                        game.start(new Stage());
                        Assert.assertNotNull(InfoGame.PLAYER_IMG);
                        Assert.assertNotNull(InfoGame.EXPLOSION_IMG);
                        Assert.assertNotNull(InfoGame.BACKGROUND_IMG);
                        Assert.assertNotNull(InfoGame.ENEMY_IMG);
                        Assert.assertNotNull(InfoGame.score);
                        Assert.assertNotNull(InfoGame.HEIGHT);
                        Assert.assertNotNull(InfoGame.WIDTH);
                        Assert.assertNotNull(InfoGame.SIZE_ENEMY);
                        Assert.assertNotNull(InfoGame.SIZE_PLAYER);
                        Assert.assertNotNull(InfoGame.SIZE_SHOT);
                        Assert.assertNotNull(InfoGame.EXPLOSION_HEIGHT);
                        Assert.assertNotNull(InfoGame.EXPLOSION_WIDTH);
                        Assert.assertNotNull(InfoGame.EXPLOSION_IMG_NUM);
                        Assert.assertNotNull(game.getEnemies());
                    }
                });
        }).start();
    }

    @Test
    public void startSpaceShooter() {
        Assert.assertFalse(game.isStarted);
    }

    private double distance(double x1, double y1, double x2, double y2) {
        return  Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }

}