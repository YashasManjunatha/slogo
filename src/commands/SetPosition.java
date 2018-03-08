package commands;

import java.util.List;

import Turtle.Turtle;

public class SetPosition extends Command {
	private int numberOfParameters = 2;
	double x;
	double y;
	double dist;
	
	  @Override
	  double execute(List<CommandNode> children, Turtle t){
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
		   return dist;
	   }

	   @Override
		int getNumberOfParameters() {
			return numberOfParameters;
		}
}
