package commands;

import java.util.List;

import Turtle.Turtle;

public class NaturalLog extends Command{
	private int numberOfParameters = 1;
	
	@Override
	double execute(List<CommandNode> children, Turtle t){
		CommandNode child = children.get(0);
		return Math.log(child.execute(t));
	}

	@Override
	int getNumberOfParameters() {
		return numberOfParameters;
	}
}
