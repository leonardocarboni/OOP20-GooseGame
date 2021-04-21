package controller.rockpaperscissors;

import model.choice.RockPaperScissorsChoice;
import model.gamestate.RockPaperScissorsGameState;
import controller.minigame.MinigameController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.rockpaperscissors.RockPaperScissorsView;

public class RockPaperScissorsController implements MinigameController {

    private static final int PROGRESS_IN_GAME = 3;
    private static final int COME_BACK_IN_GAME = -3;
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
        if (numTurns == 3) {
            if (getWinner(playerChoice, getComputerChoice()) == RockPaperScissorsGameState.DRAW) {
                return 0;
            } else if (getWinner(playerChoice, getComputerChoice()) == RockPaperScissorsGameState.PLAYER_WIN) {
                return PROGRESS_IN_GAME;
            } else {
                return COME_BACK_IN_GAME;
            }
        }
        return 0;
    }

    /**
     * An inner class for the event catching in the minigame view.
     */
    public class RockClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(final ActionEvent event) {
            if (numTurns < 3) {
                numTurns++;
                playerChoice = RockPaperScissorsChoice.ROCK;
                final RockPaperScissorsChoice computerChoice = getComputerChoice();
                final RockPaperScissorsGameState winner = getWinner(RockPaperScissorsChoice.ROCK, computerChoice);
                view.setPlayerChoiceImage(RockPaperScissorsChoice.ROCK);
                view.setComputerChoiceImage(computerChoice);
                view.setPlayerScoreLabel(numPlayerWin);
                view.setComputerScoreLabel(numComputerWin);
            }
            if (checkTurns()) {
                view.enableQuitButton();
            }
        }
    }

    /**
     * An inner class for the event catching in the minigame view.
     */
    public class PaperClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(final ActionEvent event) {
            if (numTurns < 3) {
                numTurns++;
                playerChoice = RockPaperScissorsChoice.PAPER;
                final RockPaperScissorsChoice computerChoice = getComputerChoice();
                final RockPaperScissorsGameState winner = getWinner(RockPaperScissorsChoice.PAPER, computerChoice);
                view.setPlayerChoiceImage(RockPaperScissorsChoice.PAPER);
                view.setComputerChoiceImage(computerChoice);
                view.setPlayerScoreLabel(numPlayerWin);
                view.setComputerScoreLabel(numComputerWin);
            }
            if (checkTurns()) {
                view.enableQuitButton();
            }
        }
    }

    /**
     * An inner class for the event catching in the minigame view.
     */
    public class  ScissorsClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(final ActionEvent event) {
            if (numTurns < 3) {
                numTurns++;
                playerChoice = RockPaperScissorsChoice.SCISSORS;
                final RockPaperScissorsChoice computerChoice = getComputerChoice();
                final RockPaperScissorsGameState winner = getWinner(RockPaperScissorsChoice.SCISSORS, computerChoice);
                view.setPlayerChoiceImage(RockPaperScissorsChoice.SCISSORS);
                view.setComputerChoiceImage(computerChoice);
                view.setPlayerScoreLabel(numPlayerWin);
                view.setComputerScoreLabel(numComputerWin);
            }
            if (checkTurns()) {
                view.enableQuitButton();
            }
        }
    }

    private boolean checkTurns() {
        return numTurns == 3 || numPlayerWin == 2 || numComputerWin == 2;
    }

    public RockPaperScissorsGameState getWinner(final RockPaperScissorsChoice playerChoice, final RockPaperScissorsChoice computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            view.draw();
            numTurns--;
            return RockPaperScissorsGameState.DRAW;
        }
        if (playerChoice.equals(RockPaperScissorsChoice.ROCK)) {
            if (computerChoice.equals(RockPaperScissorsChoice.PAPER)) {
                view.computerWin();
                numComputerWin++;
                return RockPaperScissorsGameState.COMPUTER_WIN;
            } else if (computerChoice.equals(RockPaperScissorsChoice.SCISSORS)) {
                view.playerWin();
                numPlayerWin++;
                return RockPaperScissorsGameState.PLAYER_WIN;
            }
        } else if (playerChoice.equals(RockPaperScissorsChoice.PAPER)) {
            if (computerChoice.equals(RockPaperScissorsChoice.ROCK)) {
                view.playerWin();
                numPlayerWin++;
                return RockPaperScissorsGameState.PLAYER_WIN;
            } else if (computerChoice.equals(RockPaperScissorsChoice.SCISSORS)) {
                view.computerWin();
                numComputerWin++;
                return RockPaperScissorsGameState.COMPUTER_WIN;
            }
        } else {
            if (computerChoice.equals(RockPaperScissorsChoice.ROCK)) {
                view.computerWin();
                numComputerWin++;
                return RockPaperScissorsGameState.COMPUTER_WIN;
            } else if (computerChoice.equals(RockPaperScissorsChoice.PAPER)) {
                view.playerWin();
                numPlayerWin++;
                return RockPaperScissorsGameState.PLAYER_WIN;
            }
        }
        return RockPaperScissorsGameState.DRAW;
    }
}
