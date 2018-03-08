package GUIBoxes;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;

public class LanguageCombo extends GUIComboBox {

	private final static ObservableList<String> options = FXCollections.observableArrayList("Chinese", "English",
			"French", "German", "Italian", "Portuguese", "Russian", "Spanish");

	private String language = "English";

	public LanguageCombo(Pane pane, double[] properties, String text) {
		super(pane, properties, text);
		getCombobox().setItems(options);
		setupAction();

	}

	private void setupAction() {
		getCombobox().valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue ov, String t, String t1) {
				language = t1;
				System.out.println(language);
				System.out.println(t1);

			}
		});
	}
	
	public String getLanguage() {
		System.out.println("get lang" + language);
		return language;
	}

}
