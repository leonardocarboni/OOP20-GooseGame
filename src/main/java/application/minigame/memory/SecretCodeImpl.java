package application.minigame.memory;

import java.util.Random;

public class SecretCodeImpl implements SecretCode{

    private int secretCode;
    private final Random r = new Random();

    @Override
    public int generateSecretCode() {
        secretCode = r.ints(11111,99999+1)
                      .filter(i -> !String.valueOf(i).contains("0"))
                      .limit(1)
                      .findFirst()
                      .getAsInt();
        return secretCode;
    }

    @Override
    public int checkCode(int secretCode) {
        return 0;
    }
}
