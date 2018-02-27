package commands;

import java.util.List;

import Turtle.Turtle;

public class HideTurtle extends Command {

	private int numberOfParameters = 0;

	@Override
	public double execute(List<CommandNode> children, Turtle t){
		t.setTurtleShowing(false);
		return 0;
	}

	@Override
	public int getNumberOfParameters() {
		return numberOfParameters;
	}




}
