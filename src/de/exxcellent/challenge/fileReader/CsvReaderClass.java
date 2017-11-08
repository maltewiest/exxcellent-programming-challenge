package de.exxcellent.challenge.fileReader;

/**
 * This class is used to read the data out of an csv-file.
 * In combination with the seperator-class it prepares the data for the simulated 
 * databasetable.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvReaderClass implements DataReader {
	
	private File file = null;
	private FileReader fileReader = null;
	private BufferedReader bufferedReader = null;
	private DataSeperator seperator = null;
	
	public CsvReaderClass(String fileToRead, DataSeperator seperator) throws FileNotFoundException {
		this.file = new File(fileToRead);
		fileReader = new FileReader(file);
		// Here BufferedInputStream is added for fast reading.
	    bufferedReader = new BufferedReader(fileReader);
	    this.seperator = seperator;
	}
	
	 
	/**
	 * this function is used to read the complete data of the sourcefile
	 * line by line and gives the data to the seperator.
	 */
	@Override
	public void readCompleteData() throws Exception {
		boolean firstLine = true;
		//read the first line of data which contains the columnnames
		String line = this.readSingleLine();
		while (line != null) {
			if (firstLine) {
				//process the first line to get the columnnames
				this.seperator.seperateFirstLine(line);
				firstLine = false;
			} else {
				//each other line is processed here
				this.seperator.seperateOneLineOfData(line);
				line = this.readSingleLine();
			}
			line = this.readSingleLine();
		}
	}

	/**
	 * this function is used to read a single line of the sourcefile
	 */
	@Override
	public String readSingleLine() throws IOException {
		return bufferedReader.readLine();
	}
	
	/**
	 * to be sure to close all readers a special finalize
	 */
	public void finalize() throws IOException {
		this.bufferedReader.close();
		this.fileReader.close();
	}

}
