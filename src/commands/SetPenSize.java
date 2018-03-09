package commands;

import java.util.List;

import Turtle.Turtle;

public class SetPenSize  extends Command{
	private int numberOfParameters = 1;

	
	  @Override
	   double execute(List<CommandNode> children, Turtle t){
	       double pixels = children.get(0).execute(t);
	       //action: sets size of the pen to be pixels thickness
		   return pixels;
	   }

	   @Override
	   int getNumberOfParameters() {
			return numberOfParameters;
		}
}
