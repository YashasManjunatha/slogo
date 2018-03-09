package commands;

import java.util.List;

import Turtle.Turtle;

/**
 * Implements functionality for Power Command
 *
 */
public class Power extends Command{
	private int numberOfParameters = 2;
	
	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List, Turtle.Turtle)
	 */
	@Override
	double execute(List<CommandNode> children, Turtle t){
		CommandNode base = children.get(0);
		CommandNode exponent = children.get(1);
		return Math.pow(base.execute(t), exponent.execute(t));
	}

	/* (non-Javadoc)
	 * @see commands.Command#getNumberOfParameters()
	 */
	@Override
    int getNumberOfParameters() {
		return numberOfParameters;
	}
}
