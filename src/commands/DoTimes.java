package commands;

import java.util.List;

import Turtle.Turtle;

/**
 * Implements functionality for DoTimes Command
 *
 */
public class DoTimes extends Command{
	private static int numParams = 2;
	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List, Turtle.Turtle)
	 */
	@Override
	double execute(List<CommandNode> children, Turtle t){

		double retVal=0;

		CommandNode bracketNode1 = children.get(0);
		List<CommandNode> bracket1children = bracketNode1.getChildren();
		CommandNode variable = bracket1children.get(0);

		double limit = bracket1children.get(1).execute(t);

		CommandNode bracketNode2 = children.get(1);
		UserVariable var = (UserVariable) variable.getCommand();
		var.setValue(1);

		for(int i=1; i<=limit; i++) {	
			retVal =bracketNode2.execute(t);
			var.setValue(i+1);
		}

		return retVal;	
	}

	/* (non-Javadoc)
	 * @see commands.Command#getNumberOfParameters()
	 */
	@Override
	int getNumberOfParameters() {
		return numParams;
	}



}
