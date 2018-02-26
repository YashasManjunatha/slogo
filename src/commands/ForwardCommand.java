package commands;
import java.util.List;

public class ForwardCommand extends Command{
     private int numberOfInputs = 1;
     double step;

   @Override
   public double execute(List<CommandNode> children ){
	   CommandNode child = children.get(0);
	   step = child.execute();
	  // myTurtle.   how to call move method on turtle
	   this.getTurtle().move(step,0);
	   return step;
   }

   @Override
	public int getNumberOfParameters() {
		return numberOfInputs;
	}

}
