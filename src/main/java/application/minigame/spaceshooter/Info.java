package application.minigame.spaceshooter;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class Info {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 480;
    public static final int SIZE_P = 50;
    public static final Image PLAYER_IMG = new Image("spaceShooter/player.png");
    public static final Image EXPLOSION_IMG = new Image("spaceShooter/explosion.png");
    public static final Image ENEMY_IMG = new Image("spaceShooter/enemy");
    public static int SHOTS_TO_ENEMY = 1;
    public static int SHOTS_TO_PLAYER = 1;
    public static final int EXPLOSION_IMG_NUM = 15;
    static final int EXPLOSION_WIDTH = 128;
    static final int EXPLOSION_ROWS = 3;
    static final int EXPLOSION_COL = 3;
    static final int EXPLOSION_HEIGHT = 128;
    public static int score;
    public static boolean isOver;
    public static double mouseX;
    public static int MAX_ENEMIES;


}
