package commands;

import java.util.List;

import Turtle.Turtle;

/**
 * Implements functionality for Minus Command
 *
 */
public class MinusCommand extends Command {
	private int numberOfParameters = 1;

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List, Turtle.Turtle)
	 */
	@Override
	double execute(List<CommandNode> children, Turtle t){
		CommandNode child1 = children.get(0);
		
		double x=-1*child1.execute(t);
		
		return x;
	}

	/* (non-Javadoc)
	 * @see commands.Command#getNumberOfParameters()
	 */
	@Override
	int getNumberOfParameters() {
		return numberOfParameters;
	}
}
