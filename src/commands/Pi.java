package commands;

import java.util.List;

import Turtle.Turtle;

public class Pi extends Command{
	private int numberOfParameters = 0;
    double retVal = Math.PI;
	@Override
	public double execute(List<CommandNode> children, Turtle t){
		
			return retVal;
		
	}

	@Override
	public int getNumberOfParameters() {
		return numberOfParameters;
	}
}
