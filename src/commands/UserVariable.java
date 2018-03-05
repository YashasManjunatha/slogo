package commands;

import java.util.List;
import java.util.Map;

import Turtle.Turtle;

public class UserVariable extends Command{
	private int numberOfParameters = 0;
	private Map<String, Double> myMap;
	private String myName;
	
	public UserVariable(String varName, Map<String, Double> variables) {
		myMap = variables;
		myName = varName;
	}
	
	@Override
	public double execute(List<CommandNode> children, Turtle t) {
		return myMap.get(myName);
	}
	@Override
	public int getNumberOfParameters() {
		return numberOfParameters;
	}
	
	@Override
	public void setValue(double x) {
		if(myMap.containsKey(myName)) {
			double y =myMap.get(myName);
			myMap.replace(myName,y,x);
		}
		else{
			myMap.put(myName, x);
		}
	}
}
