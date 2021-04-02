package application.minigame.spaceshooter;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
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
    private Canvas canvas = new GettersGraphics().getCanvas();


    @Override
    public void start(Stage primaryStage) throws Exception {
        gc = canvas.getGraphicsContext2D();
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(60), e -> run(gc)));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        canvas.setCursor(Cursor.MOVE);
        canvas.setOnMouseMoved(e -> mouseX = e.getX());
        canvas.setOnMouseClicked(e -> {
            if(shots.size() < 10) {
                shots.add(player.shot());
            }
        });

        initialize();
        primaryStage.setTitle("SpaceShooter");
        primaryStage.setScene(new Scene(new StackPane(canvas)));
        primaryStage.show();
    }

    private void initialize(){
        IntStream.range(0,10).forEach(i -> enemies.add(new Enemy(rnd.nextInt(600),0,Info.SIZE_P,Info.ENEMY_IMG)));
        player = new Player(Info.WIDTH/2,Info.HEIGHT-Info.SIZE_P,Info.SIZE_P, Info.PLAYER_IMG);
        shots = new ArrayList<>();
        Info.score = 0;
    }

    private void run(GraphicsContext gc) {
        gc.setFill(Color.grayRgb(20));
        gc.fillRect(0, 0, Info.WIDTH, Info.HEIGHT);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setFont(Font.font(20));
        gc.setFill(Color.WHITE);
        gc.fillText("Score: " + Info.score, 60,  20);

        if(Info.isOver){
            gc.setFill(Color.RED);
            gc.fillText("You lost, score: " + Info.score, Info.WIDTH, Info.HEIGHT);
        }

        player.update();
        player.draw();
        player.position_player = new Point2D(mouseX,player.position_player.getY() );


        enemies.stream().peek(Enemy::update).peek(Enemy::draw).forEach(e -> {
            if(player.touch(e) && !player.exploding){
                player.explode();
            }
        });

        for(int i = shots.size()-1; i >= 0; i--){
            Shot shot = shots.get(i);
            if(shot.position_shot.getY() < 0 || shot.noShot){
                shots.remove(i);
                continue;
            }
            shot.update();
            shot.draw();
            for(Enemy enemy: enemies){
                if(shot.collide(enemy) && !enemy.exploding){
                    Info.score++;
                    enemy.explode();
                    shot.noShot = true;
                }
            }

        }
        for(int i = enemies.size()-1; i >= 0; i--){
            if(enemies.get(i).destroyed){
                enemies.set(i, new Enemy(rnd.nextInt(450),0,Info.SIZE_P,Info.ENEMY_IMG));
            }
        }

    }

    public static void main(String[] args) {
        launch();
    }
}
