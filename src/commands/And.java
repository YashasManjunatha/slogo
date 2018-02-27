package commands;

import java.util.List;
import Turtle.Turtle;

public class And extends Command{
	private int numberOfParameters = 2;

	@Override
	public double execute(List<CommandNode> children, Turtle t){
		CommandNode child1 = children.get(0);
		CommandNode child2 = children.get(1);
		if(child1.execute(t)!=0 && child2.execute(t)!=0) return 1;
		else {
			return 0;
		}
	}

	@Override
	public int getNumberOfParameters() {
		return numberOfParameters;
	}
}
