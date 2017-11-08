package de.exxcellent.challenge.DataContainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataClass implements DataContainer {

	private List<HashMap<String, String>> completeData = new ArrayList<HashMap<String, String>>();
	
	@Override
	public int getNumberOfData() {
		return this.completeData.size();
	}
	
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
	
	@Override
	public HashMap<String, String> getLineOfTable(int i) {
		return completeData.get(i);
	}
	
	@Override
	public String getOneElement(int index, String key) {
		return completeData.get(index).get(key);
	}
}
