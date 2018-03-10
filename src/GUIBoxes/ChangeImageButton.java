package GUIBoxes;

import java.util.List;

import Turtle.Turtle;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ChangeImageButton extends Buttons {

	private Stage mainStage;
	private ScreenBox mainTurtleScreen;
	private List<Turtle> mainTurtleList;
	private final static String FILECHOOSERLABEL = "Choose Turtle Image";

	public ChangeImageButton(Pane pane, double[] properties, String text, ScreenBox turtleScreen, Stage stage,
			List<Turtle> turtleList) {
		super(pane, properties, text, turtleList);
		mainStage = stage;
		mainTurtleScreen = turtleScreen;
		mainTurtleList = turtleList;
	}

	@Override
	void setupAction() {
		getButton().setOnAction(event -> {
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle(FILECHOOSERLABEL);
				try {
				String fileName = fileChooser.showOpenDialog(mainStage).getPath();
				
				for (Turtle t : mainTurtleList) {
					if (t.isActive()) {
					t.changeImage(fileName);
					}
				}
				
				}catch (NullPointerException n) {
					//do nothing, error is "sent" to turtle to deal with
				}

			

		});

}

}
