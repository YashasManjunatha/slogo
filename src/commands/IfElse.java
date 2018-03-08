package commands;

import java.util.List;
import Turtle.Turtle;

public class IfElse extends Command {
	
	private int numberOfParameters = 3;

	@Override
	double execute(List<CommandNode> children, Turtle t){
		double retVal = 0;
		CommandNode bracketNode1 = children.get(1);
		CommandNode bracketNode2 = children.get(2);
		if(children.get(0).execute(t)!=0) {
			retVal = bracketNode1.execute(t);		
		}
		else {
			retVal = bracketNode2.execute(t);
		}
		return retVal;
		
	}
	
	@Override
     int getNumberOfParameters() {
		return numberOfParameters;
	}

}
