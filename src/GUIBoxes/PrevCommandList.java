package GUIBoxes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Turtle.Turtle;
import commands.Command;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class PrevCommandList extends ListView {

	private Pane thisPane;
	private ListView<String> list;
	private ObservableList<String> items = FXCollections.observableArrayList();
	private TextInputBox mainTextInput;
	private List<Turtle> mainTurtleList;
	
	private Map<String,Double> variableMap;

	public PrevCommandList(Pane pane, double[] properties, TextInputBox textInput, List<Turtle> turtleList, Map<String,Double> variables) {
		list = new ListView<>();
		mainTextInput = textInput;
		thisPane = pane;
		mainTurtleList = turtleList;
		setupList(properties[0], properties[1], properties[2], properties[3]);
		thisPane.getChildren().add(list);
		variableMap = variables;
	}

	private void setupList(double xPos, double yPos, double width, double height) {
		list.setLayoutX(xPos);
		list.setLayoutY(yPos);
		list.setPrefWidth(width);
		list.setPrefHeight(height);

		list.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent click) {

				if (click.getClickCount() == 2) {
					for (Turtle t : mainTurtleList) {
						String currentItemSelected = list.getSelectionModel().getSelectedItem();
						mainTextInput.setText(currentItemSelected);
						Command test = new Command(currentItemSelected, t, variableMap);
						test.execute();
					}
					
				}
			}
		});
	}

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
