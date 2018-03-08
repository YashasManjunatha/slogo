package GUIBoxes;

import java.util.ArrayList;

import Turtle.Turtle;
import commands.Command;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Tab;
import javafx.scene.layout.Pane;

public class ClearButton extends Buttons {

	private TextInputBox mainTextInput;
	private PrevCommandList mainPrevCommandBox;

	public ClearButton(Pane pane, double[] properties, String text, TextInputBox textInput,
			PrevCommandList prevCommandBox, ArrayList<Turtle> turtleList) {
		super(pane, properties, text, turtleList);
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
