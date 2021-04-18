package view;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import model.player.Player;
import model.player.PlayerImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class WinScreenView extends NormalView {
    @FXML
    private Button playAgainButton, exitButton;
    @FXML
    private Label firstNameLabel, secondNameLabel, thirdNameLabel, fourthNameLabel;
    @FXML
    private HBox firstPlayer, secondPlayer, thirdPlayer, fourthPlayer;

    private static final int FADING_DURATION_MILLIS = 2000;

    public WinScreenView() {
        super(ViewType.WINSCREEN);
        firstPlayer.setVisible(false);
        secondPlayer.setVisible(false);
        thirdPlayer.setVisible(false);
        fourthPlayer.setVisible(false);
    }

    /**
     * sets the players names in the lable ordered by their score and shows them by fading.
     * @param playersList - the list of players (may be unordered).
     */
    public void setPlayers(final List<PlayerImpl> playersList) {

        final List<Player> sortedPlayersList = playersList.stream()
                .sorted((p1, p2) -> p2.getBoardPosition() - p1.getBoardPosition()).collect(Collectors.toList());

        final Iterator<Player> it = sortedPlayersList.iterator();

        final int numPlayers = sortedPlayersList.size();

        firstNameLabel.setText(it.next().getName());
        secondNameLabel.setText(it.next().getName());
        thirdNameLabel.setText(it.hasNext() ? it.next().getName() : "");
        fourthNameLabel.setText(it.hasNext() ? it.next().getName() : "");

        final List<HBox> activeHBoxes = new ArrayList<>();

        activeHBoxes.add(firstPlayer);
        activeHBoxes.add(secondPlayer);
        if (numPlayers > 2) {
            activeHBoxes.add(thirdPlayer);
        }
        if (numPlayers > 3) {
            activeHBoxes.add(fourthPlayer);
        }

        fadeHBox(activeHBoxes);

    }

    public void addButtonListener(final EventHandler<ActionEvent> eventHandler) {
        playAgainButton.setOnAction(eventHandler);
        exitButton.setOnAction(e -> this.close());
    }

    /**
     * Recursive method to show the active HBoxes with fade in transition, sequentially.
     * @param activeHBoxes - the active HBoxes containing the player position and name.
     */
    private void fadeHBox(final List<HBox> activeHBoxes) {
        final int lastIndex = activeHBoxes.size() - 1;

        if (lastIndex >= 0) {
            final HBox hBox = activeHBoxes.get(lastIndex);
            final FadeTransition fadeIn = new FadeTransition(Duration.millis(FADING_DURATION_MILLIS));
            hBox.setOpacity(0.0);
            hBox.setVisible(true);
            fadeIn.setNode(hBox);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.setCycleCount(1);
            fadeIn.setAutoReverse(false);
            fadeIn.playFromStart();
            fadeIn.setOnFinished(e -> {
                activeHBoxes.remove(lastIndex);
                fadeHBox(activeHBoxes);
            });
        }
    }


}
