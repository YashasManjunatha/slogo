package commands;

import java.util.List;
import Turtle.Turtle;

/**
 * Implements functionality for If Command
 *
 */
public class If extends Command {

	private int numberOfParameters = 2;
	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List, Turtle.Turtle)
	 */
	@Override
	double execute(List<CommandNode> children, Turtle t){
		double retVal = 0;
		CommandNode bracketNode = children.get(1);
		if(children.get(0).execute(t)!=0) {
			retVal = bracketNode.execute(t);		
		}
		return retVal;
		
	}

	/* (non-Javadoc)
	 * @see commands.Command#getNumberOfParameters()
	 */
	@Override
	public int getNumberOfParameters() {
		return numberOfParameters;
	}

}
