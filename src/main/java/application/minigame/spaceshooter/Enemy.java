package application.minigame.spaceshooter;

import javafx.scene.image.Image;

public class Enemy {

    private int posX;
    private int posY;
    private int size;
    boolean destroyed;
    Image image_enemy;

    public Enemy(int posX, int posY, int size, Image image_enemy) {
        this.posX = posX;
        this.posY = posY;
        this.size = size;
        this.image_enemy = image_enemy;
    }
}
