package commands;

import java.util.List;
import java.util.Map;

import Turtle.Turtle;

public class MakeVariable extends Command{

	private int numberOfParameters = 1;
	private Map<String, Double> myMap;
	private String myName;

	public MakeVariable(String name, Map<String,Double> variables) {
		myMap = variables;
		myName = name;
	}

	@Override
	public double execute(List<CommandNode> children, Turtle t){
		Double myValue = children.get(0).execute(t);
		myMap.put(myName, myValue);
		System.out.println(myMap);
		System.out.println("this sucks " + myName + " " + myMap.get(myName));
		return myValue;

	}

	@Override
	public int getNumberOfParameters() {
		return numberOfParameters;
	}
}
