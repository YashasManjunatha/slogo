package GUIBoxes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;

public abstract class Buttons {
	
	private Group thisRoot;
	private String buttonText;
	private Button thisButton;
	
	public Buttons(Group root, double[] properties, String text) {
		setButton(new Button(text));
		thisRoot = root;
		setupProperties(properties[0], properties[1], properties[2], properties[3]);
		setupAction();
		root.getChildren().add(getButton());

	}
	


	abstract void setupAction();

	private void setupProperties(double xPos, double yPos, double width, double height) {
		getButton().setLayoutX(xPos);
		getButton().setLayoutY(yPos);
		getButton().setMinWidth(width);		
		getButton().setMinHeight(height);
	}



	protected Button getButton() {
		return thisButton;
	}



	protected void setButton(Button runButton) {
		this.thisButton = runButton;
	}
}