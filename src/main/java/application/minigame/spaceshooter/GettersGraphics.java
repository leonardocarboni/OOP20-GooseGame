package application.minigame.spaceshooter;

import javafx.scene.canvas.GraphicsContext;

public class GettersGraphics {

    private GraphicsContext gc;

    public GettersGraphics(){
        this.gc = SpaceShooter.gc;
    }

    public GraphicsContext getGraphic(){
        return this.gc;
    }

}
