package de.exxcellent.challenge.DataContainer;

/**
 * This class manages to store and access the data from the csv-file
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataClass implements DataContainer {
	//the completeData simulates a databasetable. The The keys in the HashMap are the columnnames of the table
	private List<HashMap<String, String>> completeData = new ArrayList<HashMap<String, String>>();
	
	@Override
	public int getNumberOfData() {
		return this.completeData.size();
	}
	
	/**
	 * This function is used to add one line of the sourcefile into the completeData
	 * params:
	 * String[] keys	is used as keyvalues for the Hashmap. It simulates the columnnames of a table
	 * String[] values  the values to insert into the data. Has to be the same size as keys.
	 */
	@Override
	public void addOneLine(String[] keys, String[] values) throws Exception {
		HashMap<String, String> map = new HashMap<String, String>();
		if (keys.length != values.length) {
			throw new Exception("numbers of columnnames and columnvalues are different");
		}
		for (int i = 0; i < keys.length; ++i) {
			map.put(keys[i], values[i]);
		}
		this.completeData.add(map);
	}
	
	/**
	 * This function is used to get a complete line of data out of the simulated table.
	 * The line of the table is simulated by one HashMap of the complete List.
	 * params:
	 * int i	this is the index of the wanted line
	 */
	@Override
	public HashMap<String, String> getLineOfTable(int i) {
		return completeData.get(i);
	}
	
	/**
	 * This function is used to get one value of the data.
	 * params:
	 * int index	is used as index of the line of data
	 * String key	is used as name of the column to get the value
	 */
	@Override
	public String getOneElement(int index, String key) {
		return completeData.get(index).get(key);
	}
}
