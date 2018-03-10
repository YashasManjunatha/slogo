package GUIBoxes;

import java.util.HashMap;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;

/**
 * 
 * This class sets up the Comboxbox on the GUI that allows the user to select a
 * color of their choice for the background. The colors are limited in that the
 * user's only choices are in the drop down, but this also erases the
 * possibility of getting an invalid color.
 * 
 * @author Calvin Ma
 *
 */

public class BackgroundCombo extends GUIComboBox {

	private ScreenBox mainTurtleScreen;

	private final static ObservableList<String> options = FXCollections.observableArrayList("White", "Black", "Red",
			"Dark Green", "Blue", "Yellow", "Purple", "Orange");

	private static final HashMap<String, Color> colorMap = createColorMap();

	/**
	 * 
	 * Constructor for the combo box
	 * 
	 * @param pane
	 *            - takes in a Pane from the Gui object. Every object in the GUI is
	 *            added to this pane.
	 * @param turtleScreen
	 *            - the combobox is connected to the turtlescreen in that it changes
	 *            the background of the turtleScreen, which is why the screen is a
	 *            parameter
	 * @param properties
	 *            - properties of the combobox
	 * @param title
	 *            - the title of the combobox - what will be initially displayed by
	 *            the combobox
	 */
	public BackgroundCombo(Pane pane, ScreenBox turtleScreen, double[] properties, String title) {
		super(pane, properties, title);
		mainTurtleScreen = turtleScreen;
		getCombobox().setItems(options);
		setupAction();
	}

	/**
	 * 
	 * This method sets up the map that maps a string to the corresponding color.
	 * 
	 * @return - returns a HashMap that the rest of the class will ultimately use
	 */
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

	/**
	 * sets up the action event for the combobox. In this case, whenever the
	 * combobox value changes, the turtle screen's background will change to
	 * selected color
	 */
	private void setupAction() {
		getCombobox().valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue ov, String t, String t1) {
				mainTurtleScreen.changeBackgroundColor(colorMap.get(t1));

			}
		});
	}

}
