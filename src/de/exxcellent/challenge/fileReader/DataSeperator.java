package de.exxcellent.challenge.fileReader;

import de.exxcellent.challenge.DataContainer.DataContainer;

public interface DataSeperator {
	
	public void seperateFirstLine(String line);
	
	public void seperateOneLineOfData(String line) throws Exception;

	void addDataContainer(DataContainer container);

}
