package commands;

import java.util.List;

import Turtle.Turtle;

/**
 * Implements functionality for IsShowing Command
 *
 */
public class IsShowing extends Command {
	private final int numberOfParameters = 0;

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List, Turtle.Turtle)
	 */
	@Override
	double execute(List<CommandNode> children, Turtle t){
		if (t.getTurtleShowing()) {
		    return 1;
		}
		else { 
			return 0;
			} 	
	}

	/* (non-Javadoc)
	 * @see commands.Command#getNumberOfParameters()
	 */
	@Override
	int getNumberOfParameters() {
		return numberOfParameters;
	}

}
