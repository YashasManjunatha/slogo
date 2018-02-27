package commands;

import java.util.List;

import Turtle.Turtle;

public class fd extends Command{
	@Override
	public double execute(List<CommandNode> children, Turtle t) {
		CommandNode child = children.get(0);
		System.out.println();
		System.out.println(child.execute(t));
		return t.move(child.execute(t));
		 
	}
	
	@Override
	public int getNumberOfParameters() {
		return 1;
	}

}
