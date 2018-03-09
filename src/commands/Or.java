package commands;

import java.util.List;

import Turtle.Turtle;

/**
 * Implements functionality for Or Command
 *
 */
public class Or extends Command {
	private int numberOfParameters = 2;

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List, Turtle.Turtle)
	 */
	@Override
	double execute(List<CommandNode> children, Turtle t){
		CommandNode child1 = children.get(0);
		CommandNode child2 = children.get(1);
		if(child1.execute(t)!=0 | child2.execute(t)!=0) {
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
