package commands;

import java.util.ArrayList;
import java.util.List;

public class CommandNode {
	private List<CommandNode> myChildren;
	private CommandObject myCommand;
	
	CommandNode (CommandObject command){
		myCommand = command;
		myChildren = new ArrayList<CommandNode>();
	}
	
	List<CommandNode> getChildren(){
		return myChildren;
	}
	
	void addChild(CommandNode child) {
		myChildren.add(child);
	}
	
	CommandObject getCommand() {
		return myCommand;
	}
	int getNumberOfParameters() {
		return this.getCommand().getNumberOfParameters();
	}
}