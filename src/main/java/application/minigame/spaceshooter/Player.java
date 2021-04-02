package application.minigame.spaceshooter;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Player {
    public Point2D position_player;
    public final int size;
    public boolean destroyed;
    public boolean exploding;
    public int shot_received = 0;
    private int steps_img = 0;
    private Image image;
    private GraphicsContext gc;

    public Player(final int posX,final  int posY,final  int size, Image player) {
        position_player = new Point2D(posX, posY);
        this.size = size;
        this.image = player;
        this.gc = SpaceShooter.gc;
    }

    public void update(){

        if(exploding){
            this.steps_img++;
        }
        destroyed = this.steps_img > Info.EXPLOSION_IMG_NUM;
    }

    public void draw(){
        if(!exploding) {
            gc.drawImage(this.image,position_player.getX(), position_player.getY(), this.size, this.size);
        } else{
            gc.drawImage(Info.EXPLOSION_IMG, Info.EXPLOSION_IMG_NUM % Info.EXPLOSION_COL * Info.EXPLOSION_WIDTH,
                    (Info.EXPLOSION_IMG_NUM / Info.EXPLOSION_ROWS) * Info.EXPLOSION_HEIGHT + 1,
                    Info.EXPLOSION_WIDTH, Info.EXPLOSION_HEIGHT,
                    position_player.getX(),position_player.getY(), size, size);
        }
    }

    public Shot shot(){
        return new Shot((int)position_player.getX() + 5, (int)position_player.getY() + 5, 10);
    }

    public boolean touch(final Enemy enemy){
        double distance_enemy_player = Info.distance(this.position_player.getX() + size / 3, this.position_player.getY() + size ,
                enemy.position_player.getX() + enemy.size / 3, enemy.position_player.getY() + enemy.size );
        return distance_enemy_player < enemy.size / 3 + this.size / 3;
    }


    public void explode(){
        this.exploding = true;
        this.steps_img = -1;
    }

}
