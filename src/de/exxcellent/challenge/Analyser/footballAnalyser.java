package de.exxcellent.challenge.Analyser;

/**
 * This class is used to analyze the data and to find
 * the day with the minimum differenz between two columns.
 * It is not fixed which column holds the maximum value
 * This is the only apaption of the weatherprogram to work
 * with the footballdata
 */

import de.exxcellent.challenge.DataContainer.DataContainer;

public class footballAnalyser implements Analyser {

	private DataContainer data = null;
	private String firstColumnToCompare = null;
	private String secondColumnToCompare = null;
	private String targetColumnName = null;
	
	public footballAnalyser(DataContainer data, String minimumColumnName, String maximumColumnName, String targetColumnName) {
		this.data = data;
		this.secondColumnToCompare = maximumColumnName;
		this.firstColumnToCompare = minimumColumnName;
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
    		int firstColumnValue = Integer.parseInt(data.getOneElement(index, this.firstColumnToCompare));
    		int secondColumnValue = Integer.parseInt(data.getOneElement(index, this.secondColumnToCompare));
    		//this is the part where I had to modify the Weatheranalyser to match the need for the footballtask
    		//find the column with the maximum value
    		if (secondColumnValue > firstColumnValue) {
    			differenz = secondColumnValue - firstColumnValue;
    		} else {
    			differenz = firstColumnValue - secondColumnValue;
    		}
    		//update the targetvalue to find the target with minimal distance
    		if ((differenz < minDifferenz) || (minDifferenz < 0) ) {
    			minDifferenz = differenz;
    			target = data.getOneElement(index, this.targetColumnName);
    		}
    	}
		return target;
	}
}
