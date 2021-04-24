package minigame.memory;

import model.secretcode.SecretCode;
import model.secretcode.SecretCodeImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemoryTest {

    private static final int EXPECTED_ERRORS = 5;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_5 = 5;
    private static SecretCode secretCode;

    @BeforeAll
    public static void init() {
        secretCode = new SecretCodeImpl();
    }

    @Test
    public void checkError() {
        var errors = 0;
        final var inputCode = List.of(NUM_5, NUM_4, NUM_3, NUM_2, NUM_1);
        secretCode.setCode(List.of(NUM_1, NUM_3, NUM_2, NUM_5, NUM_4));
        final var sc = secretCode.getCode();

        final List<Integer> code = sc.chars()
                               .mapToObj(e -> e)
                               .collect(Collectors.toList());

        for (int i = 0; i < code.size(); i++) {
            if (!code.get(i).equals(inputCode.get(i))) {
                errors++;
            }
        }
        assertEquals(EXPECTED_ERRORS, errors);
    }
}
