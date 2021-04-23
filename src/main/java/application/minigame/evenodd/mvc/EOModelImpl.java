package application.minigame.evenodd.mvc;

import java.util.Random;

import application.minigame.evenodd.fxItem.Choice;
import application.minigame.evenodd.interfaces.EOModel;
import application.minigame.evenodd.mainGame.GettersMVC;

/**
 * Implementation of {@link EOModel} MODEL.
 */
public class EOModelImpl implements EOModel {

    /**
     * Uso il gettersMVC per chiamare la view una volta calcolato il risultato.
     */
    private final GettersMVC getters = new GettersMVC();

    @Override
    public void checkWin(final int value) {
        /**
         * Creo i valori random.
         */
        final Random rnd = new Random();
        final int rndValue = rnd.nextInt(10);
        if ((value == 2 && rndValue % 2 == 0) || (value == 1 && rndValue % 2 != 0)) {
            getters.getView().setResult(true);
        }
        if (value == 1) {
            getters.getView().setPlayerChoice(Choice.DISPARI);
        } else {
            getters.getView().setPlayerChoice(Choice.PARI);
        }
        getters.getView().setResultValue(rndValue);
        getters.getView().resultPlayer();

    }
}
