package application.minigame.rockpaparscissors;

import controller.minigame.MinigameController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class RPSController implements MinigameController {

    private final static int PROGRESS_IN_GAME = 3;
    private final static int COME_BACK_IN_GAME = -3;
    private final RPSView view;

    private int numPlayerWin = 0;
    private int numComputerWin = 0;
    private int numTurns = 0;
    private Choice playerChoice;


    public RPSController(){
        view = new RPSView();
        view.setPaperButtonHandler(new PaperClickHandler());
        view.setRockButtonHandler(new RockClickHandler());
        view.setScissorsButtonHandler(new ScissorsClickHandler());
        view.show();
    }

    private Choice getComputerChoice() {
        return Choice.getRandomChoice();
    }

    @Override
    public int getResult() {
        if (numTurns == 3) {
            if (getWinner(playerChoice,getComputerChoice()) == RPSGameState.DRAW) {
                return 0;
            } else if (getWinner(playerChoice,getComputerChoice()) == RPSGameState.COMPUTER_WIN){
                return PROGRESS_IN_GAME;
            } else {
                return COME_BACK_IN_GAME;
            }
        }
        return 0;
    }

    private void checkEnd() {
        if (numTurns == 3) {
            if (numPlayerWin > numComputerWin) {
                System.out.println("Ha vinto il player");
            } else {
                System.out.println("Ha vinto il computer");
            }
        }
    }

    /**
     * An inner class for the event catching in the minigame view
     */
    public class RockClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if (numTurns < 3) {
                numTurns++;
                playerChoice = Choice.ROCK;
                Choice computerChoice = getComputerChoice();
                RPSGameState winner = getWinner(Choice.ROCK, computerChoice);
                view.setPlayerChoiceImage(Choice.ROCK);
                view.setComputerChoiceImage(computerChoice);
                view.setPlayerScoreLabel(numPlayerWin);
                view.setComputerScoreLabel(numComputerWin);
                checkEnd();
            }
        }
    }

    /**
     * An inner class for the event catching in the minigame view
     */
    public class PaperClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if (numTurns < 3) {
                numTurns++;
                playerChoice = Choice.PAPER;
                Choice computerChoice = getComputerChoice();
                RPSGameState winner = getWinner(Choice.PAPER, computerChoice);
                view.setPlayerChoiceImage(Choice.PAPER);
                view.setComputerChoiceImage(computerChoice);
                view.setPlayerScoreLabel(numPlayerWin);
                view.setComputerScoreLabel(numComputerWin);
                checkEnd();
            }
        }
    }

    /**
     * An inner class for the event catching in the minigame view
     */
    public class  ScissorsClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if (numTurns < 3) {
                numTurns++;
                playerChoice = Choice.SCISSORS;
                Choice computerChoice = getComputerChoice();
                RPSGameState winner = getWinner(Choice.SCISSORS, computerChoice);
                view.setPlayerChoiceImage(Choice.SCISSORS);
                view.setComputerChoiceImage(computerChoice);
                view.setPlayerScoreLabel(numPlayerWin);
                view.setComputerScoreLabel(numComputerWin);
                checkEnd();
            }
        }
    }

    public RPSGameState getWinner(Choice playerChoice, Choice computerChoice) {
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
