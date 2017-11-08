package de.exxcellent.challenge.fileReader;

import de.exxcellent.challenge.DataContainer.DataContainer;

public class WeatherSeperator implements DataSeperator {
	
	private DataContainer container = null;
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
	
	@Override
	public void seperateFirstLine(String line) {
		this.columnNames = line.split(",");
	}
	
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
