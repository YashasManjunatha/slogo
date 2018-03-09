package commands;
import java.util.List;

import Turtle.Turtle;

public class Backward extends Command{
     private int numberOfParameters = 1;
     double step;

   @Override
   double execute(List<CommandNode> children, Turtle t){
	   CommandNode child = children.get(0);
	   step = -1 * child.execute(t);
	   t.move(step);
	   return -1*step;
   }

   @Override
	int getNumberOfParameters() {
		return numberOfParameters;
	}

}
