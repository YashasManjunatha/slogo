package GUIBoxes;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;

public class GUIComboBox implements GUIBoxes {

	private ScreenBox mainTurtleScreen;
	private static Group thisRoot;
	private ComboBox<String> combobox;
	private final static ObservableList<String> options = FXCollections.observableArrayList("white", "black", "red",
			"darkgreen", "floralwhite", "indianred");
	private String boxText;

	public GUIComboBox(Group root, ScreenBox turtleScreen, double[] properties, String text) {
		mainTurtleScreen = turtleScreen;
		thisRoot = root;
		boxText = text;
		setupProperties(properties[0], properties[1], properties[2], properties[3]);
		root.getChildren().add(getCombobox());
	}

	private void setupProperties(double xPos, double yPos, double width, double height) {
		combobox = new ComboBox<>(options);
		getCombobox().setPromptText(boxText);
		getCombobox().setLayoutX(xPos);
		getCombobox().setLayoutY(yPos);
		getCombobox().setMinWidth(width);
		getCombobox().setMinHeight(height);
		
		getCombobox().valueProperty().addListener(new ChangeListener<String>() {
	        @Override public void changed(ObservableValue ov, String t, String t1) { 
	        	mainTurtleScreen.changeColor(t1);
	    		getCombobox().setPromptText("Change Background Color");

	        }    
	    });
		
	}

	@Override
	public void updateBox() {
		thisRoot.getChildren().remove(getCombobox());
		thisRoot.getChildren().add(getCombobox());

	}

	protected ComboBox<String> getCombobox() {
		return combobox;
	}

	protected void setCombobox(ComboBox<String> combobox) {
		this.combobox = combobox;
	}

}
