package application.minigame.spaceshooter.mainGame;

import application.minigame.spaceshooter.entity.Enemy;
import application.minigame.spaceshooter.entity.PlayerImpl;
import application.minigame.spaceshooter.entity.ShotImpl;
import application.minigame.spaceshooter.info.InfoGame;
import controller.minigame.MinigameController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
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

public class SpaceShooter extends Application implements MinigameController {

    private final Random rnd = new Random();

    /**
     * List of enemies and shots and player
     */
    private List<Enemy> enemies;
    private List<ShotImpl> shots;
    private PlayerImpl player;

    /**
     * Take x for move player
     */
    private double mouseX;

    /**
     * get canvas from class GetterSgraphics
     */
    private final Canvas canvas = new Canvas(InfoGame.WIDTH,InfoGame.HEIGHT);
    public static GraphicsContext gc;

    private Stage d = null;

    public SpaceShooter() {
       start(new Stage());
   }



    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings({ "URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD",
            "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT" })
    @Override
    public void start(Stage primaryStage) {
        d = primaryStage;
        gc = canvas.getGraphicsContext2D();
        primaryStage.show();

        /**
         * Create a timeline for the animation. Every 60millis run(gc) is executed
         */
        Platform.runLater(()-> {
                Timeline animation = new Timeline(new KeyFrame(Duration.millis(30), e -> run(this.gc)));
                animation.setCycleCount(Timeline.INDEFINITE);
                animation.play();
        });

        /**
         * Take the X of the click.
         */
        canvas.setCursor(Cursor.MOVE);
        canvas.setOnMouseMoved(e -> mouseX = e.getX());

        /**
         * If number of shots are less than 20 i can add a shot.
         */
        canvas.setOnMouseClicked(e -> {
            if (shots.size() < 20) {
                shots.add(player.shot());
            }
        });

        initialize();
        primaryStage.setTitle("SpaceShooter");
        primaryStage.setScene(new Scene(new StackPane(canvas)));
        primaryStage.setResizable(false);
    }

    /**
     * Initialize the variables of the game.
     */
    public void initialize() {
        enemies = new ArrayList<>();
        shots = new ArrayList<>();
        IntStream.range(0, 10)
                .forEach(i -> enemies.add(new Enemy(rnd.nextInt(600), 0, InfoGame.SIZE_ENEMY, InfoGame.ENEMY_IMG)));
        player = new PlayerImpl(InfoGame.WIDTH / 2, InfoGame.HEIGHT - InfoGame.SIZE_PLAYER, InfoGame.SIZE_PLAYER,
                InfoGame.PLAYER_IMG);

    }

    /**
     * This method is executed every time.
     * 
     * @param gc GraphicsContext.
     *
     */
    private void run(GraphicsContext gc) {

        /**
         * Write the score up center.
         */
        this.gc.setFill(Color.grayRgb(20));
        this.gc.fillRect(0, 0, InfoGame.WIDTH, InfoGame.HEIGHT);
        this.gc.setTextAlign(TextAlignment.CENTER);
        this.gc.setFont(Font.font(20));
        this.gc.setFill(Color.WHITE);
        this.gc.fillText("Score: " + InfoGame.score, 300, 17);

        /**
         * Draw the background.
         */
        this.gc.drawImage(InfoGame.BACKGROUND_IMG, 0, 20, InfoGame.WIDTH, InfoGame.HEIGHT);

        /**
         * If the game is over i draw your score and a button for close the game.
         */
        if (InfoGame.isOver) {
            this.gc.setFill(Color.RED);
            this.gc.fillText("You lost, score: " + InfoGame.score, 300, 300);
            this.gc.setFont(Font.font(55));
            this.gc.setTextAlign(TextAlignment.LEFT);
            this.gc.drawImage(InfoGame.BUTTON_IMG,250,350,100,50);
            this.gc.fillText("Esci", 250, 396, 100);

            canvas.setOnMouseClicked(event -> {
                double x = event.getX();
                double y = event.getY();
                if(x <350 && x > 250 && y > 350 && y < 450){
                    InfoGame.isOver = false;
                    clear();
                    d.close();
                    getResult();

                }
            });
        }

        /**
         * Update the player and draw it.
         */
        player.update();
        player.draw();
        player.position_player = new Point2D(mouseX, player.position_player.getY());

        /**
         * We will stream into the list of enemies, for each I update and draw it.
         * Check that the enemies have touched the player. If you touch it, isOver becomes
         * true and the player explodes.
         */
        enemies.stream().peek(Enemy::update).peek(Enemy::draw).forEach(e -> {
            if (player.touch(e) && !player.exploding) {
                player.explode();
                InfoGame.isOver = true;
            }
        });

        /**
         * For each shot in the shots list, if the y is off screen or if noShot is
         * true then I remove it from the Update list and draw hits.
         * The second for, handles collisions of shots with enemies If it hits the
         * enemy and if there is no explosion animation then I make it explode
         * and I eliminate the blow, I increase the score.
         */
        for (int i = shots.size() - 1; i >= 0; i--) {
            ShotImpl shot = shots.get(i);
            if (shot.position_shot.getY() < 0 || shot.noShot) {
                shots.remove(i);
                continue;
            }
            shot.update();
            shot.draw();
            for (Enemy enemy : enemies) {
                if (shot.collide(enemy) && !enemy.exploding) {
                    InfoGame.score++;
                    enemy.explode();
                    shot.noShot = true;
                }
            }
        }

        /**
         * Check if the enemies is destroyed, if it is i recreate it.
         */
        for (int i = enemies.size() - 1; i >= 0; i--) {
            if (enemies.get(i).destroyed) {
                enemies.set(i, new Enemy(rnd.nextInt(450), 0, InfoGame.SIZE_ENEMY, InfoGame.ENEMY_IMG));
            }
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    public PlayerImpl getPlayer() {
        return player;
    }

    @Override
    public int getResult() {
        int score = InfoGame.score;
        InfoGame.score = 0;
        return score;
    }

    /**
     * Clear the list of enemies and shots.
     */
    public void clear(){
        enemies.clear();
        shots.clear();
    }

}
