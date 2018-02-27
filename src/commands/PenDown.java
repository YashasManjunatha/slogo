package commands;

import java.util.List;
import Turtle.Turtle;

public class PenDown extends Command {
	private int numberOfParameters = 0;
	private double myReturn=1;

	  @Override
	  public double execute(List<CommandNode> children, Turtle t){
		    t.setPenDown(true);
			return myReturn;
	  }

	  @Override
		public int getNumberOfParameters() {
			return numberOfParameters;
		}

}
