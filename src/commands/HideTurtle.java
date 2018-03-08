package commands;

import java.util.List;

import Turtle.Turtle;

public class HideTurtle extends Command {

	private int numberOfParameters = 0;

	@Override
	double execute(List<CommandNode> children, Turtle t){
		t.setTurtleShowing(false);
		return 0;
	}

	@Override
	int getNumberOfParameters() {
		return numberOfParameters;
	}




}
