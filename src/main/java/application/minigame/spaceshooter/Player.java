package application.minigame.spaceshooter;

import javafx.scene.image.Image;

public class Player {
    private int posX;
    private int posY;
    private int size;
    boolean destroyed;
    Image player;

    public Player(int posX, int posY, int size, Image player) {
        this.posX = posX;
        this.posY = posY;
        this.size = size;
        this.player = player;
    }
}
