package commands;

import java.util.List;

import Turtle.Turtle;

public class SetBackground extends Command {
	private int numberOfParameters = 1;

	
	  @Override
	   double execute(List<CommandNode> children, Turtle t){
	       double index = children.get(0).execute(t);
	       //action: sets background color of screen to that represented by index
		   return index;
	   }

	   @Override
	   int getNumberOfParameters() {
			return numberOfParameters;
		}
}
