package commands;

import java.util.List;

import Turtle.Turtle;

/**
 * Implements functionality for Pi Command
 *
 */
public class Pi extends Command{
	private int numberOfParameters = 0;
    double retVal = Math.PI;
    
	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List, Turtle.Turtle)
	 */
	@Override
	double execute(List<CommandNode> children, Turtle t){	
			return retVal;
		
	}

	/* (non-Javadoc)
	 * @see commands.Command#getNumberOfParameters()
	 */
	@Override
	int getNumberOfParameters() {
		return numberOfParameters;
	}
}
