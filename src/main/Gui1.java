package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import GUIBoxes.MoveButtonFactory;
import Turtle.Turtle;
import commands.Command;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Gui class that holds all of the GUI objects. This class puts them all into a
 * single pane, which is then added to a tab in the main class. This is mainly
 * used for creating multiple workspaces
 * 
 * @author Calvin Ma
 *
 */
public class Gui1 extends Pane {

	private final static double SCREEN_HEIGHT = 600;
	private final static double SCREEN_WIDTH = 1215;// 915;

	private Group root;
	private Stage myStage;

	
	public Gui1(Group root, Stage stage) {

		this.root = root;
		myStage = stage;
		this.setMinHeight(SCREEN_HEIGHT);
		this.setMinWidth(SCREEN_WIDTH);
		initializeGUI();
	}

	public void initializeGUI() {

		initializeMoveButtons();

	}

	private void initializeMoveButtons() {
		MoveButtonFactory moveButtonFact = new MoveButtonFactory();

		double[] prop = { 100, 100, 100, 100 };

		Button b = moveButtonFact.create("ForwardButton", prop);

		this.getChildren().add(b);

	}

}
