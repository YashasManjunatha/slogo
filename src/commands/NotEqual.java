package commands;

import java.util.List;
import Turtle.Turtle;

public class NotEqual  extends Command{
	
	private int numberOfParameters = 2;

	@Override
	double execute(List<CommandNode> children, Turtle t){
		CommandNode child1 = children.get(0);
		CommandNode child2 = children.get(1);
		double x=child1.execute(t);
		double y=child2.execute(t);
		if(x!=y) return 1;
		else {
			return 0;
		}
	}

	@Override
	int getNumberOfParameters() {
		return numberOfParameters;
	}

}