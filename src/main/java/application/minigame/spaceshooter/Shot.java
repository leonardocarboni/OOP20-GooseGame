package application.minigame.spaceshooter;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class Shot {

    public Point2D position_shot;
    private final int size;
    private int speed;
    public boolean noShot;
    private GraphicsContext gc;

    public Shot(final int posX,final  int posY,final  int size) {
        position_shot = new Point2D(posX, posY);
        this.size = size;
        this.gc = SpaceShooter.gc;
    }

    public void update(){
        position_shot = new Point2D(position_shot.getX(), position_shot.getY()+speed);
    }

    public void draw(){
        gc.fillOval(position_shot.getX(), position_shot.getY(),size, size);
    }

    public boolean collide(final Enemy enemy){
        int distance_enemy_shot = (int) position_shot.distance(enemy.position_enemy);
        return distance_enemy_shot < enemy.size / 2 + this.size / 2;
    }

}
