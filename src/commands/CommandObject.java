package commands;

import java.util.List;

import Turtle.Turtle;

public abstract class CommandObject {
	abstract double execute(List<CommandNode> children, Turtle t);
	abstract int getNumberOfParameters();
	abstract void setValue(double x);
}
