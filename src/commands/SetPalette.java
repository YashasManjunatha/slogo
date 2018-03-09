package commands;

import java.util.List;
import Turtle.Turtle;

public class SetPalette extends Command{
	private int numberOfParameters = 4;

	
	  @Override
	   double execute(List<CommandNode> children, Turtle t){
	       double index = children.get(0).execute(t);
	    //action: sets color corresponding at given index to given r g b color values
		   return index;
	   }

	   @Override
	   int getNumberOfParameters() {
			return numberOfParameters;
		}

}
