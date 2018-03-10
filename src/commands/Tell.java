package commands;

import java.util.ArrayList;
import java.util.List;
import Turtle.Turtle;

/**
 * Implements functionality for Tell Command
 *
 */
public class Tell extends Command{

	private final static int numParams = 1;


	@Override
	double execute(List<CommandNode> children, Turtle t) {
		System.out.println("Do you see me?");
		double retVal = 0;
		CommandNode bracketNode1 = children.get(0);
		List<CommandNode> bracket1children = bracketNode1.getChildren();

		List<Integer> IDs= new ArrayList<>();
		
		for(int i=0; i<bracket1children.size();i++) {
			IDs.add((int) bracket1children.get(i).execute(t));
		}
		int id =t.getID();
		System.out.println(id);
		if(id==2) {
			System.out.println("I am in tell command right here yup");
		}
		if(IDs.contains(id) && !t.isActive()) { 
			t.setActive();
		}
		if(!IDs.contains(id) && t.isActive() ) {
			t.setInactive();
			System.out.println("I am in tell command ");
		}
		if(id==t.getTurtleFriends().size()) {
			for(double ids : IDs) {
				if(ids>id) {
					double x = ids -id; 
					t.addFriends(x);
					id=(int)ids;
				}	
			}
		}
		//check if the turtle is active and if its id is present, 
		//if not active but id here, set active, otherwise inactive

		//also need the list of all existing ids, if the id does not exist, 
		//make new turtle
		return retVal;
	}

	@Override
	int getNumberOfParameters() {
		return numParams;
	}
}
