package application.minigame.memory;

import java.util.List;

public interface SecretCode {

    /**
     * Generates a random Secret Code.
     */
    void generateSecretCode();

    /**
     * Confront secretCode with user input.
     * @param inputCode
     * @return the number of errors.
     */
    int checkCode(List<Integer> inputCode);

    String getCode();
}
