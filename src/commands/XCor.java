package commands;

import java.util.List;

import Turtle.Turtle;

public class XCor extends Command{
	private int numberOfParameters = 0;

	@Override
	public double execute(List<CommandNode> children, Turtle t){
		return t.getX();
		
	}

	@Override
	public int getNumberOfParameters() {
		return numberOfParameters;
	}
}
