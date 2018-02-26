package GUIBoxes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class TextInputBox implements GUIBoxes {

	private TextArea textInput;
	private static Group thisRoot;

	public TextInputBox(Group root, double[] properties) {
		textInput = new TextArea();
		setupProperties(properties[0], properties[1], properties[2], properties[3]);
		root.getChildren().add(textInput);
	}

	private void setupProperties(double xPos, double yPos, double width, double height) {
		textInput.setLayoutX(xPos);
		textInput.setLayoutY(yPos);
		textInput.setMinWidth(width);
		textInput.setMaxWidth(width);
		textInput.setMinHeight(height);
		textInput.setMaxHeight(height);

	}

	public String getText() {
		return textInput.getText();
	}

	public void clear() {
		textInput.clear();
	}

	@Override
	public void updateBox() {
		thisRoot.getChildren().remove(textInput);
		thisRoot.getChildren().add(textInput);
	}

	public Node getTextArea() {
		return textInput;
	}

}
