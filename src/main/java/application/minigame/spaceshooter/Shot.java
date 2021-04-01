package application.minigame.spaceshooter;

import javafx.geometry.Point2D;

public class Shot {

    private Point2D position_shot;
    private GettersGraphics gg;
    private final int size;
    private int speed;

    public Shot(final int posX,final  int posY,final  int size) {
        position_shot = new Point2D(posX, posY);
        this.size = size;
    }

    public void update(){
        position_shot = new Point2D(position_shot.getX(), position_shot.getY()+speed);
    }

    public void draw(){
        gg.getGraphic().fillOval(position_shot.getX(), position_shot.getY(),size, size);
    }

    public boolean collide(final Enemy enemy){
        int distance_enemy_shot = (int) position_shot.distance(enemy.position_enemy);
        return distance_enemy_shot < enemy.size / 2 + this.size / 2;
    }

}
