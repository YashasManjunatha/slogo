package commands;

import java.util.List;

import Turtle.Turtle;

/**
 * Implements functionality for HideTurtle Command
 *
 */
public class HideTurtle extends Command {

	private int numberOfParameters = 0;

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List, Turtle.Turtle)
	 */
	@Override
	double execute(List<CommandNode> children, Turtle t){
		t.setTurtleShowing(false);
		return 0;
	}

	/* (non-Javadoc)
	 * @see commands.Command#getNumberOfParameters()
	 */
	@Override
	int getNumberOfParameters() {
		return numberOfParameters;
	}




}
