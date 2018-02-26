package main;

import GUIBoxes.GUIComboBox;
import GUIBoxes.ScreenBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;

public class backgroundCombo extends GUIComboBox {
	
	private final static ObservableList<String> options = FXCollections.observableArrayList("white", "black", "red",
			"darkgreen", "floralwhite", "indianred");


	public backgroundCombo(Group root, ScreenBox turtleScreen, double[] properties, String title) {
		super(root, turtleScreen, properties, title);
	}

}
