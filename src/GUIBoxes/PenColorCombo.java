package GUIBoxes;

import java.util.HashMap;
import java.util.List;

import Turtle.Turtle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * Subclass of GUICombobox that allows the users to choose color of pen
 * 
 * @author Calvin Ma
 *
 */
public class PenColorCombo extends GUIComboBox {

	private ScreenBox mainTurtleScreen;
	private List<Turtle> thisTurtleList;

	private final static ObservableList<String> options = FXCollections.observableArrayList("White", "Black", "Red",
			"Dark Green", "Blue", "Yellow", "Purple", "Orange");

	private static final HashMap<String, Color> colorMap = createColorMap();

	/**
	 * Constructor for pen color combobox - check GUICombobox superclass for
	 * unspecified parameters
	 * 
	 * @param pane
	 * @param turtleList
	 *            - because the turtle holds the properties of the pen, this class
	 *            needs each turtle through the turtleList
	 * @param properties
	 * @param title
	 */
	public PenColorCombo(Pane pane, List<Turtle> turtleList, double[] properties, String title) {
		super(pane, properties, title);
		thisTurtleList = turtleList;
		getCombobox().setItems(options);
		setupAction();
	}

	/**
	 * initializes a colormap that maps a string for a color and its corresponding
	 * Color class value. necessary for the colormap instance variable
	 * 
	 * @return
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
	 * sets up action of combobox - combobox reads in whatever is inside of it and
	 * changes the color of the pen to the selected color
	 */
	private void setupAction() {
		getCombobox().valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue ov, String t, String t1) {
				for (Turtle turt : thisTurtleList) {
					if (turt.isActive()) {
						turt.changePenColor(colorMap.get(t1));
					}
				}

			}
		});
	}
}
