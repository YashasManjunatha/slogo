package commands;

import java.util.List;

import Turtle.Turtle;

public class Sine extends Command{
	private int numberOfParameters = 1;
	
	@Override
	public double execute(List<CommandNode> children, Turtle t){
		CommandNode child = children.get(0);
		return Math.toDegrees(Math.sin(Math.toRadians(child.execute(t))));
	}

	@Override
	public int getNumberOfParameters() {
		return numberOfParameters;
	}
}
