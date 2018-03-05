package GUIBoxes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Turtle.Turtle;
import commands.Command;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;

public class RunButton extends Buttons {

	private static TextInputBox mainTextInput;
	private static PrevCommandList mainPrevCommandBox;
	private static LanguageCombo mainLanguageComboBox;
	private static String language = "English";
	
	private Map<String, Double> variableMap;

	public RunButton(Group root, GUIComboBox languageComboBox, double[] properties, String text, TextInputBox textInput,
			PrevCommandList prevCommandBox, ArrayList<Turtle> turtleList, Map<String, Double> variables) {
		super(root, properties, text, turtleList);
		mainLanguageComboBox = (LanguageCombo) languageComboBox;
		this.mainTextInput = textInput;
		this.mainPrevCommandBox = prevCommandBox;
		variableMap = variables;
	}
	

	@Override
	void setupAction() {
		
		getButton().setOnAction((event) -> {
			mainPrevCommandBox.addText(mainTextInput.getText());
			for (Turtle t : getThisTurtleList()) {
				System.out.println(mainTextInput.getText());
				if (!language.equals("English")) {
					language = mainLanguageComboBox.getLanguage();
					System.out.println("here "+ language + mainLanguageComboBox.getLanguage());
				}
				System.out.println("crap");
				System.out.println("test  " + mainLanguageComboBox.getLanguage());
				Command test = new Command(mainTextInput.getText(), t, variableMap, language);
				test.execute();
			}
			mainTextInput.clear();

		});
	}

}
