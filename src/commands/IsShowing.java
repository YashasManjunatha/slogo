package commands;

import java.util.List;

import Turtle.Turtle;

public class IsShowing extends Command {
	private int numberOfParameters = 0;

	@Override
	double execute(List<CommandNode> children, Turtle t){
		if (t.getTurtleShowing()) return 1;
		else { 
			return 0;
			} 	
	}

	@Override
	int getNumberOfParameters() {
		return numberOfParameters;
	}

}
