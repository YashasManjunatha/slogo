package commands;

import java.util.List;
import Turtle.Turtle;

/**
 * Implements functionality for Not Command
 *
 */
public class Not extends Command{
	private final int numberOfParameters = 1;

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List, Turtle.Turtle)
	 */
	@Override
	double execute(List<CommandNode> children, Turtle t){
		CommandNode child1 = children.get(0);
		if(child1.execute(t)==0) {
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
