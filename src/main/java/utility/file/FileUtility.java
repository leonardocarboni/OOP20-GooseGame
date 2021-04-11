package utility.file;

import java.io.FileNotFoundException;
import java.util.List;


public interface FileUtility<B> {

	/**
	 * Save generic list in the file passed in the constructor
	 * @param ranking
	 */
	void saveInformation(final List<B> list);

	/**
	 * Load content from file passed in the constructor
	 * @return List<B> - list with the content found it in the file
	 * @throws FileNotFoundException
	 */
	List<B> loadInformation() throws FileNotFoundException;
}
