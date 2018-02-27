package commands;

import java.util.List;

import Turtle.Turtle;

public class ParsedDouble extends Command{
	private double myDouble;
	
	public ParsedDouble(double parsedDouble) {
		myDouble = parsedDouble;
	}
	@Override
	public double execute(List<CommandNode> children, Turtle t) {
		return myDouble;
	}
	@Override
	public int getNumberOfParameters() {
		return 0;
	}
	
}
