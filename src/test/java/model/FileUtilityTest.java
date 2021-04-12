package model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.player.PlayerColor;
import model.player.PlayerImpl;
import utility.file.FileUtilityImpl;

class FileUtilityTest {

	@Test
	public void writeReadFromFiles() {
		final FileUtilityImpl<PlayerImpl> c = new FileUtilityImpl<>("GooseRanking.json");
		final List<PlayerImpl> list = new ArrayList<>();
		list.add(new PlayerImpl("Name1", PlayerColor.PINK));
		list.add(new PlayerImpl("Name2", PlayerColor.PINK));
		list.add(new PlayerImpl("Name3", PlayerColor.PINK));
		c.saveInformation(list);

		List<PlayerImpl> fromFile = new ArrayList<>();
		try {
			fromFile = c.loadInformation(PlayerImpl.class);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		assertSame(fromFile.size(),list.size());
		assertEquals(fromFile,list);
	}
	
	@Test
	public void writeReadFromFile() {
		final FileUtilityImpl<String> c2 = new FileUtilityImpl<>("GooseRanking.json");
		final List<String> list2 = new ArrayList<>();
		list2.add("Name1");
		list2.add("Name2");
		c2.saveInformation(list2);

		List<String> fromFile2 = new ArrayList<>();
		try {
			fromFile2 = c2.loadInformation(String.class);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		assertEquals(fromFile2,list2);
	}

	@Test
	public void checkException() {
		final FileUtilityImpl<String> c2 = new FileUtilityImpl<>("NotFound.json");
		assertThrows(FileNotFoundException.class,() -> c2.loadInformation(String.class));
	}
}
