package commands;

import java.util.List;
import java.util.Map;

import Turtle.Turtle;

public class DoTimes extends Command{
	private Map<String, Double> myMap;
	private static int numParams = 2;

	public DoTimes(Map<String, Double>variableMap){
		myMap=variableMap;
	}
	@Override
	double execute(List<CommandNode> children, Turtle t){

		double retVal=0;

		CommandNode bracketNode1 = children.get(0);
		List<CommandNode> bracket1children = bracketNode1.getChildren();
		CommandNode variable = bracket1children.get(0);

		double limit = bracket1children.get(1).execute(t);

		CommandNode bracketNode2 = children.get(1);
		CommandObject var =variable.getCommand();
		var.setValue(1);

		for(int i=1; i<=limit; i++) {	
			retVal =bracketNode2.execute(t);
			var.setValue(i+1);
		}

		return retVal;	
	}

	@Override
	int getNumberOfParameters() {
		return numParams;
	}



}
