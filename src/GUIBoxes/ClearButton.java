package GUIBoxes;

import java.util.List;

import Turtle.Turtle;
import javafx.scene.layout.Pane;

public class ClearButton extends Buttons {

	private TextInputBox mainTextInput;
	private PrevCommandList mainPrevCommandBox;

	public ClearButton(Pane pane, double[] properties, String text, TextInputBox textInput,
			PrevCommandList prevCommandBox, List<Turtle> turtleList) {
		super(pane, properties, text, turtleList);
		this.mainTextInput = textInput;
		this.mainPrevCommandBox = prevCommandBox;

	}

	@Override
	void setupAction() {

		getButton().setOnAction(event -> {
			mainTextInput.clear();

		});

	}
}
