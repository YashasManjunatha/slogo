package commands;

import java.util.List;

import Turtle.Turtle;

public class SetShape extends Command {
	private int numberOfParameters = 1;

	
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
