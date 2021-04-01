package application.minigame.spaceshooter;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class SpaceShooter extends Application {

    private final Random rnd = new Random();
    private List<Enemy> enemies = new ArrayList<>();
    private List<Shot> shots;
    private Player player;
    private double mouseX;
    public static GraphicsContext gc;



    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(Info.WIDTH, Info.HEIGHT);
        gc = canvas.getGraphicsContext2D();
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(60), e -> run(gc)));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        canvas.setCursor(Cursor.MOVE);
        canvas.setOnMouseMoved(e -> mouseX = e.getX());

        initialize();
        primaryStage.setTitle("SpaceShooter");
        primaryStage.setScene(new Scene(new StackPane(canvas)));
        primaryStage.show();
    }

    private void initialize(){
        IntStream.range(0,10).forEach(i -> enemies.add(new Enemy(rnd.nextInt(450),500,Info.SIZE_P,Info.ENEMY_IMG)));
        player = new Player(200,100,Info.SIZE_P, Info.PLAYER_IMG);
        shots = new ArrayList<>();
        Info.score = 0;
    }

    private void run(GraphicsContext gc) {
        gc.fillRect(0,0,Info.WIDTH, Info.HEIGHT);
    }
}
