package commands;

import java.lang.reflect.Constructor;
import java.util.Scanner;

public class Parser implements ParserObject{

	@Override
	public CommandNode parse(String text) throws InvalidCommandException{
		CommandNode superNode = new CommandNode(new Command());
		Scanner scan = new Scanner(text);
		generateTree(superNode, scan);
		return superNode;
	}
	
	private void generateTree(CommandNode root, Scanner scan) throws InvalidCommandException{
		while (scan.hasNext()) {
			String nextCommand = scan.next();
			CommandNode child = new CommandNode(generateCommandInstance(nextCommand));
			root.addChild(child);
			int paramsFilled = 0;
			while (scan.hasNext() && child.getNumberOfParameters()<paramsFilled) {
				nextCommand = scan.next();
				CommandNode grandchild = new CommandNode(generateCommandInstance(nextCommand));
				child.addChild(grandchild);
				paramsFilled++;
			}
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
		try {
			Class<?> clazz = Class.forName(commandText);		//find class associated with the command string
			Object obj = clazz.newInstance();	//creating new instance using default constructor since we don't know the parameters yet 
			generatedCommand = (CommandObject) obj;
		}
		catch(Exception e) {
			throw new InvalidCommandException(commandText);
		}
		return generatedCommand;
	}
}
