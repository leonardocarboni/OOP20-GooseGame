package model.secretcode;

import java.util.List;

public interface SecretCode {

    /**
     * Generates a random Secret Code.
     */
    void generateSecretCode();

    /**
     * Confront secretCode with user input.
     * @param inputCode code entered by the user
     * @return the number of errors.
     */
    int checkCode(List<Integer> inputCode);

    /**
     * @return code as a string.
     */
    String getCode();

    /**
     * Is use for Testing.
     */
    List<Integer> setCode();

    /**
     * IS use for Testing.
     */
    List<Integer> setInputCode();
}
