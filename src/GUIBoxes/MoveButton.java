package GUIBoxes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Turtle.Turtle;
import commands.Command;
import javafx.scene.layout.Pane;

public class MoveButton extends Buttons {

	private GUIComboBox mainLanguageComboBox;
	private TurtleViewTable mainTurtleTable;
	private String moveCommand;

	public MoveButton(Pane pane, double[] properties, String text, List<Turtle> turtleList,
			GUIComboBox languageComboBox, TurtleViewTable turtleTable, String command) {
		super(pane, properties, text, turtleList);
		mainLanguageComboBox = languageComboBox;
		mainTurtleTable = turtleTable;
		moveCommand = command;
	}

	@Override
	void setupAction() {
		getButton().setOnAction(event -> {
			for (Turtle t : getThisTurtleList()) {
				if (t.isActive()) {
					Map<String, Double> varMap = new HashMap<>();
					Map<String, Command> commMap = new HashMap<>();
					Command test = new Command(moveCommand, t, varMap, commMap, ((LanguageCombo) mainLanguageComboBox).getLanguage());
					test.execute();
				}
			}
			mainTurtleTable.updateValues();
		});
		



	}

}
