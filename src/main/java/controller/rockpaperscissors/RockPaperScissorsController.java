package controller.rockpaperscissors;

import model.choice.RockPaperScissorsChoice;
import controller.minigame.MinigameController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.rockpaperscissors.RockPaperScissorsView;

public class RockPaperScissorsController implements MinigameController {

    private final RockPaperScissorsView view;

    private int numPlayerWin;
    private int numComputerWin;
    private int numTurns;
    private RockPaperScissorsChoice playerChoice;


    public RockPaperScissorsController() {
        view = new RockPaperScissorsView();
        view.setPaperButtonHandler(new PaperClickHandler());
        view.setRockButtonHandler(new RockClickHandler());
        view.setScissorsButtonHandler(new ScissorsClickHandler());
        view.showAndWaitResult();
    }

    private RockPaperScissorsChoice getComputerChoice() {
        return RockPaperScissorsChoice.getRandomChoice();
    }

    @Override
    public int getResult() {
       return numPlayerWin * numPlayerWin;
    }

    /**
     * An inner class for the event catching in the minigame view.
     */
    public class RockClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(final ActionEvent event) {
            if (checkTurns()) {
                numTurns++;
                playerChoice = RockPaperScissorsChoice.ROCK;
                final RockPaperScissorsChoice computerChoice = getComputerChoice();
                getWinner(RockPaperScissorsChoice.ROCK, computerChoice);
                view.setPlayerChoiceImage(RockPaperScissorsChoice.ROCK);
                view.setComputerChoiceImage(computerChoice);
                view.setPlayerScoreLabel(numPlayerWin);
                view.setComputerScoreLabel(numComputerWin);

                if (checkTurns()) {
                    view.enableQuitButton();
                }
            }

        }
    }

    /**
     * An inner class for the event catching in the minigame view.
     */
    public class PaperClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(final ActionEvent event) {
            if (checkTurns()) {
                numTurns++;
                playerChoice = RockPaperScissorsChoice.PAPER;
                final RockPaperScissorsChoice computerChoice = getComputerChoice();
                getWinner(RockPaperScissorsChoice.PAPER, computerChoice);
                view.setPlayerChoiceImage(RockPaperScissorsChoice.PAPER);
                view.setComputerChoiceImage(computerChoice);
                view.setPlayerScoreLabel(numPlayerWin);
                view.setComputerScoreLabel(numComputerWin);

                if (checkTurns()) {
                    view.enableQuitButton();
                }
            }
        }
    }

    /**
     * An inner class for the event catching in the minigame view.
     */
    public class  ScissorsClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(final ActionEvent event) {
            if (checkTurns()) {
                numTurns++;
                playerChoice = RockPaperScissorsChoice.SCISSORS;
                final RockPaperScissorsChoice computerChoice = getComputerChoice();
                getWinner(RockPaperScissorsChoice.SCISSORS, computerChoice);
                view.setPlayerChoiceImage(RockPaperScissorsChoice.SCISSORS);
                view.setComputerChoiceImage(computerChoice);
                view.setPlayerScoreLabel(numPlayerWin);
                view.setComputerScoreLabel(numComputerWin);

                if (checkTurns()) {
                    view.enableQuitButton();
                }
            }
        }
    }

    private boolean checkTurns() {
        return numTurns < 3 && numPlayerWin < 2 && numComputerWin < 2;
    }

    public void getWinner(final RockPaperScissorsChoice playerChoice, final RockPaperScissorsChoice computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            view.draw();
            --numTurns;
        }
        if (playerChoice.equals(RockPaperScissorsChoice.ROCK)) {
            if (computerChoice.equals(RockPaperScissorsChoice.PAPER)) {
                view.computerWin();
                numComputerWin++;
            } else if (computerChoice.equals(RockPaperScissorsChoice.SCISSORS)) {
                view.playerWin();
                numPlayerWin++;
            }
        } else if (playerChoice.equals(RockPaperScissorsChoice.PAPER)) {
            if (computerChoice.equals(RockPaperScissorsChoice.ROCK)) {
                view.playerWin();
                numPlayerWin++;
            } else if (computerChoice.equals(RockPaperScissorsChoice.SCISSORS)) {
                view.computerWin();
                numComputerWin++;
            }
        } else {
            if (computerChoice.equals(RockPaperScissorsChoice.ROCK)) {
                view.computerWin();
                numComputerWin++;
            } else if (computerChoice.equals(RockPaperScissorsChoice.PAPER)) {
                view.playerWin();
                numPlayerWin++;
            }
        }
    }
}
