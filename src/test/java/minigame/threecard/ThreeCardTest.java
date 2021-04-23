package minigame.threecard;

import model.choice.ThreeCardGameChoice;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ThreeCardTest {

    private static final ThreeCardGameChoice RIGHT_CHOISE = ThreeCardGameChoice.SX_POS;
    private static final ThreeCardGameChoice WRONG_CHOISE_1 = ThreeCardGameChoice.CENTER_POS;
    private static final ThreeCardGameChoice WRONG_CHOISE_2 = ThreeCardGameChoice.DX_POS;

    private static List<ThreeCardGameChoice> hypotheticalChoices;
    private static List<ThreeCardGameChoice> computerChoices;

    private void populateLists() {
        computerChoices = new ArrayList<>();
        hypotheticalChoices = new ArrayList<>();
        computerChoices.add(RIGHT_CHOISE);
        computerChoices.add(WRONG_CHOISE_1);
        computerChoices.add(WRONG_CHOISE_2);
        hypotheticalChoices.add(ThreeCardGameChoice.SX_POS);
        hypotheticalChoices.add(ThreeCardGameChoice.CENTER_POS);
        hypotheticalChoices.add(ThreeCardGameChoice.DX_POS);
    }

    @Test
    public void checkWin() {
        populateLists();
        ThreeCardGameChoice.setComputerChoice(hypotheticalChoices);
        final var choices = ThreeCardGameChoice.getComputerChoice();

        assertEquals(RIGHT_CHOISE, choices.get(0));
        assertNotEquals(RIGHT_CHOISE, choices.get(1));
        assertNotEquals(RIGHT_CHOISE, choices.get(2));
    }

    @Test
    public void checkLose() {
        populateLists();
        ThreeCardGameChoice.setComputerChoice(hypotheticalChoices);
        final var choices = ThreeCardGameChoice.getComputerChoice();

        assertNotEquals(WRONG_CHOISE_1, choices.get(0));
        assertNotEquals(WRONG_CHOISE_2, choices.get(0));

        assertEquals(WRONG_CHOISE_1, choices.get(1));
        assertNotEquals(WRONG_CHOISE_2, choices.get(1));

        assertNotEquals(WRONG_CHOISE_1, choices.get(2));
        assertEquals(WRONG_CHOISE_2, choices.get(2));
    }

}
