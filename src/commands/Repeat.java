package commands;

import java.util.List;

import Turtle.Turtle;

public class Repeat extends Command{
	private static int numParams = 2;

	@Override
	double execute(List<CommandNode> children, Turtle t) {
		double numRepeat = children.get(0).execute(t);
		double retVal = 0;
		CommandNode bracketNode = children.get(1);
		for (int x=0; x<numRepeat; x++) {
			retVal = bracketNode.execute(t);
		}
		return retVal;
	}
	
	@Override
	int getNumberOfParameters() {
		return numParams;
	}
}
