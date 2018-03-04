package commands;

import java.util.List;
import java.util.Map;

import Turtle.Turtle;

public class MakeVariable extends Command{

	private int numberOfParameters = 2;
	private Map<String, Double> myMap;
	private String myName;

	public MakeVariable(String name, Map<String,Double> variables) {
		myMap = variables;
		myName = name;
	}

	@Override
	public double execute(List<CommandNode> children, Turtle t){
		Double myValue = children.get(1).execute(t);
		myMap.put(myName, myValue);
		return myValue;

	}

	@Override
	public int getNumberOfParameters() {
		return numberOfParameters;
	}
}
