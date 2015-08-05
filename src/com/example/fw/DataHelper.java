package com.example.fw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataHelper extends BaseHelper {

	public DataHelper(ApplicationManager manager) {
		super(manager);
	}
	
	public boolean isDataBase(String wantedDb) throws IOException {
		BufferedReader bufferWanted = new BufferedReader(new FileReader(new File(wantedDb)));
		BufferedReader bufferFound = new BufferedReader(new FileReader(new File(manager.getProperties("currentDb"))));
		
		String lineWanted = bufferWanted.readLine();
		String lineFound = bufferFound.readLine();

		while ((lineWanted != null) && (lineFound != null)) {
			if (!lineWanted.equals(lineFound)) {
				bufferWanted.close();
				bufferFound.close();
				return false;
			}
			lineFound = bufferFound.readLine();
			lineWanted = bufferWanted.readLine();
		}
		bufferWanted.close();
		bufferFound.close();
		
		return true;
	}

	public void loadDb(String newData) throws IOException {
		Files.deleteIfExists(Paths.get(manager.getProperties("currentDb")));
		Files.copy(Paths.get(newData), Paths.get(manager.getProperties("currentDb")));
	}
}
