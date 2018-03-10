package commands;

import java.util.List;

import Turtle.Turtle;

/**
 * Implements functionality for TURTLES command, returns total number of turtles
 *
 */
public class Turtles extends Command {
	private final int numberOfParameters = 0;

	@Override
	double execute(List<CommandNode> children, Turtle t){
	return t.getTurtleFriends().size();
	}

	@Override
	int getNumberOfParameters() {
		return numberOfParameters;
	}
}
