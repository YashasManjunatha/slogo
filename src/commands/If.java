package commands;

import java.util.List;
import Turtle.Turtle;

public class If extends Command {

	@Override
	double execute(List<CommandNode> children, Turtle t){
		double retVal = 0;
		CommandNode bracketNode = children.get(1);
		if(children.get(0).execute(t)!=0) {
			retVal = bracketNode.execute(t);		
		}
		return retVal;
		
	}

	

}
