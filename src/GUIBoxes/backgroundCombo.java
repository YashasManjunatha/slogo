package GUIBoxes;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;

public class backgroundCombo extends GUIComboBox {
	
	private ScreenBox mainTurtleScreen;

	
	private final static ObservableList<String> options = FXCollections.observableArrayList("White", "Black", "Red",
			"Dark Green", "Blue", "Yellow", "Purple", "Orange");
	

	public backgroundCombo(Group root, ScreenBox turtleScreen, double[] properties, String title) {
		super(root, properties, title);
		mainTurtleScreen = turtleScreen;
		getCombobox().setItems(options);
		setupAction();
	}


	private void setupAction() {
		getCombobox().valueProperty().addListener(new ChangeListener<String>() {
	        @Override public void changed(ObservableValue ov, String t, String t1) { 
	        	String[] colorList = t1.toLowerCase().split(" ");
	        	mainTurtleScreen.changeColor(String.join("", colorList));
	    		getCombobox().setPromptText("Change Background Color");

	        }    
	    });
	}

}
