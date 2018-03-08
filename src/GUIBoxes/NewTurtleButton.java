
package GUIBoxes;

import java.util.ArrayList;
import java.util.List;

import Turtle.Turtle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class NewTurtleButton extends Buttons {

	private Stage mainStage;
	private ScreenBox mainTurtleScreen;
	private List<Turtle> mainTurtleList;

	public NewTurtleButton(Pane pane, double[] properties, String text, ScreenBox turtleScreen, Stage stage,
			List<Turtle> turtleList) {
		super(pane, properties, text, turtleList);
		mainStage = stage;
		mainTurtleScreen = turtleScreen;
		mainTurtleList = turtleList;
	}

	@Override
	void setupAction() {
		getButton().setOnAction((event) -> {
			Turtle turtle = new Turtle(mainTurtleScreen, new Image(
					getClass().getClassLoader().getResourceAsStream("images/turtle.png"), 0, 55, true, false));

			mainTurtleList.add(turtle);

		});
	}

}
