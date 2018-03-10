package commands;

import java.util.ArrayList;
import java.util.List;

import Turtle.Turtle;


public class Tell extends Command{

	private static int numParams = 2;

	
	@Override
	double execute(List<CommandNode> children, Turtle t) {
		double retVal = 0;
		CommandNode bracketNode1 = children.get(0);
		CommandNode bracketNode2 = children.get(1);
		List<CommandNode> bracket1children = bracketNode1.getChildren();
		
		List<Double> IDs= new ArrayList<>();
		
		for(int i=0; i<bracket1children.size();i++) {
		  IDs.add(bracket1children.get(i).execute(t));
		}
		if(IDs.contains(3)) { //t.getID()
			retVal =bracketNode2.execute(t);
		}
		return retVal;
	}

	@Override
	int getNumberOfParameters() {
		return numParams;
	}
}
