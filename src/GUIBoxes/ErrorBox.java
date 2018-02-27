package GUIBoxes;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ErrorBox {
	public ErrorBox (String error_type, String error_msg) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText(error_type);
		alert.setContentText(error_msg);

		alert.showAndWait();
	}
}
