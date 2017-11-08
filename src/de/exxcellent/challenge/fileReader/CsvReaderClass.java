package de.exxcellent.challenge.fileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvReaderClass implements DataReader {
	
	private File mFile = null;
	private FileReader fis = null;
	private BufferedReader bis = null;
	private DataSeperator seperator = null;
	
	public CsvReaderClass(String fileToRead, DataSeperator seperator) throws FileNotFoundException {
		this.mFile = new File(fileToRead);
		fis = new FileReader(mFile);
		// Here BufferedInputStream is added for fast reading.
	    bis = new BufferedReader(fis);
	    this.seperator = seperator;
	}
	
	 

	@Override
	public void readCompleteData() throws Exception {
		boolean firstLine = true;
		String line = this.readSingleLine();
		while (line != null) {
			if (firstLine) {
				this.seperator.seperateFirstLine(line);
				firstLine = false;
			} else {
				this.seperator.seperateOneLineOfData(line);
				line = this.readSingleLine();
			}
			line = this.readSingleLine();
		}
	}

	@Override
	public String readSingleLine() throws IOException {
		return bis.readLine();
	}
	
	public void finalize() throws IOException {
		this.bis.close();
		this.fis.close();
	}

}
