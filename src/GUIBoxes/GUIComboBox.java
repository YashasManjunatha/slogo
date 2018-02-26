package GUIBoxes;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;

public class GUIComboBox implements GUIBoxes {

	private ScreenBox thisTurtleScreen;
	private static Group thisRoot;
	private ComboBox<String> combobox;
	private final static ObservableList<String> options = FXCollections.observableArrayList("white", "black", "red",
			"darkgreen", "floralwhite", "indianred");

	public GUIComboBox(ScreenBox turtleScreen, Group root) {
		thisTurtleScreen = turtleScreen;
		thisRoot = root;
		combobox = new ComboBox<>(options);
		combobox.setPromptText("Change Background Color");
		combobox.setLayoutX(600);
		combobox.setLayoutY(550);
		combobox.valueProperty().addListener(new ChangeListener<String>() {
	        @Override public void changed(ObservableValue ov, String t, String t1) { 
	        	turtleScreen.changeColor(t1);
	    		combobox.setPromptText("Change Background Color");

	        }    
	    });
		root.getChildren().add(combobox);
	}

	@Override
	public void updateBox() {
		thisRoot.getChildren().remove(combobox);
		thisRoot.getChildren().add(combobox);

	}

}
