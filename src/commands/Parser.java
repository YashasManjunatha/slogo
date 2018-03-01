package commands;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class Parser implements ParserObject{
	
	private static final String PROPERTY_FILENAME = "src/languages/English.properties";

	@Override
	public CommandNode parse(String text) throws InvalidCommandException{
		CommandNode superNode = new CommandNode(new Command());
		Scanner scan = new Scanner(text);
		generateTree(superNode, scan);
		return superNode;
	}
	
	private void generateTree(CommandNode root, Scanner scan) throws InvalidCommandException{
		int paramsFilled = 0;
		while (scan.hasNext() && paramsFilled < root.getNumberOfParameters()) {
			String nextCommand = scan.next();
			CommandNode currentChild = new CommandNode(generateCommandInstance(nextCommand));
			root.addChild(currentChild);
			generateTree(currentChild, scan);
			paramsFilled++;
		}
	}

	CommandObject generateCommandInstance(String commandText) throws InvalidCommandException {
		try {
			double parsedDouble = Double.parseDouble(commandText);
			return new ParsedDouble(parsedDouble);
		}
		catch(NumberFormatException e) {	
		}
		CommandObject generatedCommand;
		Properties command_properties = new Properties();
		try {
			FileInputStream input = new FileInputStream(PROPERTY_FILENAME);
			command_properties.load(input);
			Map<String, String> commandsToClasses = new HashMap<>();
			String [] commands;
			for (String className: command_properties.stringPropertyNames()) {
				commands = command_properties.getProperty(className).split("\\|");
				for (String command: commands) {
					commandsToClasses.put(command, className);
				}
			}
			String className = commandsToClasses.get(commandText);
			Class<?> clazz = Class.forName("commands." + className);		//find class associated with the command string
			Object obj = clazz.newInstance(); 
			generatedCommand = (CommandObject) obj;
		}
		catch(Exception e) {
			throw new InvalidCommandException(commandText);
		}
		return generatedCommand;
	}
}


