package commands;

import java.util.List;
import Turtle.Turtle;

public class PenUp extends Command {
	private int numberOfParameters = 0;
	private double myReturn=0;
	
	  @Override
	  public double execute(List<CommandNode> children, Turtle t){
		    t.setPenDown(false);
			return myReturn;
	  }

	  @Override
		public int getNumberOfParameters() {
			return numberOfParameters;
		}

}