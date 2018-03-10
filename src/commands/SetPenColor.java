package commands;
import java.util.List;
import Turtle.Turtle;
/**
 * Implements functionality for SetPenColor Command
 *
 */
public class SetPenColor extends Command {
private final int numberOfParameters = 1;

	
	  @Override
	   double execute(List<CommandNode> children, Turtle t){
	       int index =(int) children.get(0).execute(t);
	       t.changePenColorIndex(index);
	       //action here: set color of the pen o that represented by index
		   return index;
	   }

	   @Override
	   int getNumberOfParameters() {
			return numberOfParameters;
		}
}
