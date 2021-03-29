package utility.file;

import java.io.FileNotFoundException;
import java.util.List;

import model.player.PlayerImpl;

public interface FileUtility {

	
	void saveInformation(final List<PlayerImpl> ranking);

	List<PlayerImpl> loadInformation() throws FileNotFoundException;
}
