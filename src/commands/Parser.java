package commands;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import GUIBoxes.ErrorBox;

public class Parser extends ParserObject{
	
	private boolean newSuperNodeAdded; //need this to indicate if a super node has been added, otherwise all following nodes will be added to same leaf
	private Map<String, Double> variableMap;
	private Map<String, Command> userCommandMap;
	private String myLanguage;
	private CommandToClassPropertyHandler commandHandler;
	private ClassToMethodPropertyHandler methodHandler;
	private Scanner scan;
	
	Parser(Map<String, Double> variables, Map<String, Command> commands, String language){
		variableMap = variables;
		userCommandMap = commands;
		myLanguage = language;
		commandHandler = new CommandToClassPropertyHandler(language);
		methodHandler = new ClassToMethodPropertyHandler();
	}
	@Override
	public CommandNode parse(String text) throws InvalidCommandException{
		CommandNode superNode = new CommandNode(new Command());
		scan = new Scanner(text);
		generateTree(superNode);
		return superNode;
	}

	private void generateTree(CommandNode root) throws InvalidCommandException{
		int paramsFilled = 0;
		while (scan.hasNext() && paramsFilled < root.getNumberOfParameters()) {
			newSuperNodeAdded = false;
			String nextCommand = scan.next();
			CommandNode currentChild = generateCommandNode(nextCommand.toLowerCase());
			root.addChild(currentChild);
			if (newSuperNodeAdded) {
				paramsFilled++;
				continue;
			}
			generateTree(currentChild);
			paramsFilled++;
		}
	}

	private CommandNode generateCommandNode(String commandText) throws InvalidCommandException {
		try {
			double parsedDouble = Double.parseDouble(commandText);
			return new CommandNode(new ParsedDouble(parsedDouble));
		}
		catch(NumberFormatException e) {
			//proceed
		}
		if (commandText.equals("#")) {
			scan.nextLine();
			return new CommandNode(new Comment());
		}
		if (userCommandMap.containsKey(commandText)) {
			return generateUserCommandNode(commandText);
		}
		if (commandText.equals("[")) {
			return generateBracketNode(commandText);
		}
		if (commandText.startsWith(":")) {
			try {
				return new CommandNode(new UserVariable(commandText, variableMap));
			}
			catch(NullPointerException e) {
				new ErrorBox("Undefined Variable", commandText);
			}
		}
		String className = commandHandler.getClassName(commandText);
		Method m = methodHandler.getGenerateMethod(this, className);
		try {
			return (CommandNode) m.invoke(this, className);
		} catch (Exception e) {
			new ErrorBox("Error Generating Comamnd", className);
		}
		return null;
	}

	private CommandNode generateUserCommandNode(String commandText) {
		scan.next(); //bypass "[" for paramaters
		String next = scan.next();
		String toBeParsed = "";

		while (!next.equals("]")) {
			toBeParsed = toBeParsed + next + " ";
			next = scan.next();
		}
		MakeUserInstruction userInstruction = (MakeUserInstruction) userCommandMap.get(commandText);
		Parser paramParser = new Parser(variableMap, userCommandMap, myLanguage);
		try {
			CommandNode params = paramParser.parse(toBeParsed);
			userInstruction.setArguments(params);
		}catch(InvalidCommandException e) {
			new ErrorBox("Error in User Defined Command", commandText);
		}
		newSuperNodeAdded = true;
		return new CommandNode (userInstruction);
	}

	private CommandNode generateBracketNode(String commandText) throws InvalidCommandException{
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
		newSuperNodeAdded = true;
		return bracketNode;
	}
	
	private CommandNode generateNoConstructorCommand(String className) {
		Object classInstance = commandHandler.getClassInstance(className);
		CommandObject generatedCommand = (CommandObject) classInstance;
		return new CommandNode(generatedCommand);
	}

	private CommandNode generateUserCommand(String className) {
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

	private CommandNode generateVariableMapCommand(String className) {
		return new CommandNode(new MakeVariable(scan.next(), variableMap));
	}
}