package application.minigame.memory;

import java.util.List;

public interface SecretCode {

    /**
     * Generates a random Secret Code.
     * @return a random long.
     */
    List<Integer> generateSecretCode();

    /**
     * Confront secretCode with user input.
     * @param secretCode
     * @return the number of errors.
     */
    int checkCode(List<Integer> secretCode);
}
