package application.minigame.spaceshooter;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Player {
    public Point2D position_player;
    public final int size;
    public boolean destroyed;
    public int shot_received = 0;
    private int steps_img = 0;
    private Image player;
    private GraphicsContext gc;

    public Player(final int posX,final  int posY,final  int size, Image player) {
        position_player = new Point2D(posX, posY);
        this.size = size;
        this.player = player;
        this.gc = SpaceShooter.gc;
    }

    public void update(){

        if(exploding()){
            this.steps_img++;
        }
        destroyed = this.steps_img > Info.EXPLOSION_IMG_NUM;
    }

    public void draw(){
        if(!exploding()) {
            gc.drawImage(Info.PLAYER_IMG,position_player.getX(), position_player.getY(), this.size, this.size);
        } else{
            gc.drawImage(Info.EXPLOSION_IMG, Info.EXPLOSION_IMG_NUM % Info.EXPLOSION_COL * Info.EXPLOSION_WIDTH,
                    (Info.EXPLOSION_IMG_NUM / Info.EXPLOSION_ROWS) * Info.EXPLOSION_HEIGHT + 1,
                    Info.EXPLOSION_WIDTH, Info.EXPLOSION_HEIGHT,
                    position_player.getX(),position_player.getY(), size, size);
        }
    }

    public boolean exploding(){
        return shot_received == Info.SHOTS_TO_PLAYER;
    }

    public Shot shot(){
        return new Shot((int)position_player.getX() + 5, (int)position_player.getY() + 5, 10);
    }

    public boolean touch(final Enemy enemy){
        int distance_enemy_player = (int) position_player.distance(enemy.position_enemy);
        return distance_enemy_player < enemy.size / 2 + this.size / 2;
    }

}
