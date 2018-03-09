package commands;

import java.util.List;

import Turtle.Turtle;


public class Turtles extends Command {
	private int numberOfParameters = 0;

	@Override
	double execute(List<CommandNode> children, Turtle t){
		double x=0;//total number of turtles
		return x;
	}

	@Override
	int getNumberOfParameters() {
		return numberOfParameters;
	}
}
