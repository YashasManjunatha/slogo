package commands;

import java.util.List;

import GUIBoxes.ErrorBox;
import Turtle.Turtle;

public class Command implements CommandObject{
	private Parser myParser;
	private CommandNode superNode;
	private Turtle myTurtle;
	
	public Command(String text, Turtle turtle) {
		myParser = new Parser();
		myTurtle = turtle;
		System.out.println("constructor " + myTurtle);
		try {
			superNode = myParser.parse(text);
		}
		catch(InvalidCommandException e) {
			new ErrorBox("Invalid Command", "Please Write a Valid Command");
		}
	}
   
	public Command() {
	}
	
	public double execute() {
		for (int x=0; x<superNode.getChildren().size(); x++) {
			superNode.getChildren().get(x).execute(myTurtle);
		}
		return 0;
	}

	@Override
	public int getNumberOfParameters() {
		return (int) Double.POSITIVE_INFINITY;
	}
	
	protected Turtle getTurtle() {
		System.out.println("getturtle in command");
		System.out.println("command " + myTurtle);
		return myTurtle;
	}
	@Override
	public double execute(List<CommandNode> children, Turtle t) { //had to implement this because it's in the interface
		return 0;
	}

}
