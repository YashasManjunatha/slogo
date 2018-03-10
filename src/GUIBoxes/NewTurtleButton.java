package GUIBoxes;

import java.util.List;

import Turtle.Turtle;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class NewTurtleButton extends Buttons {

	private Stage mainStage;
	private ScreenBox mainTurtleScreen;
	private List<Turtle> mainTurtleList;
	private TurtleViewTable mainTurtleTable;
	private final static String DEFAULTIMAGE = "images/turtle.png";

	public NewTurtleButton(Pane pane, double[] properties, String text, ScreenBox turtleScreen, Stage stage,
			List<Turtle> turtleList, TurtleViewTable turtleTable) {
		super(pane, properties, text, turtleList);
		mainStage = stage;
		mainTurtleScreen = turtleScreen;
		mainTurtleList = turtleList;
		mainTurtleTable = turtleTable;
	}

	@Override
	void setupAction() {
		getButton().setOnAction(event -> {
			Turtle turtle = new Turtle(mainTurtleScreen, new Image(
					getClass().getClassLoader().getResourceAsStream(DEFAULTIMAGE), 0, 55, true, false));

			mainTurtleList.add(turtle);
			mainTurtleTable.addTurtle();

		});
	}

}
