package commands;

import java.util.List;
import Turtle.Turtle;

/**
 * Implements functionality for ShowTurtle Command
 *
 */
public class ShowTurtle extends Command{
	private int numberOfParameters = 0;

  /* (non-Javadoc)
 * @see commands.Command#execute(java.util.List, Turtle.Turtle)
 */
@Override
  double execute(List<CommandNode> children, Turtle t){
	    t.setTurtleShowing(true);
		return 1;
  }

  /* (non-Javadoc)
 * @see commands.Command#getNumberOfParameters()
 */
@Override
	int getNumberOfParameters() {
		return numberOfParameters;
	}

	
	
}
