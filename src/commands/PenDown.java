package commands;

import java.util.List;
import Turtle.Turtle;

/**
 * Implements functionality for PenDown Command
 *
 */
public class PenDown extends Command {
	private final int numberOfParameters = 0;
	private double myReturn=1;

	  /* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List, Turtle.Turtle)
	 */
	@Override
	  double execute(List<CommandNode> children, Turtle t){
		    t.setPenDown(true);
			return myReturn;
	  }

	  /* (non-Javadoc)
	 * @see commands.Command#getNumberOfParameters()
	 */
	@Override
	   int getNumberOfParameters() {
			return numberOfParameters;
		}

}
