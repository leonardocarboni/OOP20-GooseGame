package application.minigame.spaceshooter.info;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class GettersGraphics {

    private final Canvas canvas = new Canvas(InfoGame.WIDTH, InfoGame.HEIGHT);
    GraphicsContext gc = canvas.getGraphicsContext2D();

    public GettersGraphics() {

    }

    public Canvas getCanvas() {
        return this.canvas;
    }

}
