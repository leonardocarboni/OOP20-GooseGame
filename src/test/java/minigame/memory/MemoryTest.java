package minigame.memory;

import model.secretcode.SecretCode;
import model.secretcode.SecretCodeImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        secretCode.generateSecretCode();
        final var sc = secretCode.getCode();
        final var size = sc.length();

        assertEquals(SIZE, size);
    }

    @Test
    public void checkError() {
        var errors = 0;
        var inputCode = List.of(7, 4, 3, 2, 1);
        secretCode.setCode(List.of(1, 2, 3, 4, 5));
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
