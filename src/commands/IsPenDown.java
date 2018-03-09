package commands;

import java.util.List;

import Turtle.Turtle;

/**
 * Implements functionality for IsPenDown Command
 *
 */
public class IsPenDown extends Command {
	private int numberOfParameters = 0;

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List, Turtle.Turtle)
	 */
	@Override
	double execute(List<CommandNode> children, Turtle t){
		if (t.getPenDown()) {
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
