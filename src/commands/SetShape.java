package commands;

import java.util.List;

import Turtle.Turtle;
/**
 * We did not actually implement this on the front end since we did not know
 * what the shape means in this sense, but the command is made if it needs to be
 * updated in the future
 */
public class SetShape extends Command {
	private final int numberOfParameters = 1;

	
	  @Override
	   double execute(List<CommandNode> children, Turtle t){
	       double pixels = children.get(0).execute(t);
	       //action: sets shape of turtle to that represented by index
		   return pixels;
	   }

	   @Override
	   int getNumberOfParameters() {
			return numberOfParameters;
		}
}
