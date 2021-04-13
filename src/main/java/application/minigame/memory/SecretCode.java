package application.minigame.memory;

public interface SecretCode {

    /**
     * Generates a random Secret Code.
     * @return a random long.
     */
    Long generateSecretCode();

    /**
     * Confront secretCode with user input.
     * @param secretCode
     * @return the number of errors.
     */
    int checkCode(Long secretCode);
}
