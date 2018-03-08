package commands;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import GUIBoxes.ErrorBox;

public class Parser extends ParserObject{
	
	private String myPropertyFile;
	private boolean bool;
	private Map<String, Double> variableMap;
	private Map<String, Command> userCommandMap;
	private String myLanguage;
	
	Parser(Map<String, Double> variables, Map<String, Command> commands, String language){
		variableMap = variables;
		userCommandMap = commands;
		myLanguage = language;
		myPropertyFile = getPropertyFile(myLanguage);
	}

	/*
	 * reflection and stuff can be in different class****
	 * properties file that has Class name to method --> this method returns the correct Command Node type
	 * 	method.invoke()
	 * make everything private that you can
	 * 
	 * document how the parameters are passed for user defined commands in README -- passed in brackets
	 */
	
	private String getPropertyFile(String language) {	//string concatenation
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
		catch(NumberFormatException e) {	//add comment here
		}
		
		if (userCommandMap.containsKey(commandText)) {
			scan.next(); //bypass "[" for paramaters
			String next = scan.next();
			String toBeParsed = "";
			
			while (!next.equals("]")) {
				toBeParsed = toBeParsed + next + " ";
				next = scan.next();
			}
			MakeUserInstruction userInstruction = (MakeUserInstruction) userCommandMap.get(commandText);
			Parser paramParser = new Parser(variableMap, userCommandMap, myLanguage);
			CommandNode params = paramParser.parse(toBeParsed);
			userInstruction.setArguments(params);
			bool = true;
			return new CommandNode (userInstruction);
		}
		
		if (commandText.equals("make") || commandText.equals("set")) {
			String varName = scan.next();
			CommandNode topNode = new CommandNode(new MakeVariable(varName, variableMap));
			return topNode;
		}
		
		if (commandText.equals("[")) {
			return generateBracketNode(commandText, scan);
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
			if (className.equals("MakeVariable")) {
				return commandWithVariableMap(className, scan);
			}
			if (className.equals("MakeUserInstruction")) {
				return userCommand(scan);
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
	
	private CommandNode generateBracketNode(String commandText, Scanner scan) throws InvalidCommandException{
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
		Parser newParser = new Parser(variableMap, userCommandMap, myLanguage);
		CommandNode bracketNode = newParser.parse(toBeParsed);
		bool = true;
		return bracketNode;
	}

	private CommandNode userCommand(Scanner scan) {
		String name = scan.next();
		scan.next(); // pass by initial bracket "["
		List<String> variables = new ArrayList<>();
		String next = scan.next();
		while (!next.equals("]")) {
			variables.add(next);
			next = scan.next();
		}
		next = scan.next();
		String commands = "";
		int bracketCount = 0;
		while (scan.hasNext()) {
			if (next.equals("]")){
				bracketCount--;
				if (bracketCount == 0) {
					break;
				}
			}
			else if (next.equals("[")){
				bracketCount++;
			}
			commands = commands + next + " ";
			next = scan.next();
		}
		commands += next;
		CommandNode userCommand = new CommandNode(new MakeUserInstruction(variables, commands, null, myLanguage, variableMap, userCommandMap));
		userCommandMap.put(name, (Command)userCommand.getCommand());
		return userCommand;
	}

	private CommandNode commandWithVariableMap(String className, Scanner scan) {
		return new CommandNode(new MakeVariable(scan.next(), variableMap));
	}
}