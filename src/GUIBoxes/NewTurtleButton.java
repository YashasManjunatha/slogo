package GUIBoxes;

import java.util.List;

import Turtle.Turtle;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Subclass of button for adding a new turtle
 * 
 * @author Calvin Ma
 *
 */
public class NewTurtleButton extends Buttons {

	private Stage mainStage;
	private ScreenBox mainTurtleScreen;
	private TurtleViewTable mainTurtleTable;
	private final static String DEFAULTIMAGE = "images/turtle.png";
	private int idIterator = 2;

	/**
	 * Constructor for new turtle button - check button superclass for unspecificed
	 * parameters
	 * 
	 * @param pane
	 * @param properties
	 * @param text
	 * @param turtleScreen
	 *            - because this button creates a new turtle, it needs the screen to
	 *            add a turtle to it
	 * @param turtleTable
	 *            - when new turtle is created, a new row needs to be added to the
	 *            turtleTable
	 */
	public NewTurtleButton(Pane pane, double[] properties, String text, ScreenBox turtleScreen, List<Turtle> turtleList,
			TurtleViewTable turtleTable) {
		super(pane, properties, text, turtleList);
		mainTurtleScreen = turtleScreen;
		mainTurtleTable = turtleTable;
	}

	/**
	 * sets action for button - when button pressed, a new turtle is created and
	 * added to the screen. Then the turtle is added to turtleList and its
	 * properties are added to the turtleTable
	 */
	@Override
	void setupAction() {
		getButton().setOnAction(event -> {
			Turtle turtle = new Turtle(mainTurtleScreen,
					new Image(getClass().getClassLoader().getResourceAsStream(DEFAULTIMAGE), 0, 55, true, false));
			turtle.setID(idIterator);
			idIterator += 1;
			getThisTurtleList().add(turtle);
			mainTurtleTable.addTurtle(turtle);

		});
	}

}
