package utility.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class FileUtilityImpl<B> implements FileUtility<B>{

	private final String fileName;
	private final File file;
	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

	public FileUtilityImpl(final String name) {
		this.fileName = name;
		this.file  = new File(fileName);
	}

	public void saveInformation(final List<B> list) {
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("Excepton Occured: " + e.toString());
			}
		}
		
		try (FileWriter writer = new FileWriter(fileName)) {
			GSON.toJson(list, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public List<B> loadInformation() throws FileNotFoundException {
		if (!file.exists()) {
			System.out.println("File doesn't exist");
			throw new FileNotFoundException();
		}
		List<B> list = new ArrayList<>();
		final Type typeClass = new TypeToken<ArrayList<B>>(){}.getType();
		try (Reader reader = new FileReader(fileName)) {
            list = GSON.fromJson(reader, typeClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
		return list;
	}
	
}
