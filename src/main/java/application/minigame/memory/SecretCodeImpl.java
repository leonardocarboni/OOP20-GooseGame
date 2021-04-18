package application.minigame.memory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SecretCodeImpl implements SecretCode{

    private static final int SIZE = 5;
    private static final int MIN_VALUE_CODE = 1;
    private static final int MAX_VALUE_CODE = 9;

    private final List<Integer> secretCode = new ArrayList<>();
    private final Random r = new Random();

    @Override
    public void generateSecretCode() {
      for (int i = 0; i < SIZE; i++) {
          secretCode.add(r.nextInt(MAX_VALUE_CODE) + MIN_VALUE_CODE);
      }
    }

    @Override
    public int checkCode(List<Integer> inputCode) {
        int errors = 0;
        for (int i = 0; i < SIZE; i++) {
            if (secretCode.get(i) != inputCode.get(i)) {
                errors++;
            }
        }
        return errors;
    }

    @Override
    public String getCode() {
        return secretCode.stream().map(String::valueOf).collect(Collectors.joining(""));
    }
}
