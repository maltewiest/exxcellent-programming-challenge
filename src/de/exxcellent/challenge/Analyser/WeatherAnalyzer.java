package de.exxcellent.challenge.Analyser;

import de.exxcellent.challenge.DataContainer.DataContainer;

/**
 * This class is used to analyze the data and to find
 * the day with the minimum differenz between given minimum- and maximumcolumns
 */

public class WeatherAnalyzer implements Analyser {

	private DataContainer data = null;
	private String minimumColumnName = null;
	private String maximumColumnName = null;
	private String targetColumnName = null;
	
	public WeatherAnalyzer(DataContainer data, String minimumColumnName, String maximumColumnName, String targetColumnName) {
		this.data = data;
		this.maximumColumnName = maximumColumnName;
		this.minimumColumnName = minimumColumnName;
		this.targetColumnName = targetColumnName;
	}
	
	/**
	 * this function is used to find the minimal differenz.
	 */
	@Override
	public String findEntryWithMinimalDifferenz() {
		String target = "";
    	double differenz = 0.0;
    	double minDifferenz = -10.0;
    	//iterate over the complete dataset
    	for (int index = 0; index < data.getNumberOfData(); ++index) {
    		//get the values of the columns to compare
    		double minTemperatur = Double.parseDouble(data.getOneElement(index, this.minimumColumnName));
    		double maxTemperature = Double.parseDouble(data.getOneElement(index, this.maximumColumnName));
    		//calculate the differenz
    		differenz = maxTemperature - minTemperatur;
    		//update the targetvalue to find the target with minimal distance
    		if ((differenz < minDifferenz) || (minDifferenz < 0) ) {
    			minDifferenz = differenz;
    			target = data.getOneElement(index, this.targetColumnName);
    		}
    	}
		return target;
	}

}
