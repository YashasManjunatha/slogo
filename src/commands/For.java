package commands;
import java.util.List;

import Turtle.Turtle;

/**
 * Implements functionality for For Command
 *
 */
public class For extends Command{

  private static int numParams = 2;
  
		/* (non-Javadoc)
		 * @see commands.Command#execute(java.util.List, Turtle.Turtle)
		 */
		@Override
		double execute(List<CommandNode> children, Turtle t){
			
			double retVal=0;
			CommandNode bracketNode1 = children.get(0);
			List<CommandNode> bracket1children = bracketNode1.getChildren();
			
			double start = bracket1children.get(1).execute(t);
			double end = bracket1children.get(2).execute(t);
			double increment = bracket1children.get(3).execute(t);
			
			CommandNode bracketNode2 = children.get(1);
			CommandObject var =bracket1children.get(0).getCommand();
			var.setValue(start);
			
			for(int i =(int) start; i<end; i=i+ (int) increment) {	
			retVal =bracketNode2.execute(t);
			var.setValue(i+1);
			}
		return retVal;
		}
		
	/* (non-Javadoc)
	 * @see commands.Command#getNumberOfParameters()
	 */
	@Override
	int getNumberOfParameters() {
			return numParams;
		}
	
}
