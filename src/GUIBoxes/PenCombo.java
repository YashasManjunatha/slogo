package GUIBoxes;


import java.util.ArrayList;

import Turtle.Turtle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.Group;

public class PenCombo extends GUIComboBox {

	public PenCombo(Group root, double[] properties, String text) {
		super(root, properties, text);
		// TODO Auto-generated constructor stub
	}
	
	private ScreenBox mainTurtleScreen;
	private static ArrayList<Turtle> thisTurtleList;

	private final static ObservableList<String> options = FXCollections.observableArrayList("White", "Black", "Red",
			"Dark Green", "Blue", "Yellow", "Purple", "Orange");

	public PenCombo(Group root, ArrayList<Turtle> turtleList, double[] properties, String title) {
		super(root, properties, title);
		thisTurtleList = turtleList;
		getCombobox().setItems(options);
		setupAction();
	}

	private void setupAction() {
		getCombobox().valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue ov, String t, String t1) {
				for (Turtle turt : thisTurtleList) {
					String[] colorList = t1.toLowerCase().split(" ");
		        	turt.changePenColor(String.join("", colorList));
				}

			}
		});
	}
}
