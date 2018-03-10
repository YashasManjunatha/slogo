package commands;

import java.util.List;

import Turtle.Turtle;

/**
 * Implements functionality for XCoordinate Command
 *
 */
public class XCoordinate extends Command{
	private final int numberOfParameters = 0;

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List, Turtle.Turtle)
	 */
	@Override
	double execute(List<CommandNode> children, Turtle t){
		return t.getX();
		
	}

	/* (non-Javadoc)
	 * @see commands.Command#getNumberOfParameters()
	 */
	@Override
	int getNumberOfParameters() {
		return numberOfParameters;
	}
}
