package commands;

import java.util.List;

import Turtle.Turtle;

public class GetShape extends Command{
	private final int numberOfParameters = 0;

	@Override
	double execute(List<CommandNode> children, Turtle t){
		double index=0; //turtle's current shape index
		return index;	
	}

	@Override
	int getNumberOfParameters() {
		return numberOfParameters;
	}

}
