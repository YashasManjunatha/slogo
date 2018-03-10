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
/**
 * This class controls the language property files which indicate the class type for the text entered in the specified language
 * @author milestodzo
 *
 */
public class CommandToClassPropertyHandler {
	private static String classPath = "commands.";
	private Map<String, String> commandsToClasses;
	/**
	 * The constructor builds the map of String command text to String class name
	 * The map must be built since the property files are given with the text as the value and the class name as the key, so had to flip it.
	 * @param language
	 */
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
	/**
	 * Returns the class name given the commandText
	 * @param commandText
	 * @return
	 */
	String getClassName(String commandText) {
		String ret ="";
		ret = commandsToClasses.get(commandText);
		if (ret == null) {
			new ErrorBox("Invalid Command", commandText);
		}
		return ret;
	}
	/**
	 * Returns the instance of a class given the className
	 * @param className
	 * @return
	 */
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
	/**
	 * Returns the path to the property file given the language
	 * @param language
	 * @return
	 */
	private String getPropertyFile(String language) {	
		return "src/languages/" + language + ".properties";
	}
}
