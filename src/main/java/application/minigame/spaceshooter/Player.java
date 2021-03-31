package application.minigame.spaceshooter;

import javafx.scene.image.Image;

public class Player {
    private int posX;
    public int posY;
    private int size;
    private boolean destroyed;
    private int shot_received = 0;
    private int steps_img = 0;
    Image player;

    public Player(int posX, int posY, int size, Image player) {
        this.posX = posX;
        this.posY = posY;
        this.size = size;
        this.player = player;
    }

    public void update(){
        if(exploding()){
            this.steps_img++;
        }
        destroyed = this.steps_img > Info.SHOTS_TO_PLAYER;
    }

    public void draw(){
        if(!exploding()) {
            Info.gc.drawImage(Info.PLAYER_IMG, this.posX, this.posY, this.size, this.size);
        }
    }

    private boolean exploding(){
        return shot_received == Info.SHOTS_TO_PLAYER;
    }

}
