package commands;

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
	@Override
	public double execute() {
		for (int x=0; x<superNode.getChildren().size(); x++) {
			superNode.getChildren().get(x).getCommand().execute();
		}
		return 0;
	}

	@Override
	public int getNumberOfParameters() {
		return 0;
	}
	
	protected Turtle getTurtle() {
		return myTurtle;
	}
	
	protected CommandNode getNode() {
		
	}

}
