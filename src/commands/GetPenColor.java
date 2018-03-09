package commands;

import java.util.List;

import Turtle.Turtle;

public class GetPenColor extends Command{
	private int numberOfParameters = 0;

	@Override
	double execute(List<CommandNode> children, Turtle t){
		double index=0; //turtle's current color index
		return index;	
	}

	@Override
	int getNumberOfParameters() {
		return numberOfParameters;
	}

}
