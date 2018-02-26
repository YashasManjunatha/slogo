package GUIBoxes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.ListView;

public class PrevCommandList {

	private static Group thisRoot;
	private ListView<String> list;
	private ObservableList<String> items =FXCollections.observableArrayList();
	
	public PrevCommandList(Group root, double[] properties) {
		list = new ListView<>();
		thisRoot = root;
		setupList(properties[0], properties[1], properties[2], properties[3]);
		root.getChildren().add(list);
	}

	private void setupList(double xPos, double yPos, double width, double height) {
		list.setLayoutX(xPos);
		list.setLayoutY(yPos);
		list.setPrefWidth(width);
		list.setPrefHeight(height);
	}

	public void addText(String text) {
		items.add(text);
		list.setItems(items);
		
	}



}
