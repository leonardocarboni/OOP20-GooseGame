package utility.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import model.player.PlayerImpl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FileUtilityImpl implements FileUtility{

	private final String fileName;
	private final File file;
	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

	public FileUtilityImpl(final String name) {
		this.fileName = name;
		this.file  = new File(fileName);
	}

	public void saveInformation(final List<PlayerImpl> playerList) {
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("Excepton Occured: " + e.toString());
			}
		}
		
		try (FileWriter writer = new FileWriter(fileName)) {
			GSON.toJson(playerList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public List<PlayerImpl> loadInformation() throws FileNotFoundException {
		final List<PlayerImpl> rank = new ArrayList<>();
		if (!file.exists()) {
			System.out.println("File doesn't exist");
			throw new FileNotFoundException();
		}
		try (Reader reader = new FileReader(fileName)) {
            final PlayerImpl[] playerArray = GSON.fromJson(reader, PlayerImpl[].class);
            for (final PlayerImpl p : playerArray) {
				rank.add(p);
			}
        } catch (IOException e) {
            e.printStackTrace();
        }
		return rank;
	}
	
}
