package commands;

import java.util.List;

import Turtle.Turtle;
import javafx.scene.paint.Color;
/**
 * Implements functionality for PenColor Command
 *
 */
public class GetPenColor extends Command{
	private final int numberOfParameters = 0;

	@Override
	double execute(List<CommandNode> children, Turtle t){
		List<Color> colors =t.getPenColors();
		double index = colors.size();
		return index;	
	}

	@Override
	int getNumberOfParameters() {
		return numberOfParameters;
	}

}
