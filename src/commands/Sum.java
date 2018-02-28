package commands;

import java.util.List;

import Turtle.Turtle;

public class Sum extends Command {
	private int numberOfParameters = 2;

	@Override
	public double execute(List<CommandNode> children, Turtle t){
		CommandNode child1 = children.get(0);
		CommandNode child2 = children.get(1);
		double x=child1.execute(t);
		double y=child2.execute(t);
		return x+y;
	}

	@Override
	public int getNumberOfParameters() {
		return numberOfParameters;
	}
}
