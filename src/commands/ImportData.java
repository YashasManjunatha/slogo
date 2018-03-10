package commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * Implements functionality for loading in the variables/commands from a file
 *
 */
public class ImportData {
	Map<String, Double> myVariables = new HashMap<>();
	Map<String, String> commands = new HashMap<>();
	
	public List<Map> importFile(String fileName) {
		
		List<Map> maps = new ArrayList<>();
		String name=fileName;
		readFile(name);
		maps.add(myVariables);
		maps.add(commands);
		return maps;
	}
	
	private void readFile(String fileName) {		
		try {
			File f = new File(fileName);
			BufferedReader b = new BufferedReader(new FileReader(f));
			String readLine = "";
			while ((readLine = b.readLine()) != null) {
				String[] list = readLine.split(" = ");
				if(list[0].substring(0,1).equals(":")) {
					double value = Double.parseDouble(list[1]);
					myVariables.put(list[0], value);
				}
				else {
					commands.put(list[0], list[1]);	
				}
			}
			b.close();
		}
		catch(Exception e) {
			
		}
	}
}
