package commands;


import java.util.List;



import Turtle.Turtle;
//import javafx.scene.paint.Color;


public class PenColor extends Command {

	private static int numParams = 2;

	
	@Override
	double execute(List<CommandNode> children, Turtle t) {
	//List<Color> colors=t.getPenColors();
	return 0;
	}

	@Override
	int getNumberOfParameters() {
		return numParams;
	}
}
