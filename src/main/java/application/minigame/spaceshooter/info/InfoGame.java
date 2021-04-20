package application.minigame.spaceshooter.info;

import javafx.scene.image.Image;

/**
 * Information about the game.
 */
public class InfoGame {
    /**
     * Max shot on the game.
     */
    public static final int MAX_SHOT = 20;
    /**
     * Frame of the Timeline.
     */
    public static final int FRAME = 30;
    /**
     * Width of the screen.
     */
    public static final int WIDTH = 600;
    /**
     * Height of the screen.
     */
    public static final int HEIGHT = 480;
    /**
     * Size of the player.
     */
    public static final int SIZE_PLAYER = 60;
    /**
     * Size of the enemy. 
     */
    public static final int SIZE_ENEMY = 60;
    /**
     * Size of the shot.
     */
    public static final int SIZE_SHOT = 10;

    /**
     * Image of the player.
     */
    public static final Image PLAYER_IMG = new Image("spaceShooter/player.png");
    /**
     * Image of the explosion.
     */
    public static final Image EXPLOSION_IMG = new Image("spaceShooter/explosion.png");
    /**
     * Image of the enemy.
     */
    public static final Image ENEMY_IMG = new Image("spaceShooter/enemy.png");
    /**
     * Image of the background.
     */
    public static final Image BACKGROUND_IMG = new Image("spaceShooter/sfondoGalassia.jpg");
    /**
     * Image of the button.
     */
    public static final Image BUTTON_IMG = new Image("spaceShooter/button.png");

    /**
     * These are used for the animation of the explosion.
     */
    public static final int EXPLOSION_IMG_NUM = 15;
    /**
     * Explosion widht of the image.
     */
    public static final int EXPLOSION_WIDTH = 128;
    /**
     * Explosion height of the image.
     */
    public static final int EXPLOSION_HEIGHT = 128;
    /**
     * Score of the game.
     */
    private static int score = 0;
    /**
     * True if the game is over.
     */
    private static boolean isOver = false;

    /**
     * Used for check the distance.
     * 
     * @param x1 Position X of element 1.
     * @param y1 Position Y of element 1.
     * @param x2 Position X of element 2.
     * @param y2 Position Y of element 2.
     * @return the distance.
     */
    public static double distance(final double x1, final double y1, final double x2, final double y2) {
        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(final int score) {
        InfoGame.score = score;
    }

    public static boolean isOver() {
        return isOver;
    }

    public static void setOver(final boolean isOver) {
        InfoGame.isOver = isOver;
    }

}
