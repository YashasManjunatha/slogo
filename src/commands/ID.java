package commands;

import java.util.List;

import Turtle.Turtle;

public class ID extends Command{
	private int numberOfParameters = 0;

	@Override
	double execute(List<CommandNode> children, Turtle t){
		return t.getID();	
	}

	@Override
	int getNumberOfParameters() {
		return numberOfParameters;
	}

}
