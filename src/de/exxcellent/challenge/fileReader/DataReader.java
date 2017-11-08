package de.exxcellent.challenge.fileReader;

import java.io.IOException;

public interface DataReader {

	public void readCompleteData() throws IOException, Exception;
	
	public String readSingleLine() throws IOException;
	
}
