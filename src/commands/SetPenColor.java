package commands;
import java.util.List;
import Turtle.Turtle;

public class SetPenColor extends Command {
private int numberOfParameters = 1;

	
	  @Override
	   double execute(List<CommandNode> children, Turtle t){
	       double index = children.get(0).execute(t);
	       //action here: set color of the pen o that represented by index
		   return index;
	   }

	   @Override
	   int getNumberOfParameters() {
			return numberOfParameters;
		}
}
