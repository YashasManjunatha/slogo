package GUIBoxes;

import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

/**
 * box where the user is able to type out commands
 * 
 * @author Calvin Ma
 *
 */
public class TextInputBox {

	private TextArea textInput;
	private Pane thisPane;

	/**
	 * Constructor for textinputbox
	 * 
	 * @param pane
	 *            - needs pane because the TextArea is being added to the pane
	 * @param properties
	 *            - properties of the textarea
	 */
	public TextInputBox(Pane pane, double[] properties) {
		textInput = new TextArea();
		thisPane = pane;
		setupProperties(properties[0], properties[1], properties[2], properties[3]);
		thisPane.getChildren().add(textInput);
	}

	/**
	 * Sets up properties of the textarea
	 * 
	 * @param xPos
	 *            - x position of the text area
	 * @param yPos
	 *            - y position of the text area
	 * @param width
	 *            - widht of text area
	 * @param height
	 *            - height of text area
	 */
	private void setupProperties(double xPos, double yPos, double width, double height) {
		textInput.setLayoutX(xPos);
		textInput.setLayoutY(yPos);
		textInput.setMinWidth(width);
		textInput.setMaxWidth(width);
		textInput.setMinHeight(height);
		textInput.setMaxHeight(height);

	}

	/**
	 * gets the current text within the textinputbox
	 * 
	 * @return - text in inputbox
	 */
	public String getText() {
		return textInput.getText();
	}

	/**
	 * clears the text within the text area
	 */
	public void clear() {
		textInput.clear();
	}

	/**
	 * gets the text area
	 * 
	 * @return - the text area
	 */
	public Node getTextArea() {
		return textInput;
	}

	/**
	 * sets the text input to have a specific text
	 * @param currentItemSelected - text you want the input area to have
	 */
	public void setText(String currentItemSelected) {
		textInput.setText(currentItemSelected);
	}

}
