package application.minigame.spaceshooter.mainGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

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

public class SpaceShooter extends Application implements MinigameController {

    private final Random rnd = new Random();

    /**
     * List of enemies and shots and player.
     */
    private List<Enemy> enemies;
    private List<ShotImpl> shots;
    private PlayerImpl player;

    /**
     * Take x for move player.
     */
    private double mouseX;

    /**
     * get canvas from class GetterSgraphics.
     */
    private Canvas canvas;
    /**
     * Graphics of the game.
     */
    private static GraphicsContext gc;
    /**
     * Stage of the main game.
     */
    private final Stage primaryStage;

    public SpaceShooter() {
        primaryStage = new Stage();
        start(primaryStage);
    }

    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings({ "URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD",
            "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT" })
    @Override
    public void start(final Stage primaryStage) {
        canvas = new Canvas(InfoGame.WIDTH, InfoGame.HEIGHT);

        gc = canvas.getGraphicsContext2D();
        primaryStage.show();

        /**
         * Create a timeline for the animation. Every 60millis run(gc) is executed
         */
        Platform.runLater(() -> {
            final Timeline animation = new Timeline(new KeyFrame(Duration.millis(InfoGame.FRAME), e -> run(SpaceShooter.gc)));
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
            if (shots.size() < InfoGame.MAX_SHOT) {
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
                .forEach(i -> enemies.add(new Enemy(rnd.nextInt(InfoGame.WIDTH), 0, InfoGame.SIZE_ENEMY, InfoGame.ENEMY_IMG)));
        player = new PlayerImpl(InfoGame.WIDTH / 2, InfoGame.HEIGHT - InfoGame.SIZE_PLAYER, InfoGame.SIZE_PLAYER,
                InfoGame.PLAYER_IMG);

    }

    /**
     * This method is executed every time.
     * 
     * @param gc GraphicsContext.
     *
     */
    private void run(final GraphicsContext gc) {

        /**
         * Write the score up center.
         */
        SpaceShooter.gc.setFill(Color.grayRgb(20));
        SpaceShooter.gc.fillRect(0, 0, InfoGame.WIDTH, InfoGame.HEIGHT);
        SpaceShooter.gc.setTextAlign(TextAlignment.CENTER);
        SpaceShooter.gc.setFont(Font.font(20));
        SpaceShooter.gc.setFill(Color.WHITE);
        SpaceShooter.gc.fillText("Score: " + InfoGame.getScore(), 300, 17);

        /**
         * Draw the background.
         */
        SpaceShooter.gc.drawImage(InfoGame.BACKGROUND_IMG, 0, 20, InfoGame.WIDTH, InfoGame.HEIGHT);

        /**
         * If the game is over i draw your score and a button for close the game.
         */
        if (InfoGame.isOver()) {
            SpaceShooter.gc.setFill(Color.RED);
            SpaceShooter.gc.fillText("You lost, score: " + InfoGame.getScore(), 300, 300);
            SpaceShooter.gc.setFont(Font.font(55));
            SpaceShooter.gc.setTextAlign(TextAlignment.LEFT);
            SpaceShooter.gc.drawImage(InfoGame.BUTTON_IMG, 250, 350, 100, 50);
            SpaceShooter.gc.fillText("Esci", 250, 396, 100);

            canvas.setOnMouseClicked(event -> {
                final double x = event.getX();
                final double y = event.getY();
                if (x < 350 && x > 250 && y > 350 && y < 450) {
                    InfoGame.setOver(false);
                    clear();
                    primaryStage.close();
                    getResult();

                }
            });
        }

        /**
         * Update the player and draw it.
         */
        player.update();
        player.draw();
        player.setPositionPlayer(new Point2D(mouseX, player.getPositionPlayer().getY()));

        /**
         * We will stream into the list of enemies, for each I update and draw it. Check
         * that the enemies have touched the player. If you touch it, isOver becomes
         * true and the player explodes.
         */
        enemies.stream().peek(Enemy::update).peek(Enemy::draw).forEach(e -> {
            if (player.touch(e) && !player.isExploding()) {
                player.explode();
                InfoGame.setOver(true);
            }
        });

        /**
         * For each shot in the shots list, if the y is off screen or if noShot is true
         * then I remove it from the Update list and draw hits. The second for, handles
         * collisions of shots with enemies If it hits the enemy and if there is no
         * explosion animation then I make it explode and I eliminate the blow, I
         * increase the score.
         */
        for (int i = shots.size() - 1; i >= 0; i--) {
            final ShotImpl shot = shots.get(i);
            if (shot.getPositionShot().getY() < 0 || shot.isNoShot()) {
                shots.remove(i);
                continue;
            }
            shot.update();
            shot.draw();
            for (final Enemy enemy : enemies) {
                if (shot.collide(enemy) && !enemy.isExploding()) {
                    InfoGame.setScore(InfoGame.getScore() + 1);
                    enemy.explode();
                    shot.setNoShot(true);
                }
            }
        }

        /**
         * Check if the enemies is destroyed, if it is i recreate it.
         */
        for (int i = enemies.size() - 1; i >= 0; i--) {
            if (enemies.get(i).isDestroyed()) {
                enemies.set(i, new Enemy(rnd.nextInt(InfoGame.WIDTH), 0, InfoGame.SIZE_ENEMY, InfoGame.ENEMY_IMG));
            }
        }

    }

    public static void main(final String[] args) {
        launch(args);
    }

    public PlayerImpl getPlayer() {
        return player;
    }

    @Override
    public int getResult() {
        final int score = InfoGame.getScore();
        InfoGame.setScore(0);
        return score;
    }

    /**
     * Clear the list of enemies and shots.
     */
    public void clear() {
        enemies.clear();
        shots.clear();
    }

    public static GraphicsContext getGc() {
        return gc;
    }

}
