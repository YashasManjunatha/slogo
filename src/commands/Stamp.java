package commands;

import java.util.List;

import Turtle.Turtle;

public class Stamp extends Command{
    
    @Override
    double execute(List<CommandNode> children, Turtle t) { 
	System.out.println("stamping");
	t.stamp();
	return t.getTurtleFriends().indexOf(t);
    }

    @Override
    int getNumberOfParameters() {
	return 0;
    }
//	private final static int numParams = 0;
//	double one =1;
//	double zero =0;
//	
//	@Override
//	double execute(List<CommandNode> children, Turtle t) {
//		if(t.getActive()) {
//			t.addTurtle();
//			
//			return 1;
//		}
//		
//		else { return 0;}
//		
//		
//	}
}
