package GUIBoxes;

import java.util.List;

import Turtle.Turtle;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * 
 * Abstract class that sets up the various buttons created for the GUI.
 * 
 * @author Calvin Ma
 *
 */

public abstract class Buttons extends Button{

	private Pane thisPane;
	//private Button thisButton;
	private List<Turtle> thisTurtleList;

	/**
	 * Constructor for the button superclass
	 * 
	 * @param pane
	 *            - this pane is what each gui object will be added to, so the
	 *            button needs access in order to get added
	 * @param properties
	 *            - properties read in from the Gui object that holds all objects
	 * @param text
	 *            - the label for the button - what will be show on the button on
	 *            the front end
	 * @param turtleList
	 *            - a list of turtles. This is important because different buttons
	 *            have an effect on all of the turtles
	 */
	public Buttons(Pane pane, double[] properties, String text, List<Turtle> turtleList) {
//		setButton(new Button(text));
		this.setText(text);
		thisPane = pane;
		setThisTurtleList(turtleList);
		setupProperties(properties[0], properties[1], properties[2], properties[3]);
		setupAction();
		thisPane.getChildren().add(this);
	}

	/**
	 * abstract method used for determining what a button does upon press.
	 * Abstracted because each button has its own purpose
	 */
	abstract void setupAction();

	/**
	 * sets up the button based on the parameters
	 * 
	 * @param xPos
	 *            - x position of the button
	 * @param yPos
	 *            - y position of the button
	 * @param width
	 *            - width of button
	 * @param height
	 *            - height of button
	 */
	private void setupProperties(double xPos, double yPos, double width, double height) {
		getButton().setLayoutX(xPos);
		getButton().setLayoutY(yPos);
		getButton().setMinWidth(width);
		getButton().setMinHeight(height);
	}

	/**
	 * protected method so that the subclasses can get the button initialized in the
	 * super class
	 * 
	 * @return
	 */
	protected Button getButton() {
		return this;
	}

	/**
	 * protected method so that the subclasses can alter the button in this
	 * superclass
	 * 
	 * @param runButton
	 *            - returns an altered button to corresponding class
	 */
//	protected void setButton(Button runButton) {
//		this = runButton;
//	}

	/**
	 * protected method for the subclasses to get the list in this superclass
	 * 
	 * @return - returns the list in the superclass
	 */
	protected List<Turtle> getThisTurtleList() {
		return thisTurtleList;
	}

	/**
	 * protected method that allows for the subclasses to alter the turtlelist if
	 * necessary
	 * 
	 * @param turtleList
	 *            - the list of the turtles
	 */
	protected void setThisTurtleList(List<Turtle> turtleList) {
		thisTurtleList = turtleList;
	}
}