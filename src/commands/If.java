package commands;

import java.util.List;
import Turtle.Turtle;

public class If extends Command {

	private int numberOfParameters = 2;
	@Override
	double execute(List<CommandNode> children, Turtle t){
		double retVal = 0;
		CommandNode bracketNode = children.get(1);
		if(children.get(0).execute(t)!=0) {
			retVal = bracketNode.execute(t);		
		}
		return retVal;
		
	}

	@Override
	public int getNumberOfParameters() {
		return numberOfParameters;
	}

}
