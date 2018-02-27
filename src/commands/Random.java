package commands;

import java.util.List;

import Turtle.Turtle;

public class Random extends Command {

	private int numberOfParameters = 1;

	@Override
	public double execute(List<CommandNode> children, Turtle t){
		CommandNode child1 = children.get(0);
		double x=child1.execute(t);
		double rand = Math.round(Math.random()*(x-1));
		System.out.println("random:"+rand);
		return rand;
	}

	@Override
	public int getNumberOfParameters() {
		return numberOfParameters;
	}

}
