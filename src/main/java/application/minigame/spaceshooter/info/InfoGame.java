package application.minigame.spaceshooter.info;

import javafx.scene.image.Image;

/**
 * Information about the game.
 */
public class InfoGame {

    /**
     * Limit when you win
     */
    private static final int WIN_SCORE = 40;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 480;
    public static final int SIZE_PLAYER = 60;
    public static final int SIZE_ENEMY = 60;
    public static final int SIZE_SHOT = 10;

    /**
     * Images.
     */
    public static final Image PLAYER_IMG = new Image("spaceShooter/player.png");
    public static final Image EXPLOSION_IMG = new Image("spaceShooter/explosion.png");
    public static final Image ENEMY_IMG = new Image("spaceShooter/enemy.png");
    public static final Image BACKGROUND_IMG = new Image("spaceShooter/sfondoGalassia.jpg");
    public static final Image BUTTON_IMG = new Image("spaceShooter/button.png");

    /**
     * These are used for the animation of the explosion.
     */
    public static final int EXPLOSION_IMG_NUM = 15;
    public static final int EXPLOSION_WIDTH = 128;
    public static final int EXPLOSION_HEIGHT = 128;

    public static int score = 0;
    public static boolean isOver = false;

    /**
     * Used for check the distance.
     * @param x1 Position X of element 1.
     * @param y1 Position Y of element 1.
     * @param x2 Position X of element 2.
     * @param y2 Position Y of element 2.
     * @return the distance.
     */
    public static double distance(final double x1, final double y1, final double x2, final double y2) {
        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }
}
