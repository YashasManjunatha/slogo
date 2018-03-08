package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import GUIBoxes.Buttons;
import GUIBoxes.ChangeImageButton;
import GUIBoxes.ClearButton;
import GUIBoxes.GUIComboBox;
import GUIBoxes.Gui;
import GUIBoxes.PrevCommandList;
import GUIBoxes.RunButton;
import GUIBoxes.ScreenBox;
import GUIBoxes.TextInputBox;
import GUIBoxes.TurtleViewTable;
import GUIBoxes.UserDefTable;
import GUIBoxes.BackgroundCombo;
import GUIBoxes.LanguageCombo;
import GUIBoxes.PenCombo;
import Turtle.Turtle;
import commands.Command;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

	private static final Paint BACKGROUND = Color.ANTIQUEWHITE;

	private static String title;
	private final static double SCREEN_HEIGHT = 600;
	private final static double SCREEN_WIDTH = 1365;//915;
	private static Stage myStage;

	// private static final Map<String, double[]> GUIProperties = createMap();

	// Additional setup for the main menu
	private Scene myScene;
	private Group root;

	private static TabPane tabPane;

	@Override
	public void start(Stage stage) {
		myStage = stage;
		initialize();
	}

	private void initialize() {
		root = new Group();
		myScene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT, BACKGROUND);
		setStage();
		tabPane = new TabPane();

		tabPane.getSelectionModel().selectedItemProperty().addListener(

				new ChangeListener<Tab>() {
					@Override
					public void changed(ObservableValue<? extends Tab> ov, Tab t, Tab t1) {
						System.out.println("Tab Selection changed");
					}
				});

		Tab tab1 = new Tab();
		Gui first = new Gui(root, myStage);

		tab1.setContent(first.getPane());

		tabPane.getTabs().add(tab1);

		Tab tab2 = new Tab();
		Gui second = new Gui(root, myStage);

		tab2.setContent(second.getPane());

		tabPane.getTabs().add(tab2);

		root.getChildren().add(tabPane);

	}

	private void setStage() {
		myStage.setScene(myScene);
		myStage.setTitle(title);
		myStage.show();
		myStage.setResizable(false);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
