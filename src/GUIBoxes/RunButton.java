package GUIBoxes;

import java.util.List;
import java.util.Map;

import Turtle.Turtle;
import commands.Command;
import javafx.scene.layout.Pane;

public class RunButton extends Buttons {

	private TextInputBox mainTextInput;
	private PrevCommandList mainPrevCommandBox;
	private GUIComboBox mainLanguageComboBox;
	private String language = "English";
	private UserDefTable mainVarTable;
	private UserDefTable mainFuncTable;
	private TurtleViewTable mainTurtleTable;

	private Map<String, Double> variableMap;
	private Map<String, Command> userCommandMap;

	public RunButton(Pane pane, GUIComboBox languageComboBox, double[] properties, String text, TextInputBox textInput,
			PrevCommandList prevCommandBox, List<Turtle> turtleList, Map<String, Double> variables,
			Map<String, Command> commands, UserDefTable varTable, UserDefTable funcTable, TurtleViewTable turtleTable) {
		super(pane, properties, text, turtleList);
		mainLanguageComboBox = languageComboBox;
		this.mainTextInput = textInput;
		this.mainPrevCommandBox = prevCommandBox;
		variableMap = variables;
		userCommandMap = commands;
		mainVarTable = varTable;
		mainFuncTable = funcTable;
		mainTurtleTable = turtleTable;
	}

	@Override
	void setupAction() {

		getButton().setOnAction(event -> {
			System.out.println("before = " + variableMap);
			mainPrevCommandBox.addText(mainTextInput.getText());
			for (Turtle t : getThisTurtleList()) {
				
				language = ((LanguageCombo) mainLanguageComboBox).getLanguage();
				Command test = new Command(mainTextInput.getText(), t, variableMap, userCommandMap, language);
				test.execute();

			}
			
			mainVarTable.updateVars(variableMap);
			mainFuncTable.updateFuncs(userCommandMap);
			mainTurtleTable.updateTurtles(getThisTurtleList());

			mainTextInput.clear();

		});
	}

}
