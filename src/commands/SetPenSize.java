package commands;

import java.util.List;

import Turtle.Turtle;
/**
 * Implements functionality for SetPenSize Command
 *
 */
public class SetPenSize  extends Command{
	private final int numberOfParameters = 1;

	
	  @Override
	   double execute(List<CommandNode> children, Turtle t){
	       double pixels = children.get(0).execute(t);
	       t.setPenThickness(pixels);
		   return pixels;
	   }

	   @Override
	   int getNumberOfParameters() {
			return numberOfParameters;
		}
}
