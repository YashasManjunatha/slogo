package commands;

import java.util.List;
import Turtle.Turtle;

public class Not extends Command{
	private int numberOfParameters = 1;

	@Override
	double execute(List<CommandNode> children, Turtle t){
		CommandNode child1 = children.get(0);
		if(child1.execute(t)==0) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	int getNumberOfParameters() {
		return numberOfParameters;
	}
}
