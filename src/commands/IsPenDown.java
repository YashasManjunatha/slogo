package commands;

import java.util.List;

import Turtle.Turtle;

public class IsPenDown extends Command {
	private int numberOfParameters = 0;

	@Override
	public double execute(List<CommandNode> children, Turtle t){
		if (t.getPenDown()) { 
			return 1;
		}
		else { 
			return 0;
			} 	
	}

	@Override
	public int getNumberOfParameters() {
		return numberOfParameters;
	}

}
