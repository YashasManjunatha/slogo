package commands;

import java.util.List;
import Turtle.Turtle;

/**
 * Implements functionality for PenUp Command
 *
 */
public class PenUp extends Command {
	private int numberOfParameters = 0;
	private double myReturn=0;
	
	  /* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List, Turtle.Turtle)
	 */
	@Override
	  double execute(List<CommandNode> children, Turtle t){
		    t.setPenDown(false);
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