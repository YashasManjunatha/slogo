package commands;

import java.util.List;

import Turtle.Turtle;

public class Stamp extends Command{
	private final static int numParams = 0;
	
	@Override
	double execute(List<CommandNode> children, Turtle t) {
		if(t.getActive()) {
			t.addTurtle();
			
			return 1;
		}
		
		else { return 0;}
		
		
	}

}
