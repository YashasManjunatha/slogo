package commands;

import java.util.List;

import Turtle.Turtle;
/**
 * Abstract class implemented by all Commands
 * 
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
