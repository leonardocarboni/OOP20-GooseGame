package model.phrase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class PhraseImpl implements Phrase {

    private static final String PHRASES_FILENAME = "phraseCatch/sentences.txt";
    private String phrase;

    public String generatePhrase() {
        final InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PHRASES_FILENAME);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            final Random random = new Random();
            final List<String> lines = reader.lines().collect(Collectors.toList());
            phrase = lines.get(random.nextInt(lines.size()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
