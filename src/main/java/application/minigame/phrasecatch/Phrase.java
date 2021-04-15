package application.minigame.phrasecatch;

public interface Phrase {

    /**
     * Generates a random sentence.
     * @return a random sentence.
     */
    String generatePhrase();

    /**
     * Confronts the chosen sentence to the one written by the user.
     * @param textRead - the sentence written by the user.
     * @return the number of errors in the sentence written.
     */
    int checkText(String textRead);

    /**
     * [Test] sets a sentence as the phrase.
     * @param sentence - tha phrase.
     */
    void setPhrase(String sentence);

}
