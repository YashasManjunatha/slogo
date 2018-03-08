package commands;

import java.util.List;

import Turtle.Turtle;

public class Power extends Command{
	private int numberOfParameters = 2;
	
	@Override
	double execute(List<CommandNode> children, Turtle t){
		CommandNode base = children.get(0);
		CommandNode exponent = children.get(1);
		return Math.pow(base.execute(t), exponent.execute(t));
	}

	@Override
    int getNumberOfParameters() {
		return numberOfParameters;
	}
}
