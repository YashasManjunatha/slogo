package commands;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import GUIBoxes.ErrorBox;

public class Parser implements ParserObject{
	
	private String myPropertyFile;
	private boolean bool;
	private Map<String, Double> variableMap;
	private String myLanguage;
	
	Parser(Map<String, Double> variables, String language){
		variableMap = variables;
		myLanguage = language;
		myPropertyFile = getPropertyFile(myLanguage);
	}

	private String getPropertyFile(String language) {
		switch (language) {
		case "English": return "src/languages/English.properties";
		case "Chinese": return "src/languages/Chinese.properties";
		case "French": return "src/languages/French.properties";
		case "German": return "src/languages/German.properties";
		case "Italian": return "src/languages/Italian.properties";
		case "Portuguese": return "src/languages/Portuguese.properties";
		case "Russian": return "src/languages/Russian.properties";
		case "Spanish": return "src/languages/Spanish.properties";
		}
		return null;
	}

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
			bool = false;
			String nextCommand = scan.next();
			CommandNode currentChild = generateCommandNode(nextCommand.toLowerCase(),scan);
			root.addChild(currentChild);
			if (bool) {
				paramsFilled++;
				continue;
			}
			generateTree(currentChild, scan);
			paramsFilled++;
		}
	}
	
	CommandNode generateCommandNode(String commandText, Scanner scan) throws InvalidCommandException {
		try {
			double parsedDouble = Double.parseDouble(commandText);
			return new CommandNode(new ParsedDouble(parsedDouble));
		}
		catch(NumberFormatException e) {	
		}

		if (commandText.equals("[")) {
			int bracketCount = 1;
			String toBeParsed = "";
			String next;
			while (bracketCount != 0) {
				if (!scan.hasNext()) {
					new ErrorBox("Missing Bracket(s)", commandText);
				}
				next = scan.next();
				if (next.equals("]")) {
					bracketCount--;
					if (bracketCount == 0) {
						break;
					}
				}
				if (next.equals("[")) {
					bracketCount++;
				}
				toBeParsed = toBeParsed + " " + next;
			}
			Parser newParser = new Parser(variableMap, myLanguage);
			CommandNode bracketNode = newParser.parse(toBeParsed);
			bool = true;
			return bracketNode;
		}
		
		if (commandText.startsWith(":")) {
			try {
				return new CommandNode(new UserVariable(commandText, variableMap));
			}
			catch(NullPointerException e) {
				new ErrorBox("Undefined Variable", commandText);
			}
		}
		
		CommandObject generatedCommand;
		Properties command_properties = new Properties();
		try {
			FileInputStream input = new FileInputStream(myPropertyFile);
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
			if (className.equals("For") || className.equals("MakeVariable")) {
				return commandWithVariableMap(className, scan);
			}
			Class<?> clazz = Class.forName("commands." + className);		//find class associated with the command string
			Object obj = clazz.newInstance();
			generatedCommand = (CommandObject) obj;
		}
		catch(Exception e) {
			throw new InvalidCommandException(commandText);
		}
		return new CommandNode(generatedCommand);
	}
	
	private CommandNode commandWithVariableMap(String className, Scanner scan) {
		if (className.equals("For")) {
			return new CommandNode(new For(variableMap));
		}
		else {
			return new CommandNode(new MakeVariable(scan.next(), variableMap));
		}
	}
}