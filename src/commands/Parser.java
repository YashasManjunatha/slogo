package commands;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import GUIBoxes.ErrorBox;
/**
 * This class handles all of the parsing of the text entered by the user
 * Once the run button is pressed, a new Command object is created which creates a Parser and calls parse on the text it was given
 * The parser generates an expression tree of CommandObjects corresponding to the input
 * The tree is then executed from the bottom up 
 * @author milestodzo
 *
 */
public class Parser extends ParserObject{
	private static String endBracket = "]";
	private static String startBracket = "[";
	private static String colonOperator = ":";
	private static String commentHash = "#";
	
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
	/**
	 * Creates initial superNode, instantiates Scanner, calls generateTree to build expression tree for text
	 * @param text: The text to be parsed
	 * @return CommandNode that is the root of the expression tree for the text
	 */
	@Override
	CommandNode parse(String text) throws InvalidCommandException{
	    System.out.println(text);
		CommandNode superNode = new CommandNode(new Command());
		scan = new Scanner(text);
		generateTree(superNode);
		return superNode;
	}
	/**
	 * Generates expression tree by giving each command as many children as it has parameters
	 * Builds recursively
	 * @param root
	 * @throws InvalidCommandException
	 */
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
	/**
	 * If a special symbol is read, the specific CommandObject is generated and put in the CommandNode
	 * Otherwise, reflection is used to first determine the class which the text corresponds to and then the generate method which the class corresponds to
	 * @param commandText
	 * @return CommandNode with CommandObject value of the commandText
	 * @throws InvalidCommandException
	 */
	private CommandNode generateCommandNode(String commandText) throws InvalidCommandException {
		try {
			double parsedDouble = Double.parseDouble(commandText);
			return new CommandNode(new ParsedDouble(parsedDouble));
		}
		catch(NumberFormatException e) {
			//proceed
		}
		if (commandText.equals(commentHash)) {
			scan.nextLine();
			return new CommandNode(new Comment());
		}
		if (userCommandMap.containsKey(commandText)) {
			return generateUserCommandNode(commandText);
		}
		if (commandText.equals(startBracket)) {
			return generateBracketNode(commandText);
		}
		if (commandText.startsWith(colonOperator)) {
			try {
				return new CommandNode(new UserVariable(commandText, variableMap));
			}
			catch(NullPointerException e) {
				new ErrorBox("Undefined Variable", commandText);
			}
		}
		String className = commandHandler.getClassName(commandText);
		System.out.println("class name " + className);
		Method m = methodHandler.getGenerateMethod(this, className);
		System.out.println("method "+ m);
		try {
			return (CommandNode) m.invoke(this, className);
		} catch (Exception e) {
			new ErrorBox("Error Generating Comamnd", className);
		}
		return null;
	}
	/**
	 * Used to generate the CommandNode for user defined commands.
	 * The tree for the command is not actually built until it is time to execute the method (helpful for recursion). The parameters are parsed to form a tree and they are passed as the arguments into the command.
	 * @param commandText
	 * @return
	 */
	private CommandNode generateUserCommandNode(String commandText) {
		scan.next(); //bypass "[" for paramaters
		String next = scan.next();
		String toBeParsed = "";

		while (!next.equals(endBracket)) {
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
	/**
	 * When a bracket is seen parse all of its contents to form a tree from it which is then added to the bigger tree. This makes loops easy since the same tree can just be re-executed
	 * @param commandText
	 * @return
	 * @throws InvalidCommandException
	 */
	private CommandNode generateBracketNode(String commandText) throws InvalidCommandException{
		int bracketCount = 1;
		String toBeParsed = "";
		String next;
		while (bracketCount != 0) {
			if (!scan.hasNext()) {
				new ErrorBox("Missing Bracket(s)", commandText);
			}
			next = scan.next();
			if (next.equals(endBracket)) {
				bracketCount--;
				if (bracketCount == 0) {
					break;
				}
			}
			if (next.equals(startBracket)) {
				bracketCount++;
			}
			toBeParsed = toBeParsed + " " + next;
		}
		Parser newParser = new Parser(variableMap, userCommandMap, myLanguage);
		CommandNode bracketNode = newParser.parse(toBeParsed);
		newSuperNodeAdded = true;
		return bracketNode;
	}
	/**
	 * From the classNameToMethod.properties file, this method is found for commands which have no constructor
	 * @param className
	 * @return
	 */
	private CommandNode generateNoConstructorCommand(String className) {
		Object classInstance = commandHandler.getClassInstance(className);
		CommandObject generatedCommand = (CommandObject) classInstance;
		return new CommandNode(generatedCommand);
	}
	/**
	 * From the classNameToMethod.properties file, this method is invoked for instances of MakeUserInstruction
	 * @param className
	 * @return
	 */
	private CommandNode generateUserCommand(String className) {
		String name = scan.next();
		scan.next(); // pass by initial bracket "["
		List<String> variables = new ArrayList<>();
		String next = scan.next();
		while (!next.equals(endBracket)) {
			variables.add(next);
			next = scan.next();
		}
		next = scan.next();
		String commands = "";
		int bracketCount = 0;
		while (scan.hasNext()) {
			if (next.equals(endBracket)){
				bracketCount--;
				if (bracketCount == 0) {
					break;
				}
			}
			else if (next.equals(startBracket)){
				bracketCount++;
			}
			commands = commands + next + " ";
			next = scan.next();
		}
		commands += next;
		CommandNode userCommand = new CommandNode(new MakeUserInstruction(variables, commands, null, myLanguage, variableMap, userCommandMap));
		userCommandMap.put(name.toLowerCase(), (Command)userCommand.getCommand());
		return userCommand;
	}
	/**
	 * From the classNameToMethod.properties file, this method is found commands which need access to the variableMap
	 * @param className
	 * @return
	 */
	private CommandNode generateVariableMapCommand(String className) {
		return new CommandNode(new MakeVariable(scan.next(), variableMap));
	}
}