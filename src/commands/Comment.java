package commands;

import java.util.List;

import Turtle.Turtle;

public class Comment extends Command{
	private int numberOfParameters = 0;
	@Override
	double execute(List<CommandNode> children, Turtle t) {
		return 0;
	}
	@Override
	int getNumberOfParameters() {
		return numberOfParameters;
	}
}
