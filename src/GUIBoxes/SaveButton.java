package GUIBoxes;

import java.util.List;
import java.util.Map;

import Turtle.Turtle;
import commands.Command;
import commands.SaveCurrentStates;
import javafx.scene.layout.Pane;

public class SaveButton extends Buttons {

	private Map<String, Double> mainVariableMap;

	private Map<String, Command> mainCommandMap;

	public SaveButton(Pane pane, double[] properties, String text, List<Turtle> turtleList,
			Map<String, Double> variableMap, Map<String, Command> commandMap) {
		super(pane, properties, text, turtleList);
		mainVariableMap = variableMap;
		mainCommandMap = commandMap;
	}

	@Override
	void setupAction() {
		getButton().setOnAction(event -> {
			SaveCurrentStates states = new SaveCurrentStates(mainVariableMap, mainCommandMap);
			states.exportFile();
		});

	}

}
