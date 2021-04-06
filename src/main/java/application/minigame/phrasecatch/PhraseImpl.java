package application.minigame.phrasecatch;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class PhraseImpl implements Phrase{

    private static final String PHRASES_FILENAME = "src/main/resources/sentences.txt";
    private String phrase;

    public String generatePhrase() {
        File file = new File(PHRASES_FILENAME);
        try {
            final RandomAccessFile f = new RandomAccessFile(file, "r");
            final long randomLocation = (long) (Math.random() * f.length());
            f.seek(randomLocation);
            f.readLine();
            phrase = f.readLine();
            f.close();
        }catch (IOException ex){
            System.out.println("Couldn't load file");
        }
        return phrase;
    }

    public int checkText(String textRead) {
        int errors = Math.abs(phrase.length() - textRead.length());

        for(int i = 0; i < Math.min(phrase.length(), textRead.length())-1; i++) {
            if(textRead.charAt(i) != phrase.charAt(i)) {
                errors++;
            }
        }
        return errors;
    }
}
