package commands;

import java.util.List;

import Turtle.Turtle;

public class SetHeading extends Command {
	private int numberOfParameters = 1;
	double step;
	
	  @Override
	   public double execute(List<CommandNode> children, Turtle t){
		   CommandNode child = children.get(0);
		   step=child.execute(t);
		   double currentHeading = t.getOrientation();
		   double move =currentHeading-step;
		   t.turn(move);   
		   return step;
	   }

	   @Override
		public int getNumberOfParameters() {
			return numberOfParameters;
		}
}

