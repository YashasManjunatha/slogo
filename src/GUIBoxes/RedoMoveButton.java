
package GUIBoxes;

import java.util.ArrayList;

import Turtle.Turtle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class RedoMoveButton extends Buttons {

	private Stage mainStage;
	private ScreenBox mainTurtleScreen;
	private ArrayList<Turtle> mainTurtleList;

	public RedoMoveButton(Pane pane, double[] properties, String text, ScreenBox turtleScreen, Stage stage,
			ArrayList<Turtle> turtleList) {
		super(pane, properties, text, turtleList);
		mainStage = stage;
		mainTurtleScreen = turtleScreen;
		mainTurtleList = turtleList;
	}

	@Override
	void setupAction() {
		getButton().setOnAction((event) -> {
			for (Turtle t : mainTurtleList) {
				t.redoMove();
			}

		});
	}

}
