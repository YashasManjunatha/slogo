package GUIBoxes;

import java.util.List;
import java.util.Map;

import Turtle.Turtle;
import commands.Command;
import commands.SaveCurrentStates;
import javafx.scene.layout.Pane;

/**
 * subclass of button - saves the current user defined variables and commands
 * into text file
 * 
 * @author Calvin Ma
 *
 */
public class SaveButton extends Buttons {

	private Map<String, Double> mainVariableMap;

	private Map<String, Command> mainCommandMap;

	/**
	 * Constructor for save button
	 * 
	 * @param pane
	 * @param properties
	 * @param text
	 * @param turtleList
	 * @param variableMap
	 *            - needed for savecurrentstate class
	 * @param commandMap
	 *            - needed for savecurrentstate class
	 */
	public SaveButton(Pane pane, double[] properties, String text, List<Turtle> turtleList,
			Map<String, Double> variableMap, Map<String, Command> commandMap) {
		super(pane, properties, text, turtleList);
		mainVariableMap = variableMap;
		mainCommandMap = commandMap;
	}

	/**
	 * sets up press action - on button press, the variable map and command map are
	 * taken and exported into a text file
	 */
	@Override
	void setupAction() {
		getButton().setOnAction(event -> {
			SaveCurrentStates states = new SaveCurrentStates(mainVariableMap, mainCommandMap);
			states.exportFile();
		});

	}

}
