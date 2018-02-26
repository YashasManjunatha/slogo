package GUIBoxes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class PrevCommandList extends ListView {

	private static Group thisRoot;
	private ListView<String> list;
	private ObservableList<String> items = FXCollections.observableArrayList();
	private static TextInputBox mainTextInput;

	public PrevCommandList(Group root, double[] properties, TextInputBox textInput) {
		list = new ListView<>();
		mainTextInput = textInput;
		thisRoot = root;
		setupList(properties[0], properties[1], properties[2], properties[3]);
		root.getChildren().add(list);
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
					String currentItemSelected = list.getSelectionModel().getSelectedItem();
					mainTextInput.setText(currentItemSelected);
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
