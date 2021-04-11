package application.minigame.rockpaparscissors;

import controller.minigame.MinigameController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class RPSController implements MinigameController {

    private final RPSView view;

    private int numPlayerWin = 0;
    private int numComputerWin = 0;
    private int numTurns = 0;


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

    public class RockClickHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (numTurns < 3) {
                numTurns++;
                Choice computerChoice = getComputerChoice();
                RPSGameState winner = getWinner(Choice.ROCK, computerChoice);
                view.setPlayerChoiceImage(Choice.ROCK);
                view.setComputerChoiceImage(computerChoice);
                view.setPlayerScore(numPlayerWin);
                view.setComputerScore(numComputerWin);
                checkEnd();
            }
         //else non succede niente
        }
    }

    public class PaperClickHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (numTurns < 3) {
                numTurns++;
                Choice computerChoice = getComputerChoice();
                RPSGameState winner = getWinner(Choice.PAPER, computerChoice);
                view.setPlayerChoiceImage(Choice.PAPER);
                view.setComputerChoiceImage(computerChoice);
                view.setPlayerScore(numPlayerWin);
                view.setComputerScore(numComputerWin);
                checkEnd();
            }
        }
    }

    public class  ScissorsClickHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (numTurns < 3) {
                numTurns++;
                Choice computerChoice = getComputerChoice();
                RPSGameState winner = getWinner(Choice.SCISSORS, computerChoice);
                view.setPlayerChoiceImage(Choice.SCISSORS);
                view.setComputerChoiceImage(computerChoice);
                view.setPlayerScore(numPlayerWin);
                view.setComputerScore(numComputerWin);
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
