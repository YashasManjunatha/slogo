package commands;

import java.util.List;

import Turtle.Turtle;

public class Pi extends Command{
	private int numberOfParameters = 0;

	@Override
	public double execute(List<CommandNode> children, Turtle t){
		return Math.PI;
	}

	@Override
	public int getNumberOfParameters() {
		return numberOfParameters;
	}
}