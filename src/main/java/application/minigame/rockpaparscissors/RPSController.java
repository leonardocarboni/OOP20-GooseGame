package application.minigame.rockpaparscissors;

import controller.minigame.MinigameController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class RPSController implements MinigameController {

    private static final int PROGRESS_IN_GAME = 3;
    private static final int COME_BACK_IN_GAME = -3;
    private final RPSView view;

    private int numPlayerWin;
    private int numComputerWin;
    private int numTurns;
    private Choice playerChoice;


    public RPSController() {
        view = new RPSView();
        view.setPaperButtonHandler(new PaperClickHandler());
        view.setRockButtonHandler(new RockClickHandler());
        view.setScissorsButtonHandler(new ScissorsClickHandler());
        view.showAndWaitResult();
    }

    private Choice getComputerChoice() {
        return Choice.getRandomChoice();
    }

    @Override
    public int getResult() {
        if (numTurns == 3) {
            if (getWinner(playerChoice, getComputerChoice()) == RPSGameState.DRAW) {
                return 0;
            } else if (getWinner(playerChoice, getComputerChoice()) == RPSGameState.COMPUTER_WIN) {
                return PROGRESS_IN_GAME;
            } else {
                return COME_BACK_IN_GAME;
            }
        }
        return 0;
    }

    /**
     * An inner class for the event catching in the minigame view
     */
    public class RockClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(final ActionEvent event) {
            if (numTurns < 3) {
                numTurns++;
                playerChoice = Choice.ROCK;
                final Choice computerChoice = getComputerChoice();
                final RPSGameState winner = getWinner(Choice.ROCK, computerChoice);
                view.setPlayerChoiceImage(Choice.ROCK);
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
     * An inner class for the event catching in the minigame view
     */
    public class PaperClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(final ActionEvent event) {
            if (numTurns < 3) {
                numTurns++;
                playerChoice = Choice.PAPER;
                final Choice computerChoice = getComputerChoice();
                final RPSGameState winner = getWinner(Choice.PAPER, computerChoice);
                view.setPlayerChoiceImage(Choice.PAPER);
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
     * An inner class for the event catching in the minigame view
     */
    public class  ScissorsClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(final ActionEvent event) {
            if (numTurns < 3) {
                numTurns++;
                playerChoice = Choice.SCISSORS;
                final Choice computerChoice = getComputerChoice();
                final RPSGameState winner = getWinner(Choice.SCISSORS, computerChoice);
                view.setPlayerChoiceImage(Choice.SCISSORS);
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

    public RPSGameState getWinner(final Choice playerChoice, final Choice computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            view.draw();
            numTurns--;
            return RPSGameState.DRAW;
        }
        if (playerChoice.equals(Choice.ROCK)) {
            if (computerChoice.equals(Choice.PAPER)) {
                view.computerWin();
                numComputerWin++;
                return RPSGameState.COMPUTER_WIN;
            } else if (computerChoice.equals(Choice.SCISSORS)) {
                view.playerWin();
                numPlayerWin++;
                return RPSGameState.PLAYER_WIN;
            }
        } else if (playerChoice.equals(Choice.PAPER)) {
            if (computerChoice.equals(Choice.ROCK)) {
                view.playerWin();
                numPlayerWin++;
                return RPSGameState.PLAYER_WIN;
            } else if (computerChoice.equals(Choice.SCISSORS)) {
                view.computerWin();
                numComputerWin++;
                return RPSGameState.COMPUTER_WIN;
            }
        } else {
            if (computerChoice.equals(Choice.ROCK)) {
                view.computerWin();
                numComputerWin++;
                return RPSGameState.COMPUTER_WIN;
            } else if (computerChoice.equals(Choice.PAPER)) {
                view.playerWin();
                numPlayerWin++;
                return RPSGameState.PLAYER_WIN;
            }
        }
        return RPSGameState.DRAW;
    }
}
