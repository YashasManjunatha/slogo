package commands;

import java.util.List;

import Turtle.Turtle;
/**
 * This is a super class of the Command and all commands written in this package
 *It was suppose to be an interface initially, but was changed to abstract class
 *because we wanted it's methods to be package friendly, not public
 */
public abstract class CommandObject {
	abstract double execute(List<CommandNode> children, Turtle t);
	abstract int getNumberOfParameters();
	abstract void setValue(double x);
}
