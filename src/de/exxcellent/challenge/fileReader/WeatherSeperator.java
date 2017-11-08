package de.exxcellent.challenge.fileReader;

/**
 * This class is used to split the incomming data from the readerclass
 * and store it into the DataContainer
 */

import de.exxcellent.challenge.DataContainer.DataContainer;

public class WeatherSeperator implements DataSeperator {
	
	//Datacontainer simulates a databasetable
	private DataContainer container = null;
	//columnnames simulate the names of the columns of the database.
	//They are used as keys for the hashmap in DataCalss
	private String[] columnNames = null;
	
	public WeatherSeperator() {
		
	}
	
	public WeatherSeperator(DataContainer container) {
		this.container = container;
	}
	
	@Override
	public void addDataContainer(DataContainer container) {
		this.container = container;
	}
	
	/**
	 * This is the special function for the first line of the data.
	 * This line contains the columnnmaes which have to be processed
	 * different to the other lines of data.
	 */
	@Override
	public void seperateFirstLine(String line) {
		this.columnNames = line.split(",");
	}
	
	/**
	 * This is the standard function to process all lines
	 * except the first one. It splits the incomming line
	 * into single values and store them into the DataClass
	 */
	@Override
	public void seperateOneLineOfData(String line) throws Exception {
		String[] values = line.split(",");
		this.container.addOneLine(this.columnNames, values);
	}
	
	
	//methods for testpurposes
	public String[] getColumnNames() {
		return this.columnNames;
	}
	
	public DataContainer getContainer() {
		return this.container;
	}

}
