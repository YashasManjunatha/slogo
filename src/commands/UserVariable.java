package commands;

import java.util.List;
import java.util.Map;

import Turtle.Turtle;

public class UserVariable extends Command{
	private int numberOfParameters = 1;
	private Map<String, Double> myMap;
	private String myName;
	
	public UserVariable(String varName, Map<String, Double> variables) {
		myMap = variables;
	}
	
	@Override
	public double execute(List<CommandNode> children, Turtle t) {
		Double myValue = children.get(0).execute(t);
		myMap.put(myName, myValue);
		return myValue;
	}
	@Override
	public int getNumberOfParameters() {
		return numberOfParameters;
	}
	
}
