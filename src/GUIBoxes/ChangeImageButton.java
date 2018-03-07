package GUIBoxes;

import java.util.ArrayList;

import Turtle.Turtle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Tab;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ChangeImageButton extends Buttons {

	private static Stage mainStage;
	private static ScreenBox mainTurtleScreen;
	private static ArrayList<Turtle> mainTurtleList;

	public ChangeImageButton(Pane pane, double[] properties, String text, ScreenBox turtleScreen, Stage stage,
			ArrayList<Turtle> turtleList) {
		super(pane, properties, text, turtleList);
		mainStage = stage;
		mainTurtleScreen = turtleScreen;
		mainTurtleList = turtleList;
	}

	@Override
	void setupAction() {
		getButton().setOnAction((event) -> {
				System.out.println("fasdfas");
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Choose Turtle Image");
				try {
				String fileName = fileChooser.showOpenDialog(mainStage).getPath();
				mainTurtleScreen.replaceImage(fileName);
				}catch (NullPointerException n) {
					//do nothing
				}

			

		});

}

}
