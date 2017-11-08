package de.exxcellent.challenge.Analyser;

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
	
	@Override
	public String findEntryWithMinimalDifferenz() {
		String target = "";
    	double differenz = 0.0;
    	double minDifferenz = -10.0;
    	for (int index = 0; index < data.getNumberOfData(); ++index) {
    		int firstColumnValue = Integer.parseInt(data.getOneElement(index, this.firstColumnToCompare));
    		int secondColumnValue = Integer.parseInt(data.getOneElement(index, this.secondColumnToCompare));
    		//this is the part where I had to modify the Weatheranalyser to match the need for the footballtask
    		if (secondColumnValue > firstColumnValue) {
    			differenz = secondColumnValue - firstColumnValue;
    		} else {
    			differenz = firstColumnValue - secondColumnValue;
    		}
    			if ((differenz < minDifferenz) || (minDifferenz < 0) ) {
    			minDifferenz = differenz;
    			target = data.getOneElement(index, this.targetColumnName);
    		}
    	}
		return target;
	}
}
