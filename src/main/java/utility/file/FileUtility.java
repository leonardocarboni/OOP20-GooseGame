package utility.fileUtility;

import java.io.FileNotFoundException;
import java.util.List;

import model.player.PlayerImpl;

public interface FileUtility {

	
	void saveFileRanking(final List<PlayerImpl> ranking);

	void loadFileRanking() throws FileNotFoundException;
}
