package commands;

import java.util.List;

import Turtle.Turtle;
/**
 * Abstract class implemented by all Commands
 * This is a super class of the Command and all commands written in this package
 * It was suppose to be an interface initially, but was changed to abstract class
 * because we wanted it's methods to be package friendly, not public
 */
public abstract class CommandObject {
	/**
	 * Executes on each child node and returns the value of the last execution
	 * @param children
	 * @param t
	 * @return
	 */
	abstract double execute(List<CommandNode> children, Turtle t);
	/**
	 * Return the number of parameters (child nodes for the command)
	 * @return
	 */
	abstract int getNumberOfParameters();
}
