package GUIBoxes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;

public class RunButton extends Buttons {

	private static TextInputBox mainTextInput;
	private static PrevCommandList mainPrevCommandBox;

	public RunButton(Group root, double[] properties, String text, TextInputBox textInput,
			PrevCommandList prevCommandBox) {
		super(root, properties, text);
		this.mainTextInput = textInput;
		this.mainPrevCommandBox = prevCommandBox;

	}

	@Override
	void setupAction() {
		getButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println(mainTextInput.getText());
				mainPrevCommandBox.addText(mainTextInput.getText());
				mainTextInput.clear();
				// new comamndobject(faosdijfasoidfjioasjoi, turtle )
				// updateGUI();
			}
		});

	}

}
