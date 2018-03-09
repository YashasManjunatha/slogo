package commands;

import java.util.List;

import Turtle.Turtle;

/**
 * Implements functionality for NaturalLog Command
 *
 */
public class NaturalLog extends Command{
	private int numberOfParameters = 1;
	
	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List, Turtle.Turtle)
	 */
	@Override
	double execute(List<CommandNode> children, Turtle t){
		CommandNode child = children.get(0);
		return Math.log(child.execute(t));
	}

	/* (non-Javadoc)
	 * @see commands.Command#getNumberOfParameters()
	 */
	@Override
	int getNumberOfParameters() {
		return numberOfParameters;
	}
}
