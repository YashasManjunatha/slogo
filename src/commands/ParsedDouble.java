package commands;

import java.util.List;

import Turtle.Turtle;

public class ParsedDouble extends Command{
	private double myDouble;
	
	public ParsedDouble(double parsedDouble) {
		System.out.println("PARSED DOUBLE: " + parsedDouble);
		myDouble = parsedDouble;
	}
	@Override
	double execute(List<CommandNode> children, Turtle t) {
		return myDouble;
	}
	@Override
	int getNumberOfParameters() {
		return 0;
	}
	
}
