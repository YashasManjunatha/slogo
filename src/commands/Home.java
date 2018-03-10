package commands;

import java.util.List;

import Turtle.Turtle;

/**
 * Implements functionality for Home Command
 *
 */
public class Home extends Command {
	private final int numberOfParameters = 0;
	double step;
	
	  /* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List, Turtle.Turtle)
	 */
	@Override
	   double execute(List<CommandNode> children, Turtle t){
	       double x=t.getX();
	       double y =t.getY();
	       double s =x*x+y*y;
	       step=Math.round(Math.sqrt(s));
		   System.out.println(t.getPenDown());
		   t.moveTo(0, 0);
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
