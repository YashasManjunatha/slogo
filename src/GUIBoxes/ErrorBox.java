package GUIBoxes;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * @author Yashas Manjunatha
 * Displays error box as a way to handle various errors and let user know.
 *
 */
public class ErrorBox {
	/**
	 * Creates new Error Box and displays it to the user.
	 * @param error_type General Error Type
	 * @param error_msg Specific Error Message
	 */
	public ErrorBox (String error_type, String error_msg) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText(error_type);
		alert.setContentText(error_msg);

		alert.showAndWait();
	}
}
