package GUIBoxes;

import java.util.ArrayList;

import Turtle.Turtle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;

public class PenCombo extends GUIComboBox {
	
	private ScreenBox mainTurtleScreen;
	private static ArrayList<Turtle> thisTurtleList;

	private final static ObservableList<String> options = FXCollections.observableArrayList("white", "black", "red",
			"darkgreen", "floralwhite", "indianred");

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
					turt.setPenColor(t1);
				}

			}
		});
	}
}
