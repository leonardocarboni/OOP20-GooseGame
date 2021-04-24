package controller.threecardgame;

import controller.minigame.MinigameController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.choice.ThreeCardGameChoice;
import view.threecard.ThreeCardView;

public class ThreeCardController implements MinigameController {

    private final ThreeCardView view;
    private ThreeCardGameChoice playerChoice, computerChoice;

    private int numPlayerWin;
    private int numComputerWin;
    private int numTurns;

    public ThreeCardController() {
        view = new ThreeCardView();
        view.setSxButton(new SxClickHandler());
        view.setCenterButton(new CenterClickHandler());
        view.setDxButton(new DxClickHandler());
        view.setContinueButton(new ContinueHandler());
        computerChoice = ThreeCardGameChoice.getRandomChoice();
        view.showAndWaitResult();
    }

    @Override
    public int getResult() {
        return numPlayerWin * numPlayerWin;
    }

    /**
     * An inner class for the event catching in the minigame view.
     */
    public class SxClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(final ActionEvent event) {
            if (checkTurns()) {
                playerChoice = ThreeCardGameChoice.SX_POS;
                setWin();
                view.setImages(computerChoice);
                if (checkTurns()) {
                    view.setEnableNextRoundButton();
                } else {
                    view.enableQuitButton();
                }
                view.setDisableButton();
            }
        }
    }

    /**
     * An inner class for the event catching in the minigame view.
     */
    public class CenterClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(final ActionEvent event) {
            if (checkTurns()) {
                playerChoice = ThreeCardGameChoice.CENTER_POS;
                setWin();
                view.setImages(computerChoice);
                if (checkTurns()) {
                    view.setEnableNextRoundButton();
                } else {
                    view.enableQuitButton();
                }
                view.setDisableButton();
            }
        }
    }

    /**
     * An inner class for the event catching in the minigame view.
     */
    public class DxClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(final ActionEvent event) {
            if (checkTurns()) {
                playerChoice = ThreeCardGameChoice.DX_POS;
                setWin();
                view.setImages(computerChoice);
                if (checkTurns()) {
                    view.setEnableNextRoundButton();
                } else {
                    view.enableQuitButton();
                }
                view.setDisableButton();
            }
        }
    }

    /**
     * An inner class for the event catching in the minigame view.
     */
    public class ContinueHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(final ActionEvent event) {
            view.setBackImage();
            if (checkTurns()) {
                computerChoice = ThreeCardGameChoice.getRandomChoice();
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
    private boolean getWin(final ThreeCardGameChoice playerChoice, final ThreeCardGameChoice computerChoice) {
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

