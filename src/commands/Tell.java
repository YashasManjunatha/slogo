package commands;

import java.util.ArrayList;
import java.util.List;

import Turtle.Turtle;


public class Tell extends Command{

	private static int numParams = 2;

	
	@Override
	double execute(List<CommandNode> children, Turtle t) {
		double retVal = 0;
		//check if the turtle is active and if its id is present, 
		//if not active but id here, set active, otherwise inactive
		
		//also need the list of all existing ids, if the id does not exist, 
		//make new turtle
		return retVal;
	}

	@Override
	int getNumberOfParameters() {
		return numParams;
	}
}
