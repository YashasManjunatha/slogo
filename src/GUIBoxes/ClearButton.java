package GUIBoxes;

import java.util.ArrayList;

import Turtle.Turtle;
import commands.Command;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;

public class ClearButton extends Buttons {

	private static TextInputBox mainTextInput;
	private static PrevCommandList mainPrevCommandBox;

	public ClearButton(Group root, double[] properties, String text, TextInputBox textInput,
			PrevCommandList prevCommandBox, ArrayList<Turtle> turtleList) {
		super(root, properties, text, turtleList);
		this.mainTextInput = textInput;
		this.mainPrevCommandBox = prevCommandBox;

	}

	@Override
	void setupAction() {

		getButton().setOnAction((event) -> {
			mainTextInput.clear();

		});

	}
}
