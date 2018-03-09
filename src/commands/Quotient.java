package commands;

import java.util.List;
import Turtle.Turtle;

/**
 * Implements functionality for Quotient Command
 *
 */
public class Quotient extends Command {

	private int numberOfParameters = 2;

	  /* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List, Turtle.Turtle)
	 */
	@Override
	  double execute(List<CommandNode> children, Turtle t){
		  CommandNode child1 = children.get(0);
		  CommandNode child2 = children.get(1);
		   double x=child1.execute(t);
		   double y=child2.execute(t);
			return x/y;
	  }

	  /* (non-Javadoc)
	 * @see commands.Command#getNumberOfParameters()
	 */
	@Override
	  int getNumberOfParameters() {
			return numberOfParameters;
		}


}
