package commands;

import java.util.ArrayList;
import java.util.List;

import Turtle.Turtle;
/**
 * The CommandNode object is what makes up the expression tree
 * Each holds the a CommandObject and a List<CommandNode> that are its children (the command's parameters)
 * @author milestodzo
 *
*/
public class CommandNode {
	private List<CommandNode> myChildren;
	private CommandObject myCommand;
	
	CommandNode (CommandObject command){
		myCommand = command;
		myChildren = new ArrayList<>();
	}
	/**
	 * @return myChildren
	 */
	List<CommandNode> getChildren(){
		return myChildren;
	}
	/**
	 * @param child
	 */
	void addChild(CommandNode child) {
		myChildren.add(child);
	}
	/**
	 * @return myCommand
	 */
	CommandObject getCommand() {
		return myCommand;
	}
	/**
	 * @return Command's number of parameters
	 */
	int getNumberOfParameters() {
		return this.getCommand().getNumberOfParameters();
	}
	/**
	 * Calls execute on the node's command
	 * Calling the node's execute from the Command class rather than the CommandObject's enabled us to pass the turtle more easily
	 * @param t
	 * @return value returned by executing
	 */
	double execute(Turtle t) {
		return this.getCommand().execute(this.getChildren(), t);
	}
}