package GUIBoxes;

import java.util.List;
import java.util.Map;

import Turtle.Turtle;
import commands.Command;
import javafx.scene.layout.Pane;

/**
 * subclass of button - pressing this button runs whatever is in the
 * textinputbox
 * 
 * @author Calvin Ma
 *
 */
public class RunButton extends Buttons {

	private TextInputBox mainTextInput;
	private PrevCommandList mainPrevCommandBox;
	private GUIComboBox mainLanguageComboBox;
	private String language = "English";
	private UserDefTable mainVarTable;
	private UserDefTable mainFuncTable;

	private Map<String, Double> variableMap;
	private Map<String, Command> userCommandMap;
	private TurtleViewTable mainTurtleTable;

	/**
	 * Constructor for run button - see button superclass for unspecified parameters
	 * 
	 * @param pane
	 * @param languageComboBox
	 *            - needs the language to send to parser
	 * @param properties
	 * @param text
	 * @param textInput
	 *            - textinputbox is where the text is taken from
	 * @param prevCommandBox
	 *            - run button will add text into the prevcommandbox
	 * @param turtleList
	 *            - runs the command for every active turtle, so it needs all of the
	 *            turtles
	 * @param variables
	 *            - parser/command object needs the variable list in case user uses
	 *            a user defined variable
	 * @param commands
	 *            - parser/command object needs command list in case user uses a
	 *            user defined command
	 * @param varTable
	 *            - if the user creates a variable, then run button will add it to
	 *            vartable
	 * @param funcTable
	 *            - if user creates a command, the run button adds to the functable
	 * @param turtleTable
	 *            - the turtle's position will need to be updated in the turtletable
	 */
	public RunButton(Pane pane, GUIComboBox languageComboBox, double[] properties, String text, TextInputBox textInput,
			PrevCommandList prevCommandBox, List<Turtle> turtleList, Map<String, Double> variables,
			Map<String, Command> commands, UserDefTable varTable, UserDefTable funcTable, TurtleViewTable turtleTable) {
		super(pane, properties, text, turtleList);
		mainLanguageComboBox = languageComboBox;
		this.mainTextInput = textInput;
		this.mainPrevCommandBox = prevCommandBox;
		variableMap = variables;
		userCommandMap = commands;
		mainVarTable = (VariableTable) varTable;
		mainFuncTable = (CommandTable) funcTable;
		mainTurtleTable = turtleTable;
	}

	/**
	 * sets action of button - when button pressed, the button creates new Command
	 * object with necessary parameters, then everything is updated on the front end
	 * with the Command
	 */
	@Override
	void setupAction() {

		getButton().setOnAction(event -> {
			mainPrevCommandBox.addText(mainTextInput.getText());
			for (Turtle t : getThisTurtleList()) {

				language = ((LanguageCombo) mainLanguageComboBox).getLanguage();
				Command test = new Command(mainTextInput.getText(), t, variableMap, userCommandMap, language);
				test.execute();

			}
			mainVarTable.updateVars(variableMap);
			mainFuncTable.updateCommandFuncs(userCommandMap);
			mainTurtleTable.updateValues();

			mainTextInput.clear();

		});
	}

}
