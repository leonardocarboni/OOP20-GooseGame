package utility.file;

import java.io.FileNotFoundException;
import java.util.List;

import model.player.PlayerImpl;

public interface FileUtility<B> {

	
	void saveInformation(final List<B> ranking);

	List<B> loadInformation() throws FileNotFoundException;
}
