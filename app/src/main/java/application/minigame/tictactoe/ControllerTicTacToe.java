package application.minigame.tictactoe;

public class ControllerTicTacToe {

    //faccio iniziare il giocatore umano per primo
    private boolean isPlayerOneTurn = true;

    //funzione che in base al turno mi dice a chi tocca
    private boolean checkPlayerOneTurn(){
        return isPlayerOneTurn;
    }

    //cambia il turno del player
    private void changeTurn(){
        isPlayerOneTurn = !isPlayerOneTurn;
    }


}
