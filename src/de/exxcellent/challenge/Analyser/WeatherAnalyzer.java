package de.exxcellent.challenge.Analyser;

import de.exxcellent.challenge.DataContainer.DataContainer;

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
	
	@Override
	public String findEntryWithMinimalDifferenz() {
		String target = "";
    	double differenz = 0.0;
    	double minDifferenz = -10.0;
    	for (int index = 0; index < data.getNumberOfData(); ++index) {
    		double minTemperatur = Double.parseDouble(data.getOneElement(index, this.minimumColumnName));
    		double maxTemperature = Double.parseDouble(data.getOneElement(index, this.maximumColumnName));
    		differenz = maxTemperature - minTemperatur;
    		if ((differenz < minDifferenz) || (minDifferenz < 0) ) {
    			minDifferenz = differenz;
    			target = data.getOneElement(index, this.targetColumnName);
    		}
    	}
		return target;
	}

}
