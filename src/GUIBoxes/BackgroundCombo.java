package GUIBoxes;

import java.util.HashMap;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

public class BackgroundCombo extends GUIComboBox {
	
	private ScreenBox mainTurtleScreen;

	
	private final static ObservableList<String> options = FXCollections.observableArrayList("White", "Black", "Red",
			"Dark Green", "Blue", "Yellow", "Purple", "Orange");
	
	private static final HashMap<String, Color> colorMap = createColorMap();

	

	public BackgroundCombo(Pane pane, ScreenBox turtleScreen, double[] properties, String title) {
		super(pane, properties, title);
		mainTurtleScreen = turtleScreen;
		getCombobox().setItems(options);
		setupAction();
	}


	private static HashMap<String, Color> createColorMap() {
		HashMap<String, Color> colorMap = new HashMap<>();
		// first index = xPos, second = yPos, third = width, fourth = length
		colorMap.put("White", Color.WHITE);
		colorMap.put("Black", Color.BLACK);
		colorMap.put("Red", Color.RED);
		colorMap.put("Dark Green", Color.DARKGREEN);
		colorMap.put("Blue", Color.BLUE);
		colorMap.put("Yellow", Color.YELLOW);
		colorMap.put("Purple", Color.PURPLE);
		colorMap.put("Orange", Color.ORANGE);
		
		return colorMap;
	}


	private void setupAction() {
		getCombobox().valueProperty().addListener(new ChangeListener<String>() {
	        @Override public void changed(ObservableValue ov, String t, String t1) { 
	        	System.out.println(t1);
	        	mainTurtleScreen.changeBackgroundColor(colorMap.get(t1));
	    		getCombobox().setPromptText("Change Background Color");

	        }    
	    });
	}

}
