package GUIBoxes;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;

public class backgroundCombo extends GUIComboBox {
	
	private ScreenBox mainTurtleScreen;

	
	private final static ObservableList<String> options = FXCollections.observableArrayList("white", "black", "red",
			"darkgreen", "floralwhite", "indianred");


	public backgroundCombo(Group root, ScreenBox turtleScreen, double[] properties, String title) {
		super(root, properties, title);
		mainTurtleScreen = turtleScreen;
		getCombobox().setItems(options);
		setupAction();
	}


	private void setupAction() {
		getCombobox().valueProperty().addListener(new ChangeListener<String>() {
	        @Override public void changed(ObservableValue ov, String t, String t1) { 
	        	mainTurtleScreen.changeColor(t1);
	    		getCombobox().setPromptText("Change Background Color");

	        }    
	    });
	}

}
