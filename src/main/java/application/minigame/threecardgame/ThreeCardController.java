package application.minigame.threecardgame;

import controller.minigame.MinigameController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ThreeCardController implements MinigameController {

    private final ThreeCardView view;
    private Choice playerChoice, computerChoice;

    private int numPlayerWin = 0;
    private int numComputerWin = 0;
    private int numTurns = 0;

    public ThreeCardController() {
        view = new ThreeCardView();
        view.setSxButton(new SxClickHandler());
        view.setCenterButton(new CenterClickHandler());
        view.setDxButton(new DxClickHandler());
        view.setContinueButton(new ContinueHandler());
        computerChoice = Choice.getRandomChoice();
        view.show();
    }

    @Override
    public int getResult() {
       return 0;
    }

    /**
     * An inner class for the event catching in the minigame view.
     */
    public class SxClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if (checkTurns()) {
                playerChoice = Choice.SX_POS;
                setWin();
                view.setImages(computerChoice);
                view.setEnableNextRoundButton();
                view.setDisableButton();
            }
        }
    }

    /**
     * An inner class for the event catching in the minigame view.
     */
    public class CenterClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if (checkTurns()) {
                playerChoice = Choice.CENTER_POS;
                setWin();
                view.setImages(computerChoice);
                view.setEnableNextRoundButton();
                view.setDisableButton();
            }
        }
    }

    /**
     * An inner class for the event catching in the minigame view.
     */
    public class DxClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if (checkTurns()) {
                playerChoice = Choice.DX_POS;
                setWin();
                view.setImages(computerChoice);
                view.setEnableNextRoundButton();
                view.setDisableButton();
            }
        }
    }

    /**
     * An inner class for the event catching in the minigame view.
     */
    public class ContinueHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            view.setBackImage();
            if (checkTurns()) {
                computerChoice = Choice.getRandomChoice();
                view.setDisableNextRoundButton();
                view.setEnableButton();
            }
        }
    }

    /**
     * @param playerChoice user choice
     * @param computerChoice random choice made by the computer
     * @return true if playerChoice is equal of computerChoice
     */
    private boolean getWin(Choice playerChoice, Choice computerChoice) {
        return playerChoice.equals(computerChoice);
    }

    /**
     * @return true if is over the minigame
     */
    private boolean checkTurns() {
        return numTurns < 3 && numPlayerWin < 2 && numComputerWin < 2;
    }

    /**
     * Update the round number and check who to assign the point to.
     */
    private void setWin() {
        numTurns++;

        if (getWin(playerChoice, computerChoice)) {
            numPlayerWin++;
            view.setPlayerScoreLabel(numPlayerWin);
        } else {
            numComputerWin++;
            view.setComputerScoreLabel(numComputerWin);
        }
    }

}
