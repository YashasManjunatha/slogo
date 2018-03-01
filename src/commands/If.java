package commands;

import java.util.List;

import Turtle.Turtle;

public class If extends Command {

	@Override
	public double execute(List<CommandNode> children, Turtle t){
		CommandNode child1 = children.get(0);
		double retVal = 0;
		if(child1.execute(t)!=0) {
				for (int i=1; i<children.size(); i++) {
					retVal = children.get(i).execute(t);
				}
		};
		
		return 1;
	}

	

}
