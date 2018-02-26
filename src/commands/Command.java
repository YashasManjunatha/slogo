package commands;

import java.util.List;

import Turtle.Turtle;

public class Command implements CommandObject{
	private Parser myParser;
	private CommandNode superNode;
	private Turtle myTurtle;
	
	public Command(String text, Turtle turtle) {
		myParser = new Parser();
		myTurtle = turtle;
		try {
			superNode = myParser.parse(text);
		}
		catch(InvalidCommandException e) {
			//add pop-up screen
		}
	}
   
	public Command() {
	}
	
	public double execute() {
		for (int x=0; x<superNode.getChildren().size(); x++) {
			superNode.getChildren().get(x).execute();
		}
		return 0;
	}

	@Override
	public int getNumberOfParameters() {
		return (int) Double.POSITIVE_INFINITY;
	}
	
	protected Turtle getTurtle() {
		return myTurtle;
	}
	@Override
	public double execute(List<CommandNode> children) { //had to implement this because it's in the interface
		return 0;
	}

}
