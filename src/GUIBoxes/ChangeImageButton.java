package GUIBoxes;

import java.util.List;

import Turtle.Turtle;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Button that allows the user to change the image of the active turtles
 * 
 * @author Calvin Ma
 *
 */
public class ChangeImageButton extends Buttons {

	private Stage mainStage;
	private ScreenBox mainTurtleScreen;
	private final static String FILECHOOSERLABEL = "Choose Turtle Image";
	private TurtleImageViewer imageViewer;

	/**
	 * Constructor for this change image button
	 * 
	 * @param pane
	 *            - needs the pane to fulfill superclass constructor
	 * @param properties
	 *            - properties to fulfill superclass constructor
	 * @param text
	 *            - button name to fulfill superclass constructor
	 * @param stage
	 *            - needs the stage in order to show a dialog box to choose image
	 *            from
	 * @param turtleList
	 *            - needs turtleList
	 * @param imageViewer 
	 */
	public ChangeImageButton(Pane pane, double[] properties, String text, Stage stage, List<Turtle> turtleList, TurtleImageViewer imageViewer) {
		super(pane, properties, text, turtleList);
		mainStage = stage;
		this.imageViewer = imageViewer;
	}

	/**
	 * setups the action for the button - on press, the button opens a dialog box
	 * where the user can choose an image from the local machine. Then, all the
	 * active turtles have their image changed to the selected image. If an
	 * exception is caught, error box is created.
	 */
	@Override
	void setupAction() {
		getButton().setOnAction(event -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle(FILECHOOSERLABEL);
			try {
				String fileName = fileChooser.showOpenDialog(mainStage).getPath();

				for (Turtle t : getThisTurtleList()) {
					if (t.isActive()) {
						t.changeImage(fileName);
						imageViewer.refreshView();
					}
				}

			} catch (Exception e) {
				new ErrorBox("Invalid Image", "Please Select Valid Image");
			}

		});

	}

}
