package commands;

import java.util.List;

import Turtle.Turtle;

/**
 * Implements functionality for Parsing Double
 *
 */
public class ParsedDouble extends Command{
	private double myDouble;
	
	public ParsedDouble(double parsedDouble) {
		myDouble = parsedDouble;
	}
	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List, Turtle.Turtle)
	 */
	@Override
	double execute(List<CommandNode> children, Turtle t) {
		return myDouble;
	}
	/* (non-Javadoc)
	 * @see commands.Command#getNumberOfParameters()
	 */
	@Override
	int getNumberOfParameters() {
		return 0;
	}
	
}
