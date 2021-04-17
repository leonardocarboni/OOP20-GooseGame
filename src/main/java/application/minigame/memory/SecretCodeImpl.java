package application.minigame.memory;

import java.util.List;
import java.util.Random;

public class SecretCodeImpl implements SecretCode{

    private List<Integer> secretCode;
    private final Random r = new Random();

    private static final int MIN_VALUE_CODE = 1;
    private static final int MAX_VALUE_CODE = 10;

    @Override
    public List<Integer> generateSecretCode() {
      for (int i = 0; i < 5; i++) {
          secretCode.add(r.nextInt((MAX_VALUE_CODE - MIN_VALUE_CODE) + 1) + MIN_VALUE_CODE);
      }
      return secretCode;
    }

    @Override
    public int checkCode(List<Integer> secretCode) {
        return 0;
    }
}
