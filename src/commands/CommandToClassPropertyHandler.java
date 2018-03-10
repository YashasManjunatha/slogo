package commands;
/**
 * This class reads the command properties from the file, it does it for all languages
 *
 */
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import GUIBoxes.ErrorBox;

public class CommandToClassPropertyHandler {
	private static String classPath = "commands.";
	private Map<String, String> commandsToClasses;
	
	CommandToClassPropertyHandler(String language){

		Properties command_properties = new Properties();
		try {
			FileInputStream input = new FileInputStream(getPropertyFile(language));
			command_properties.load(input);
			commandsToClasses = new HashMap<>();
			String [] commands;
			for (String className: command_properties.stringPropertyNames()) {
				commands = command_properties.getProperty(className).split("\\|");
				for (String command: commands) {
					commandsToClasses.put(command, className);
				}
			}
		}
		catch(Exception e){
			new ErrorBox("Could not load Command property file for language: ", language);
		}
	}
	
	String getClassName(String commandText) {
		String ret ="";
		ret = commandsToClasses.get(commandText);
		if (ret == null) {
			new ErrorBox("Invalid Command", commandText);
		}
		return ret;
	}
	
	Object getClassInstance(String className) {
		Object obj = null;
		try {
			Class<?> clazz = Class.forName(classPath + className);		//find class associated with the command string
			obj = clazz.newInstance();
		}
		catch(Exception e) {
			new ErrorBox("Class not found", className);
		}
		return obj;
	}
	
	private String getPropertyFile(String language) {	
		return "src/languages/" + language + ".properties";
	}
}
