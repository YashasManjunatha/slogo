package commands;

import java.util.List;

import Turtle.Turtle;

public class ClearScreen extends Command{
	private int numberOfParameters = 0;

	@Override
	double execute(List<CommandNode> children, Turtle t){
		return t.clearScreen();
	}

	@Override
	int getNumberOfParameters() {
		return numberOfParameters;
	}
}
