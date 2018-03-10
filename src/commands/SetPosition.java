package commands;

import java.util.List;

import Turtle.Turtle;

/**
 * Implements functionality for SetPosition Command
 *
 */
public class SetPosition extends Command {
	private int numberOfParameters = 2;
	double x;
	double y;
	double dist=0;
	
	  /* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List, Turtle.Turtle)
	 */
	@Override
	  double execute(List<CommandNode> children, Turtle t){
		if(t.isActive()) {
			
		   CommandNode child1 = children.get(0);
		   CommandNode child2 = children.get(1);
		   x=child1.execute(t);
		   y=child2.execute(t);		  
		   double x1 =t.getX();
		   double y1 =t.getY();
		   double X=x-x1;
		   double Y=y1-y;
		   double s =X*X+Y*Y;
		   dist=Math.sqrt(s);
		   t.moveTo(x, -y);
		}
		   return dist;
	   }

	   /* (non-Javadoc)
	 * @see commands.Command#getNumberOfParameters()
	 */
	@Override
		int getNumberOfParameters() {
			return numberOfParameters;
		}
}
