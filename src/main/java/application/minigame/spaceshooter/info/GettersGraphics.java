package application.minigame.spaceshooter.info;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class GettersGraphics {

    private Canvas canvas = new Canvas(InfoGame.WIDTH, InfoGame.HEIGHT);
    GraphicsContext gc = canvas.getGraphicsContext2D();


    public GettersGraphics(){

    }

    public Canvas getCanvas(){
        return this.canvas;
    }

    public GraphicsContext getGc() {
        return gc;
    }

    public void setGc(GraphicsContext gc) {
        this.gc = gc;
    }
}
