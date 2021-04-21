package minigame.memory;

import model.secretcode.SecretCode;
import model.secretcode.SecretCodeImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MemoryTest {

    private static final int SIZE = 5;
    private static final int EXPECTED_ERRORS = 5;
    private static SecretCode secretCode;

    @BeforeAll
    public static void init() {
        secretCode = new SecretCodeImpl();
    }

    @Test
    public void checkSize() {
        int codeSize = Integer.parseInt(secretCode.getCode());
        assertEquals(SIZE, codeSize);
        assertNotEquals(4, codeSize);
    }

    @Test
    public void checkError() {
        int errors = 0;
        List<Integer> code = secretCode.setCode();
        List<Integer> inputCode = secretCode.setInputCode();

       for (int i = 0; i < code.size(); i++) {
           if (!code.get(i).equals(inputCode.get(i))) {
               errors++;
           }
       }
       assertEquals(EXPECTED_ERRORS, errors);
    }
}
