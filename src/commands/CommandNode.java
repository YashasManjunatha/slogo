package commands;

import java.util.ArrayList;
import java.util.List;

import Turtle.Turtle;

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
	double execute(Turtle t) {
		return this.getCommand().execute(this.getChildren(), t);
	}
	void printTree() {
		System.out.println(this.getCommand());
		for (int x=0; x<this.getChildren().size(); x++) {
			System.out.println(this.getChildren().get(x).getCommand());
			for (int y=0; y<this.getChildren().get(x).getChildren().size(); y++) {
				System.out.println(this.getChildren().get(x).getChildren().get(y).getCommand());
				for (int j=0; j<this.getChildren().get(x).getChildren().get(y).getChildren().size(); j++) {
					System.out.println(this.getChildren().get(x).getChildren().get(y).getChildren().get(j).getCommand());
				}
				
			}
		}
//		System.out.println(this.getCommand());
//		System.out.println(this.getChildren().get(0).getCommand());
//		System.out.println(this.getChildren().get(0).getChildren().get(0).getCommand());
//		System.out.println(this.getChildren().get(0).getChildren().get(0).getChildren().get(0).getCommand());
	}
}