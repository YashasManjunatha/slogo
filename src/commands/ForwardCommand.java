package commands;
import java.util.List;

import Turtle.Turtle;

public class ForwardCommand extends Command{
     private int numberOfParameters = 1;
     double step;

   @Override
   public double execute(List<CommandNode> children, Turtle t){
	   CommandNode child = children.get(0);
		return t.move(child.execute(t));
   }

   @Override
	public int getNumberOfParameters() {
		return numberOfParameters;
	}

}
