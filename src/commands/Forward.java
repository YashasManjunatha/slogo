package commands;
import java.util.List;

import Turtle.Turtle;

public class Forward extends Command{
     private int numberOfParameters = 1;

   @Override
   public double execute(List<CommandNode> children, Turtle t){
	   System.out.println("here!!!******************8");
	   CommandNode child = children.get(0);
	   double step = child.execute(t);
	   t.move(step);
	   return step;
   }

   @Override
	public int getNumberOfParameters() {
		return numberOfParameters;
	}

}
