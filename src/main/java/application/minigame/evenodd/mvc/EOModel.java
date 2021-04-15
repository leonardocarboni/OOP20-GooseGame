package application.minigame.evenodd.mvc;

import application.minigame.evenodd.fxItem.Choice;
import javafx.application.Platform;
import javafx.scene.control.Button;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class EOModel {

    /**
     * Creo i valori random.
     */
    private final Random rnd = new Random();
    private final int rndValue = rnd.nextInt(10);

    /**
     * Uso il gettersMVC per chiamare la view una volta calcolato il risultato.
     */
    private final GettersMVC getters = new GettersMVC();

    /**
     * Se il valore passatomi dal Controller è 2 (il player ha scelto pari) e il
     * valore generato dalla Random è pari allora il player ha VINTO.
     * Se il valore passatomi dal Controller è 1 (il player ha scelto dispari) e il
     * valore generato dalla Random è dispari allora il player ha VINTO.
     * Negli altri casi ha perso.
     * Passo il valore alla view che lo stamperà a video.
     *
     * @param value valore passatomi dal Controller. 1 dispari, 2 pari.
     */
    public void checkWin(int value){
        if((value == 2 && rndValue % 2 == 0) || (value == 1 && rndValue % 2 != 0)){
            getters.getView().result=true;
        }
        if(value == 1){
            getters.getView().playerChoice = Choice.DISPARI;
        } else{
            getters.getView().playerChoice = Choice.PARI;
        }
        getters.getView().resultValue=rndValue;

    }


}
