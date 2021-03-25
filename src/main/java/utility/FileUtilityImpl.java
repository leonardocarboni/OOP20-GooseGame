package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

import model.player.PlayerImpl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FileUtilityImpl implements FileUtility{

	private static final String NAME_FILE = "GooseRanking.json";
	private static final File FILE = new File(NAME_FILE);

	private final Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
	
	public void saveFileRanking(final List<PlayerImpl> ranking) {
		if (!FILE.exists()) {
			try {
				FILE.createNewFile();
			} catch (IOException e) {
				System.out.println("Excepton Occured: " + e.toString());
			}
		}
		
		try (FileWriter writer = new FileWriter(NAME_FILE)) {
			gson.toJson(ranking, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	/*
	 * 
	 */
	public void loadFileRanking() throws FileNotFoundException {
		if (!FILE.exists()) {
			System.out.println("File doesn't exist");
			throw new FileNotFoundException();
		}
		
		try (Reader reader = new FileReader(NAME_FILE)) {
            final PlayerImpl[] playerArray = gson.fromJson(reader, PlayerImpl[].class);
            final List<PlayerImpl> rank = new ArrayList<>();
            for (final PlayerImpl p : playerArray) {
				rank.add(p);
			}
            System.out.println(rank);
        } catch (IOException e) {
            e.printStackTrace();
        }
 
	}
	
}
