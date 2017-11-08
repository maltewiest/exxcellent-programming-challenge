package de.exxcellent.challenge.DataContainer;

import java.util.HashMap;

public interface DataContainer {
	
	public void addOneLine(String[] keys, String[] values) throws Exception;
	
	public int getNumberOfData();
	
	public HashMap<String, String> getLineOfTable(int i);
	
	public String getOneElement(int index, String column);

}
