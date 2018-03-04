package commands;

import java.util.List;
import java.util.Map;

import Turtle.Turtle;

public class MakeVar extends Command {
	private int numberOfParameters = 2;
	double value;

	public void MakeVar(String n, Map<String, Double> vars) {
			vars.put(n, value);
	}
	
	@Override
	public double execute(List<CommandNode> children, Turtle t){
		value = children.get(0).execute(t);
		return value;
	
	}

	@Override
	public int getNumberOfParameters() {
		return numberOfParameters;
	}

}
