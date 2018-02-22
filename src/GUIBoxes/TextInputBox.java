package GUIBoxes;


import javafx.scene.Group;
import javafx.scene.control.TextArea;

public class TextInputBox {
	
	private static TextArea textInput;
	
	public TextInputBox(Group root, double xPos, double yPos, double height, double width) {
		textInput = new TextArea();
		setupProperties(xPos, yPos, height, width);
		root.getChildren().add(textInput);
	}

	private void setupProperties(double xPos, double yPos, double height, double width) {
		textInput.setLayoutX(xPos);
		textInput.setLayoutY(yPos);
		textInput.setMinWidth(width);

		textInput.setMaxWidth(width);
		textInput.setMaxHeight(height);
		
	}
	
	public String getText() {
		return textInput.getText();
	}
	
	public void clear() {
		textInput.clear();
	}

}
