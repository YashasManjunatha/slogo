package GUIBoxes;

import java.util.List;
import java.util.Map;

import Turtle.Turtle;
import commands.Command;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class PrevCommandList extends ListView {

	private Pane thisPane;
	private ListView<String> list;
	private ObservableList<String> items = FXCollections.observableArrayList();
	private TextInputBox mainTextInput;
	private List<Turtle> mainTurtleList;
	private LanguageCombo mainLanguageComboBox;
	private TurtleViewTable mainTurtleTable;

	private Map<String, Double> variableMap;
	private Map<String, Command> commandMap;

	/**
	 * Constructor for PrevCommandList, which shows all previous commands ran by
	 * user
	 * 
	 * @param pane
	 *            - needs pane because the prevcommandlist will be added to the pane
	 * @param properties
	 *            - array of properties like the x position read in from Gui class
	 * @param textInput
	 *            - needs textInputBox because it's where values are read from
	 * @param turtleList
	 *            - the PrevCommandList has a properties where if a command is
	 *            double-clicked, the command is ran. So, it needs the turtlelist to
	 *            determine which turtles will move/be commanded
	 * @param variables
	 *            - needs variable list for the parser in case a previous command
	 *            uses a user defined variables
	 * @param commands
	 *            - in case a previous typed command uses a user defined command
	 * @param languageComboBox
	 *            - Command objects needs a language so the prevcommandlist takes in
	 *            the carrier of the language
	 * @param turtleTable
	 *            - turtleTable needs to update whenever a command is double clicked
	 */
	public PrevCommandList(Pane pane, double[] properties, TextInputBox textInput, List<Turtle> turtleList,
			Map<String, Double> variables, Map<String, Command> commands, GUIComboBox languageComboBox,
			TurtleViewTable turtleTable) {
		list = new ListView<>();
		mainTextInput = textInput;
		thisPane = pane;
		mainTurtleList = turtleList;
		setupList(properties[0], properties[1], properties[2], properties[3]);
		thisPane.getChildren().add(list);
		variableMap = variables;
		commandMap = commands;
		mainLanguageComboBox = (LanguageCombo) languageComboBox;
		mainTurtleTable = turtleTable;
	}

	/**
	 * Sets up the properties of the prevCommandList
	 * 
	 * @param xPos
	 *            - x position of the list
	 * @param yPos
	 *            - y position of the list
	 * @param width
	 *            - width of the list
	 * @param height
	 *            - height of the list
	 */
	private void setupList(double xPos, double yPos, double width, double height) {
		list.setLayoutX(xPos);
		list.setLayoutY(yPos);
		list.setPrefWidth(width);
		list.setPrefHeight(height);

		setupAction();

	}

	/**
	 * sets up the action event for the list - whenever a command is double pressed,
	 * it runs again for all of the active turtles
	 */
	private void setupAction() {
		list.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent click) {

				if (click.getClickCount() == 2) {
					for (Turtle t : mainTurtleList) {
						if (t.isActive()) {
							String currentItemSelected = list.getSelectionModel().getSelectedItem();
							mainTextInput.setText(currentItemSelected);
							Command test = new Command(currentItemSelected, t, variableMap, commandMap,
									mainLanguageComboBox.getLanguage());
							test.execute();
						}
					}

				}

				mainTurtleTable.updateValues();
			}

		});

	}

	/**
	 * adds text to the commandList. if text was already in the list, it moves it to
	 * the bottom of the list
	 * 
	 * @param text - text from textinputbox
	 */

	public void addText(String text) {
		if (items.contains(text)) {
			items.remove(text);
			items.add(text);
		} else {
			items.add(text);
		}
		list.setItems(items);

		final int size = list.getItems().size();
		if (size > 0) {
			list.scrollTo(size - 1);
		}
	}

}
