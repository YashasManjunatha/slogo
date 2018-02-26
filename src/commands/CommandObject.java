package commands;

import java.util.List;

public interface CommandObject {
	double execute(List<CommandNode> children);
	int getNumberOfParameters();
}
