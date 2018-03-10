
package GUIBoxes;

import java.util.List;

import Turtle.Turtle;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RedoMoveButton extends Buttons {

	private Stage mainStage;
	private ScreenBox mainTurtleScreen;
	private List<Turtle> mainTurtleList;

	public RedoMoveButton(Pane pane, double[] properties, String text, ScreenBox turtleScreen, Stage stage,
			List<Turtle> turtleList) {
		super(pane, properties, text, turtleList);
		mainStage = stage;
		mainTurtleScreen = turtleScreen;
		mainTurtleList = turtleList;
	}

	@Override
	void setupAction() {
		getButton().setOnAction((event) -> {
			for (Turtle t : mainTurtleList) {
				if (t.isActive()) {
					t.redoMove();
				}
			}

		});
	}

}
