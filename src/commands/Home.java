package commands;

import java.util.List;

import Turtle.Turtle;

public class Home extends Command {
	private int numberOfParameters = 0;
	double step;
	
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

	   @Override
	   int getNumberOfParameters() {
			return numberOfParameters;
		}

}
