package application.minigame.spaceshooter.entity;

import application.minigame.spaceshooter.info.InfoGame;
import application.minigame.spaceshooter.mainGame.SpaceShooter;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class Shot {

    /**
     * Vettore posizione
     */
    public Point2D position_shot;
    private final int size;

    /**
     * La velocita la setto in base allo score
     */
    private final int speed = InfoGame.score + 5;

    /**
     * SE true allora il colpo va eliminato, questo verra fatto nella classe
     * SpaceShooter
     */
    public boolean noShot;

    /**
     * Setto il graphicsContext
     */
    private final GraphicsContext gc;

    public Shot(final int posX, final int posY, final int size) {
        position_shot = new Point2D(posX, posY);
        this.size = size;
        this.gc = SpaceShooter.gc;
    }

    /**
     * Aggiorno il colpo aggiornado la velocita lungo l'asse Y
     */
    public void update() {
        position_shot = new Point2D(position_shot.getX(), position_shot.getY() - speed);
    }

    /**
     * Disegno il colpo come se fosse un ovale, nella pos X/Y di dimensione size
     */
    public void draw() {
        gc.fillOval(position_shot.getX(), position_shot.getY(), size, size);
    }

    /**
     * @param enemy con la quale ci potrebbe essere una collisione
     * @return true se si ha avuto una collisione
     */
    public boolean collide(final Enemy enemy) {
        double distance_enemy_shot = InfoGame.distance(this.position_shot.getX() + size / (double) 3,
                this.position_shot.getY() + size, enemy.position_player.getX() + enemy.size / (double) 3,
                enemy.position_player.getY() + enemy.size);
        return distance_enemy_shot < enemy.size / (double) 2 + this.size / (double) 2;
    }

}
