package utility;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;

import model.Player;

public class FileUtility{

	private static final String NAME_FILE = "GooseRanking.json";
	private static final File FILE = new File(NAME_FILE);

	private static Gson gson = new Gson();
	
	public void saveFileRanking(final List<Player> ranking) {
		final Iterator<Player> i = ranking.iterator();
		if (!FILE.exists()) {
			try {
				FILE.createNewFile();
			} catch (IOException e) {
				System.out.println("Excepton Occured: " + e.toString());
			}
		}
		
		try (FileWriter writer = new FileWriter(NAME_FILE)) {
			while(i.hasNext()) {
				 gson.toJson(gson.toJson(i.next()), writer);
			}
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void loadFileRanking() throws IOException {
		if (!FILE.exists()) {
			System.out.println("File doesn't exist");
			throw new IOException();
		}
		
		try (Reader reader = new FileReader(NAME_FILE)) {
            // Convert JSON File to Java Object
            final Player staff = gson.fromJson(reader, Player.class);
            
            // print staff 
            System.out.println(staff);

        } catch (IOException e) {
            e.printStackTrace();
        }
 
	}
}
