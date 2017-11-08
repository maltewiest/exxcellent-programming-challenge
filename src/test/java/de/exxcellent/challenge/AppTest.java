package test.java.de.exxcellent.challenge;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.exxcellent.challenge.Analyser.Analyser;
import de.exxcellent.challenge.Analyser.WeatherAnalyzer;
import de.exxcellent.challenge.DataContainer.DataClass;
import de.exxcellent.challenge.DataContainer.DataContainer;
import de.exxcellent.challenge.fileReader.CsvReaderClass;
import de.exxcellent.challenge.fileReader.DataReader;
import de.exxcellent.challenge.fileReader.DataSeperator;
import de.exxcellent.challenge.fileReader.WeatherSeperator;

/**
 * Example JUnit4 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public class AppTest {

    private String successLabel = "not successful";
    private String fileName = null;
    private DataReader reader = null;
    private DataContainer data = null;
	private DataSeperator seperator = null;
	private Analyser analyzer = null;

    @Before
    public void setUp() throws Exception {
    	successLabel = "successfull";
        fileName = "weather.csv";
        data = new DataClass();
        seperator = new WeatherSeperator(data);
        reader = new CsvReaderClass(fileName, seperator);
        analyzer = new WeatherAnalyzer(data, "MnT", "MxT", "Day");
    }
    
    @Test
    public void DataReader_readSingleLine() {
    	try {
			String line = reader.readSingleLine();
			Assert.assertEquals("Day,MxT,MnT,AvT,AvDP,1HrP TPcpn,PDir,AvSp,Dir,MxS,SkyC,MxR,Mn,R AvSLP", line);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Test
    public void DataSeperator_seperateFirstLine() {
    	String[] expectedData = "Day,MxT,MnT".split(",");
    	seperator.seperateFirstLine("Day,MxT,MnT");
    	String[] data = ((WeatherSeperator)seperator).getColumnNames();
    	for (int i = 0; i < expectedData.length; i++) {
    		Assert.assertEquals(expectedData[i], data[i]);
    	}
    }
    
    @Test
    public void DataSeperator_seperateOneLineOfData() {
    	String[] expectedData = "Day,MxT,MnT".split(",");
    	try {
    		seperator.seperateFirstLine("Day,MxT,MnT");
			seperator.seperateOneLineOfData("Day,MxT,MnT");
			Map<String, String> data = ((WeatherSeperator)seperator).getContainer().getLineOfTable(0);
    		for (int i = 0; i < expectedData.length; i++) {
    			Assert.assertEquals(expectedData[i], data.get(expectedData[i]));
    		}
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Test
    public void DataClass_addOneLine() {
    	String[] expectedData = "Day,MxT,MnT".split(",");
    	try {
			data.addOneLine(expectedData, expectedData);
		   	Map<String, String> actualdata = data.getLineOfTable(0);
		   	for (int i = 0; i < expectedData.length; i++) {
		   		Assert.assertEquals(expectedData[i], actualdata.get(expectedData[i]));
		   	}
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Test
    public void DataClass_getLineOfTable() {
    	Map<String, String> expectedData = new HashMap<String, String>();
    	expectedData.put("day", "day");
    	expectedData.put("mxt", "mxt");
    	try {
			data.addOneLine("Day,MxT".split(","), "Day,MxT".split(","));
			data.addOneLine("Day,MxT".split(","), "Day,MxT".split(","));
		   	Map<String, String> actualdata = data.getLineOfTable(0);
		   	Assert.assertEquals(expectedData.get("Day"), actualdata.get(expectedData.get("Day")));
		   	Assert.assertEquals(expectedData.get("MxT"), actualdata.get(expectedData.get("MxT")));
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Test
    public void DataClass_getOneElement() {
    	Map<String, String> expectedData = new HashMap<String, String>();
    	expectedData.put("day", "day");
    	expectedData.put("mxt", "mxt");
    	try {
			data.addOneLine("day,mxt".split(","), "day,mxt".split(","));
			data.addOneLine("day,mxt".split(","), "day,mxt".split(","));
		   	Map<String, String> actualdata = data.getLineOfTable(0);
		   	Assert.assertEquals(expectedData.get("day"), actualdata.get("day"));
		   	Assert.assertEquals(expectedData.get("mxt"), actualdata.get("mxt"));
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Test
    public void Analyser_findEntryWithMinimalDifferenz() {
    	try {
    		seperator.seperateFirstLine("Day,MxT,MnT");
			seperator.seperateOneLineOfData("1,15,10");
			seperator.seperateOneLineOfData("2,13,9");
			seperator.seperateOneLineOfData("3,17,10");
			String actualData = analyzer.findEntryWithMinimalDifferenz();
			Assert.assertEquals("2", actualData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 

}