package application.minigame.evenodd.mvc;

import application.minigame.evenodd.fxItem.Choice;
import application.minigame.evenodd.interfaces.EOModel;
import application.minigame.evenodd.mainGame.GettersMVC;
import java.util.Random;

/**
 * Implementation of {@link EOModel} model.
 */
public class EOModelImpl implements EOModel {

    /**
     * Creo i valori random.
     */
    private final Random rnd = new Random();

    /**
     * Uso il gettersMVC per chiamare la view una volta calcolato il risultato.
     */
    private final GettersMVC getters = new GettersMVC();


    @Override
    public void checkWin(final int value) {
        int rndValue = rnd.nextInt(10);
        if ((value == 2 && rndValue % 2 == 0) || (value == 1 && rndValue % 2 != 0)) {
            getters.getView().result = true;
        }
        if (value == 1) {
            getters.getView().playerChoice = Choice.DISPARI;
        } else {
            getters.getView().playerChoice = Choice.PARI;
        }
        getters.getView().resultValue = rndValue;
        getters.getView().resultPlayer();

    }
}
