package utility.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public final class FileUtilityImpl<B> implements FileUtility<B> {

    private final String fileName;
    private final File file;
    private final Gson gson = new GsonBuilder().setPrettyPrinting()
                                               .disableHtmlEscaping()
                                               .create();

    public FileUtilityImpl(final String name) {
        this.fileName = name;
        this.file = new File(fileName);
    }

    public void saveInformation(final List<B> list, final boolean append, final Class<B> classType) {
        List<B> baseList = new ArrayList<>(); 
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Excepton Occured: " + e.toString());
            }
        } else {
          if (append) {
             try {
                baseList = loadInformation(classType);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
          }
        }
        baseList.removeAll(list);
        baseList.addAll(list);
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(baseList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<B> loadInformation(final Class<B> classType) throws FileNotFoundException {
        if (!file.exists()) {
            System.out.println("File doesn't exist");
            throw new FileNotFoundException();
        }
        final Type listType = TypeToken.getParameterized(List.class, classType).getType();
        List<B> list = new ArrayList<>();
        try (JsonReader reader = new JsonReader(new FileReader(fileName))) {
            list = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
