package commands;

import java.util.List;

public class fd extends Command{
	@Override
	public double execute(List<CommandNode> children) {
		CommandNode child = children.get(0);
		return this.getTurtle().move(child.execute());
	}
	
	@Override
	public int getNumberOfParameters() {
		return 1;
	}

}
