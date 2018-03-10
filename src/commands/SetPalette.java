package commands;

import java.util.List;
import Turtle.Turtle;
/**
 * It is not implemented in the front end but the commands is made in case we
 * wanted to update it in the future
 *
 */
public class SetPalette extends Command{
	private  final int numberOfParameters = 4;

	
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
