package commands;

import java.util.List;

import Turtle.Turtle;

/**
 * Implements functionality for SetHeading Command
 *  Stefani Vukajlovic
 */
public class SetHeading extends Command {
	private final int numberOfParameters = 1;
	double step;
	
	  /* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List, Turtle.Turtle)
	 */
	@Override
	   double execute(List<CommandNode> children, Turtle t){
		   CommandNode child = children.get(0);
		   step=child.execute(t);
		   double currentHeading = t.getOrientation();
		   double move =currentHeading-step;
		   t.turn(move);   
		   return step;
	   }

	   /* (non-Javadoc)
	 * @see commands.Command#getNumberOfParameters()
	 */
	@Override
	   int getNumberOfParameters() {
			return numberOfParameters;
		}
}

