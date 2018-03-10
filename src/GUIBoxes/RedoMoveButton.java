
package GUIBoxes;

import java.util.List;

import Turtle.Turtle;
import commands.Turtles;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * subclass of Buttons - allows user to redo previous moves
 * 
 * @author Calvin Ma
 *
 */
public class RedoMoveButton extends Buttons {

	private Stage mainStage;
	private ScreenBox mainTurtleScreen;

	/**
	 * 
	 * @param pane
	 * @param properties
	 * @param text
	 * @param turtleList
	 */
	public RedoMoveButton(Pane pane, double[] properties, String text, List<Turtle> turtleList) {
		super(pane, properties, text, turtleList);
	}

	/**
	 * sets action event of button - whenever button is pressed, the last move is
	 * "undone"
	 */
	@Override
	void setupAction() {
		getButton().setOnAction((event) -> {
			for (Turtle t : getThisTurtleList()) {
				if (t.isActive()) {
					t.undoMove();
				}
			}

		});
	}

}
