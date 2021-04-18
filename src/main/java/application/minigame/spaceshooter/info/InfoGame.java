package application.minigame.spaceshooter.info;

import javafx.scene.image.Image;

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
    public static final Image PLAYER_IMG = new Image("spaceShooter/player.png");
    public static final Image EXPLOSION_IMG = new Image("spaceShooter/explosion.png");
    public static final Image ENEMY_IMG = new Image("spaceShooter/enemy.png");
    public static final Image BACKGROUND_IMG = new Image("spaceShooter/sfondoGalassia.jpg");
    public static final Image BUTTON_IMG = new Image("spaceShooter/button.png");
    public static final int EXPLOSION_IMG_NUM = 15;
    public static final int EXPLOSION_WIDTH = 128;
    public static final int EXPLOSION_HEIGHT = 128;
    public static int score = 0;
    public static boolean isOver = false;

    public static double distance(final double x1, final double y1, final double x2, final double y2) {
        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }
}
