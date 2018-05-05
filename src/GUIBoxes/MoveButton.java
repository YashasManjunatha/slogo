package GUIBoxes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Turtle.Turtle;
import commands.Command;
import javafx.scene.layout.Pane;

/**
 * subclass of buttons - this button will be used to move the turtle around
 * 
 * @author Calvin Ma
 *
 */
public class MoveButton extends Buttons {

	private GUIComboBox mainLanguageComboBox;
	private TurtleViewTable mainTurtleTable;
	private String moveCommand;
	private final Map<String, Double> varMap = new HashMap<>();
	private final Map<String, Command> commMap = new HashMap<>();

	/**
	 * Constructor for the move button - for parameters needed for super, check
	 * button superclass
	 * 
	 * @param pane
	 * @param properties
	 * @param text
	 * @param turtleList
	 * @param languageComboBox
	 *            - because this class will call a new Command object, then it also
	 *            needs to pass it a language, which is obtained from the language
	 *            box
	 * @param turtleTable
	 *            - whenever move is pressed, the turtleTable needs to update
	 * @param command
	 *            - command that is done from the press of the button
	 */
	public MoveButton(Pane pane, double[] properties, String text, List<Turtle> turtleList,
			GUIComboBox languageComboBox, TurtleViewTable turtleTable, String command) {
		super(pane, properties, text, turtleList);
		mainLanguageComboBox = languageComboBox;
		mainTurtleTable = turtleTable;
		moveCommand = command;
	}

	/**
	 * determines the press event of the button - a press of the button will result
	 * in the turtle doing a command. command is determined in the Gui class
	 */
	@Override
	public void setupAction() {
		getButton().setOnAction(event -> {
			for (Turtle t : getThisTurtleList()) {
				if (t.isActive()) {
					Command test = new Command(moveCommand, t, varMap, commMap,
							((LanguageCombo) mainLanguageComboBox).getLanguage());
					test.execute();
				}
			}
			mainTurtleTable.updateValues();
		});

	}

}
