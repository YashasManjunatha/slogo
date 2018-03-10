package GUIBoxes;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;

/**
 * Subclass of GUIComboBox - allows user to select language for the
 * textinputbox/parser
 * 
 * @author calma
 *
 */
public class LanguageCombo extends GUIComboBox {

	private final static ObservableList<String> options = FXCollections.observableArrayList("Chinese", "English",
			"French", "German", "Italian", "Portuguese", "Russian", "Spanish");

	private String language = "English";

	/**
	 * Constructor for language combo box - see superclass for parameters
	 * 
	 * @param pane
	 * @param properties
	 * @param text
	 */

	public LanguageCombo(Pane pane, double[] properties, String text) {
		super(pane, properties, text);
		getCombobox().setItems(options);
		setupAction();

	}

	/**
	 * sets up the action of the combobox - when the value of the combobox is
	 * changed, the language of the combobox is changed and later sent out to where
	 * it's needed
	 */
	private void setupAction() {
		getCombobox().valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue ov, String t, String t1) {
				language = t1;

			}
		});
	}

	/**
	 * gets the language in the combobox, which is used to translate future commands
	 * 
	 * @return - language as String
	 */
	public String getLanguage() {
		System.out.println("get lang" + language);
		return language;
	}

}
