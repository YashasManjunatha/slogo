package commands;

import java.util.List;

import Turtle.Turtle;

/**
 * Implements functionality for YCoordinate Command
 *
 */
public class YCoordinate extends Command{
	private final int numberOfParameters = 0;

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List, Turtle.Turtle)
	 */
	@Override
	double execute(List<CommandNode> children, Turtle t){
		return t.getY();
		
	}

	/* (non-Javadoc)
	 * @see commands.Command#getNumberOfParameters()
	 */
	@Override
	int getNumberOfParameters() {
		return numberOfParameters;
	}
}