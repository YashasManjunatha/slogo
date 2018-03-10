package commands;

import java.util.List;

import Turtle.Turtle;

/**
 * Implements functionality for Random Command
 *
 */
public class Random extends Command {

	private final int numberOfParameters = 1;

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List, Turtle.Turtle)
	 */
	@Override
	double execute(List<CommandNode> children, Turtle t){
		CommandNode child1 = children.get(0);
		double x=child1.execute(t);
		double rand = Math.round(Math.random()*(x-1));
		System.out.println("random:"+rand);
		return rand;
	}

	/* (non-Javadoc)
	 * @see commands.Command#getNumberOfParameters()
	 */
	@Override
	int getNumberOfParameters() {
		return numberOfParameters;
	}

}
