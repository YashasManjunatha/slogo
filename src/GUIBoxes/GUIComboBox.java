package GUIBoxes;

import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;

/**
 * Superclass for the various types of GUI objects that are comboboxes
 * 
 * @author Calvin Ma
 *
 */
public class GUIComboBox {

	private Pane thisPane;
	private ComboBox<String> combobox;

	private String boxText;

	/**
	 * Constructor for the GUI boxes
	 * 
	 * @param pane
	 *            - needed so that when a combobox is finished initializing, we can
	 *            add to the Pane
	 * @param properties
	 *            - properties needed to setup the combobox, like positions
	 * @param text
	 *            - label of the combobox if applicable - usually prompt text
	 */
	public GUIComboBox(Pane pane, double[] properties, String text) {
		thisPane = pane;
		boxText = text;
		setupProperties(properties[0], properties[1], properties[2], properties[3]);
		thisPane.getChildren().add(combobox);
	}

	/**
	 * Sets up properties for a Combobox
	 * @param xPos - x position of combobox
	 * @param yPos - y position of combobox
	 * @param width - width of combobox
	 * @param height - height of combobox
	 */
	private void setupProperties(double xPos, double yPos, double width, double height) {
		combobox = new ComboBox<>();
		getCombobox().setPromptText(boxText);
		getCombobox().setLayoutX(xPos);
		getCombobox().setLayoutY(yPos);
		getCombobox().setMinWidth(width);
		getCombobox().setMinHeight(height);

	}

	protected ComboBox<String> getCombobox() {
		return combobox;
	}

	protected void setCombobox(ComboBox<String> combobox) {
		this.combobox = combobox;
	}

}
