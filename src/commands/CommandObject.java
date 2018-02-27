package commands;

import java.util.List;

import Turtle.Turtle;

public interface CommandObject {
	double execute(List<CommandNode> children, Turtle t);
	int getNumberOfParameters();
}
