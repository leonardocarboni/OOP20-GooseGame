package utility.file;

import java.io.FileNotFoundException;
import java.util.List;

public interface FileUtility<B> {

    /**
     * Save generic list in the file passed in the constructor. 
     * @param list
     * @param append
     * @param classType
     */
    void saveInformation(List<B> list, boolean append, Class<B> classType);

    /**
     * Load content from file passed in the constructor.
     * @param classType
     * @return list with the content found it in the file
     * @throws FileNotFoundException
     */
    List<B> loadInformation(Class<B> classType) throws FileNotFoundException;
}
