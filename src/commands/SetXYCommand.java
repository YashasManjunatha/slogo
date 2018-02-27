package commands;

import java.util.List;

import Turtle.Turtle;

public class SetXYCommand extends Command {
	private int numberOfParameters = 2;
	double x;
	double y;
	double dist;
	
	  @Override
	   public double execute(List<CommandNode> children, Turtle t){
		   CommandNode child1 = children.get(0);
		   CommandNode child2 = children.get(1);
		   x=child1.execute(t);
		   y=child2.execute(t);
		   double x1 =t.getX();
		   double y1 =t.getY();
		   double X=x-x1;
		   System.out.println(x1+" "+y1);
		   double Y=y-y1;
		   double s =X*X+Y*Y;
		   dist=Math.sqrt(s);
		  // System.out.println(y1+" "+Y);
		   //for now I am just going to move turtle the distance in y
		   //x is not implemented yet
		   t.move(X, Y);
		   return dist;
	   }

	   @Override
		public int getNumberOfParameters() {
			return numberOfParameters;
		}
}
