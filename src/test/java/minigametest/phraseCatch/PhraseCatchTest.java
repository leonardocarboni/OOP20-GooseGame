package minigametest.phrasecatch;

import model.phrase.Phrase;
import model.phrase.PhraseImpl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PhraseCatchTest {

    //for pmd
    private static final int NUM_ERRORS_3 = 3;
    private static final int NUM_ERRORS_7 = 7;
    private static final int NUM_ERRORS_14 = 14;
    private static final int NUM_ERRORS_15 = 15;

    private static Phrase p;

    @BeforeAll
    public static void init() {
        p = new PhraseImpl();
    }

    @Test
    public void testPhraseCheck() {
        p.setPhrase("My sentence is correct - 12345");
        assertEquals(0, p.checkText("My sentence is correct - 12345"));
        //missing "5" (replaced with "6")
        assertEquals(1, p.checkText("My sentence is correct - 12346"));
        //missing "345"
        assertEquals(3, p.checkText("My sentence is correct - 12"));
        //missing "correct - 12345" [15 chars] replaced with "wrong - 12345" [13 chars]
        /*  notice how the space after "-" in the wrong sentence is in the same position as
            the space before "-" in the correct sentence (not counted as an error)  */
        assertEquals(NUM_ERRORS_14, p.checkText("My sentence is wrong - 12345"));
        //missing "correct - 12345" [15 chars] replaced with "wrong_-_12345" [13 chars]
        assertEquals(NUM_ERRORS_15, p.checkText("My sentence is wrong_-_12345"));
        //missing "correct" replaced with "CORRECT" [only 7 chars missing, the others are the same]
        assertEquals(NUM_ERRORS_7, p.checkText("My sentence is CORRECT - 12345"));
        //more charters than expected (counted as errors)
        assertEquals(NUM_ERRORS_3, p.checkText("My sentence is correct - 12345678"));

    }

}
