package commands;

import java.util.List;

import Turtle.Turtle;

public class ClearStamps extends Command{
	private final static int numParams = 0;
	double one =1;
	double zero =0;
	
	@Override
	double execute(List<CommandNode> children, Turtle t) {
	
			return t.clearStamps();
			
		
		
		
		
	}

}