package application.minigame.phrasecatch;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class PhraseImpl implements Phrase {

    private static final String PHRASES_FILENAME = "src/main/resources/sentences.txt";
    private String phrase;

    public String generatePhrase() {
        final File file = new File(PHRASES_FILENAME);
        try (RandomAccessFile f = new RandomAccessFile(file, "r")) {
            final Random random = new Random();
            final long randomLocation = random.nextLong() / f.length();
            f.seek(randomLocation);
            f.readLine();
            phrase = f.readLine();
            f.close();
        } catch (final IOException ex) {
            System.out.println("Couldn't load file");
        }
        return phrase;
    }

    public int checkText(final String textRead) {
        int errors = Math.abs(phrase.length() - textRead.length());

        for (int i = 0; i < Math.min(phrase.length(), textRead.length()); i++) {
            if (textRead.charAt(i) != phrase.charAt(i)) {
                errors++;
            }
        }
        return errors;
    }

    @Override
    public void setPhrase(final String sentence) {
        phrase = sentence;
    }
}
