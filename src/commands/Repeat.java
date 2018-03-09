package commands;

import java.util.List;

import Turtle.Turtle;

/**
 * Implements functionality for Repeat Command
 *
 */
public class Repeat extends Command{
	private static int numParams = 2;

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List, Turtle.Turtle)
	 */
	@Override
	double execute(List<CommandNode> children, Turtle t) {
		double numRepeat = children.get(0).execute(t);
		double retVal = 0;
		CommandNode bracketNode = children.get(1);
		for (int x=0; x<numRepeat; x++) {
			retVal = bracketNode.execute(t);
		}
		return retVal;
	}
	
	/* (non-Javadoc)
	 * @see commands.Command#getNumberOfParameters()
	 */
	@Override
	int getNumberOfParameters() {
		return numParams;
	}
}
