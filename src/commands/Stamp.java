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
}
