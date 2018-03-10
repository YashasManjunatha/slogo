package commands;

import java.util.ArrayList;
import java.util.List;

import Turtle.Turtle;

public class AskWith extends Command{
private final static int numParams = 2;

	
	@Override
	double execute(List<CommandNode> children, Turtle t) {
		double retVal = 0;
		CommandNode bracketNode1 = children.get(0);
		CommandNode bracketNode2 = children.get(1);

		if(bracketNode1.execute(t)==1) { 
			retVal =bracketNode2.execute(t);
		}
		return retVal;
	}

	@Override
	int getNumberOfParameters() {
		return numParams;
	}
}
