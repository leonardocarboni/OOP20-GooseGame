package application.minigame.spaceshooter;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class GettersGraphics {

    private Canvas canvas = new Canvas(Info.WIDTH, Info.HEIGHT);
    private GraphicsContext gc;


    public GettersGraphics(){
        this.gc = canvas.getGraphicsContext2D();
    }

    public Canvas getCanvas(){
        return this.canvas;
    }

    public GraphicsContext getGraphic(){
        return this.gc;
    }

    public void setGraphic(GraphicsContext gc){
        this.gc = gc;
    }

}
