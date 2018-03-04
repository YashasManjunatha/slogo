package commands;

import java.util.List;
import Turtle.Turtle;

public class IfElse extends Command {
	
	private int numberOfParameters = 3;

	@Override
	public double execute(List<CommandNode> children, Turtle t){
		double num = children.get(0).execute(t);
		double retVal = 0;
		CommandNode bracketNode1 = children.get(1);
		CommandNode bracketNode2 = children.get(2);
		if(num!=0) {
			retVal = bracketNode1.execute(t);		
		}
		else {
			retVal = bracketNode2.execute(t);
		}
		return retVal;
		
	}
	
	@Override
	public int getNumberOfParameters() {
		return numberOfParameters;
	}

}
