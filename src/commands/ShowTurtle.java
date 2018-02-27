package commands;

import java.util.List;
import Turtle.Turtle;

public class ShowTurtle extends Command{
	private int numberOfParameters = 0;

  @Override
  public double execute(List<CommandNode> children, Turtle t){
	    t.setTurtleShowing(true);
		return 1;
  }

  @Override
	public int getNumberOfParameters() {
		return numberOfParameters;
	}

	
	
}
