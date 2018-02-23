package GUIBoxes;


import javafx.scene.Group;
import javafx.scene.control.TextArea;

public class TextInputBox implements GUIBoxes{
	
	private TextArea textInput;
	private static Group thisRoot;

	
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

	@Override
	public void updateBox() {
		thisRoot.getChildren().remove(textInput);
		thisRoot.getChildren().add(textInput);
	}

}
