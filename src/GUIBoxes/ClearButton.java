package GUIBoxes;

import java.util.List;

import Turtle.Turtle;
import javafx.scene.layout.Pane;

/**
 * Button used to clear the input text box
 * 
 * @author Calvin Ma
 *
 */
public class ClearButton extends Buttons {

	private TextInputBox mainTextInput;
	private PrevCommandList mainPrevCommandBox;

	/**
	 * Constructor for button - for unlabled parameters, check superclass
	 * 
	 * @param pane
	 * @param properties
	 * @param text
	 * @param textInput
	 *            - needs this because this is where the texted will be cleared from
	 * @param prevCommandBox
	 *            - needs this so the button knows that upon press, text is being
	 *            added to the previous command box
	 * @param turtleList
	 */

	public ClearButton(Pane pane, double[] properties, String text, TextInputBox textInput,
			PrevCommandList prevCommandBox, List<Turtle> turtleList) {
		super(pane, properties, text, turtleList);
		this.mainTextInput = textInput;
		this.mainPrevCommandBox = prevCommandBox;

	}

	/**
	 * sets up action for button - when button is pressed, the text input area's
	 * text is cleared
	 */
	@Override
	void setupAction() {

		getButton().setOnAction(event -> {
			mainTextInput.clear();

		});

	}
}
