package application.minigame.memory;

import java.util.Random;

public class SecretCodeImpl implements SecretCode{

    private long secretCode;

    private Random r = new Random();

    @Override
    public Long generateSecretCode() {
        secretCode = r.nextInt(6);
        System.out.println(secretCode);
        return secretCode;
    }

    @Override
    public int checkCode(Long secretCode) {
        return 0;
    }
}
