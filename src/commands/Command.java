package commands;

import java.util.List;
import java.util.Map;

import GUIBoxes.ErrorBox;
import Turtle.Turtle;

public class Command implements CommandObject{
	private Parser myParser;
	private CommandNode superNode;
	private Turtle myTurtle;
	
	public Command(String text, Turtle turtle, Map<String, Double> variables, Map<String, Command> commands, String language) {
		myParser = new Parser(variables, commands, language);
		myTurtle = turtle;
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
	
	public Turtle getTurtle() {
		return myTurtle;
	}
	@Override
	public double execute(List<CommandNode> children, Turtle t) { //had to implement this because it's in the interface
		double retVal = 0;
		for (CommandNode child: children) {
			retVal = child.execute(t);
		}
		return retVal;
	}
	@Override
	public void setValue(double x) {
		// TODO Auto-generated method stub
		
	}

}
