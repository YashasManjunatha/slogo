package commands;
import java.util.List;

import Turtle.Turtle;

public class Forward extends Command{
     private int numberOfParameters = 1;

   @Override
   double execute(List<CommandNode> children, Turtle t){
	   CommandNode child = children.get(0);
	   double step = child.execute(t);
	   t.move(step);
	   return step;
   }

   @Override
   int getNumberOfParameters() {
		return numberOfParameters;
	}

}
