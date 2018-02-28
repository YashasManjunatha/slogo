package commands;

import java.util.List;

import Turtle.Turtle;

public class Repeat extends Command{
	@Override
	public double execute(List<CommandNode> children, Turtle t) {
		double repeat = children.get(0).getCommand().execute(children, t);
		for (int x=0; x<repeat; x++) {
			for (int i=1; i<children.size(); x++) {
				
			}
		}
		
		return 0;
	}

}
