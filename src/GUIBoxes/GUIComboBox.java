package GUIBoxes;

import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;

public class GUIComboBox {

	private Pane thisPane;
	private ComboBox<String> combobox;

	private String boxText;

	public GUIComboBox(Pane pane, double[] properties, String text) {
		thisPane = pane;
		boxText = text;
		setupProperties(properties[0], properties[1], properties[2], properties[3]);
		thisPane.getChildren().add(combobox);
	}

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
