package minigameTest.ticTacToe;


import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeTest {
    private static final int bound = 3;
    private List<String> listButtonGrid = new ArrayList<>();
    private final List<String> sign = List.of("X", "O");




    @Test
    public void checkWin(){
        IntStream.range(0,9).forEach(i -> listButtonGrid.add(i, "X")); // facciamo vincere la X orizzontale
        IntStream.range(3,9).forEach(i -> listButtonGrid.add(i, "-"));

        for(int i = 0; i <= (bound)*(bound-1); i+=bound){
            for(int j = 0; j < 2; j++){
                int counter = 0;
                for (int k = 0; k < bound; k++){
                    if(listButtonGrid.get(i+k).equals(sign.get(j))) {
                        counter++;
                    }
                    if (counter == bound){
                        System.out.println("1 vince X");
                        assertEquals(sign.get(j),"X"); //vince la X
                    }
                }
            }
        }

        //vince X verticale
        listButtonGrid.add(0, "X");
        listButtonGrid.add(3, "X");
        listButtonGrid.add(6, "X");

        for(int i = 0; i < bound; i++){
            for(int j = 0; j < 2; j++){
                int counter = 0;
                for(int k = 0; k <= (bound)*(bound-1); k+=bound){
                    if(listButtonGrid.get(i+k).equals(sign.get(j))){
                        counter++;
                    }
                    if (counter == bound){
                        System.out.println("2 vince X");
                        assertEquals(sign.get(j),"X");
                    }
                }
            }
        }


        //vince O obliqua principale
        listButtonGrid.add(0, "O");
        listButtonGrid.add(4, "O");
        listButtonGrid.add(8, "O");

        for(int j = 0; j < 2; j++) {
            int counter = 0;
            for(int i = 0; i < bound*bound; i+=bound+1){
                if (listButtonGrid.get(i).equals(sign.get(j))){
                    counter++;
                }
                if(counter == bound){
                    System.out.println("3 vince O");
                    assertEquals(sign.get(j),"O");
                }
            }
        }


        //vince O obliqua secondaria
        listButtonGrid.add(2, "O");
        listButtonGrid.add(4, "O");
        listButtonGrid.add(6, "O");

        for(int j = 0; j < 2; j++) {
            int counter = 0;
            for(int i = bound-1; i < bound*bound; i+=bound-1){
                if (listButtonGrid.get(i).equals(sign.get(j))){
                    counter++;
                }
                if(counter == bound){
                   System.out.println("4 vince O");
                    assertEquals(sign.get(j),"O");
                }
            }
        }

    }

}
