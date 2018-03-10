package commands;

import java.util.List;
import java.util.Map;

import GUIBoxes.ErrorBox;
import Turtle.Turtle;
/**
 * The Command superclass is instantiated on the front end and initially passed all the text.
 * It parses the text and then executes on every branch of the superNode
 * @author milestodzo
 *
 */
public class Command extends CommandObject{
	private Parser myParser;
	private CommandNode superNode;
	private Turtle myTurtle;
	private String myText;
	
	public Command(String text, Turtle turtle, Map<String, Double> variables, Map<String, Command> commands, String language) {
		myText = text;
		myParser = new Parser(variables, commands, language);
		myTurtle = turtle;
		SaveCurrentStates s = new SaveCurrentStates(variables,commands);
		try {
			superNode = myParser.parse(text);
		}
		catch(InvalidCommandException e) {
			new ErrorBox("Invalid Command", "Please Write a Valid Command");
		}
	}
	
	public Command() {
	}
	/**
	 * Call execute for each child of the superNode. Each child executes its own children and so on so that commands are carried out bottom up
	 * @return
	 */
	public double execute() {
		for (int x=0; x<superNode.getChildren().size(); x++) {
			superNode.getChildren().get(x).execute(myTurtle);
		}
		return 0;
	}
	/**
	 * The superNode can have infinite parameters since it is just holding all the other commands together
	 * @return number of parameters (children) the command requires
	 */
	@Override
	int getNumberOfParameters() {
		return (int) Double.POSITIVE_INFINITY;
	}
	/**
	 * 
	 * @return myTurtle
	 */
	public Turtle getTurtle() {
		return myTurtle;
	}
	/**
	 * execute on each child.
	 * @return the value from the last execution
	 */
	@Override
	double execute(List<CommandNode> children, Turtle t) {
		double retVal = 0;
		for (CommandNode child: children) {
			retVal = child.execute(t);
		}
		return retVal;
	}
	/**
	 * 
	 * @return myText
	 */
	public String CommandtoString() {
		return myText;
	}

}
