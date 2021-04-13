package utility.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import model.player.PlayerImpl;

public class FileUtilityImpl<B> {

	private final String fileName;
	private final File file;
	private final Gson gson = new GsonBuilder().setPrettyPrinting()
											   .disableHtmlEscaping()
											   .create();
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
			gson.toJson(list, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public List<B> loadInformation(final Class<B> classB) throws FileNotFoundException {
		if (!file.exists()) {
			System.out.println("File doesn't exist");
			throw new FileNotFoundException();
		}
		final Type listType =TypeToken.getParameterized(List.class, classB).getType();
		List<B> list = new ArrayList<>();
		try (JsonReader reader = new JsonReader(new FileReader(fileName))) {
			list = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
		return list;
	}
}
