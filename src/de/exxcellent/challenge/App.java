package de.exxcellent.challenge;

import java.io.FileNotFoundException;
import java.io.IOException;

import de.exxcellent.challenge.Analyser.Analyser;
import de.exxcellent.challenge.Analyser.WeatherAnalyzer;
import de.exxcellent.challenge.Analyser.footballAnalyser;
import de.exxcellent.challenge.DataContainer.DataClass;
import de.exxcellent.challenge.DataContainer.DataContainer;
import de.exxcellent.challenge.fileReader.CsvReaderClass;
import de.exxcellent.challenge.fileReader.DataReader;
import de.exxcellent.challenge.fileReader.DataSeperator;
import de.exxcellent.challenge.fileReader.WeatherSeperator;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    public static void main(String... args) {
    	String weatherFile = "weather.csv";
    	String footballFile = "football.csv";
        // Your preparation code …
    	
    	
		try {
			//search for the day with minimum temperature spread
			DataContainer weatherData = new DataClass();
	    	DataSeperator seperator = new WeatherSeperator(weatherData);
			DataReader weatherReader = null;
	    	Analyser weatherAnalyser = new WeatherAnalyzer(weatherData, "MnT", "MxT", "Day");
			weatherReader = new CsvReaderClass(weatherFile, seperator);
			weatherReader.readCompleteData();
	    	String dayWithSmallestTempSpread = "" + weatherAnalyser.findEntryWithMinimalDifferenz();     // Your day analysis function call …
	        

			//search for the team with smallest differenz in goals
	    	DataContainer footballData = new DataClass();
	    	seperator.addDataContainer(footballData);
	    	DataReader footballReader = new CsvReaderClass(footballFile, seperator);
	    	footballReader.readCompleteData();
			Analyser footballAnalyser = new footballAnalyser(footballData, "Goals", "Goals Allowed", "Team");
	    	String teamWithSmallesGoalSpread = "" + footballAnalyser.findEntryWithMinimalDifferenz(); // Your goal analysis function call …

	        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
	        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallesGoalSpread);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
    
}
