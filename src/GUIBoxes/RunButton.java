package GUIBoxes;

import java.util.ArrayList;

import Turtle.Turtle;
import commands.Command;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;

public class RunButton extends Buttons {

	private static TextInputBox mainTextInput;
	private static PrevCommandList mainPrevCommandBox;

	public RunButton(Group root, double[] properties, String text, TextInputBox textInput,
			PrevCommandList prevCommandBox, ArrayList<Turtle> turtleList) {
		super(root, properties, text, turtleList);
		this.mainTextInput = textInput;
		this.mainPrevCommandBox = prevCommandBox;

	}

	@Override
	void setupAction() {
		getButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				mainPrevCommandBox.addText(mainTextInput.getText());
				for (Turtle t : getThisTurtleList()) {
					System.out.println(mainTextInput.getText());
					Command test = new Command(mainTextInput.getText(), t);
					test.execute();
				}
				mainTextInput.clear();
				// new comamndobject(faosdijfasoidfjioasjoi, turtle )
				// updateGUI();
			}
		});

	}

}
