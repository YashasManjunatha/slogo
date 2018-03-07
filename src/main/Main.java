package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import GUIBoxes.Buttons;
import GUIBoxes.ChangeImageButton;
import GUIBoxes.ClearButton;
import GUIBoxes.GUIComboBox;
import GUIBoxes.PrevCommandList;
import GUIBoxes.RunButton;
import GUIBoxes.ScreenBox;
import GUIBoxes.TextInputBox;
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
	private final static double SCREEN_WIDTH = 1215;// 915;
	private static Stage myStage;
	private static TextInputBox textInput;
	private static ScreenBox turtleScreen;
	private static GUIComboBox languageComboBox;
	private static PrevCommandList prevCommandBox;
	private static ArrayList<Turtle> turtleList;
	private static UserDefTable varTable;
	private static UserDefTable funcTable;
	private static final Map<String, double[]> GUIProperties = createMap();

	// Additional setup for the main menu
	private Scene myScene;
	private Group root;
	private Map<String, Double> variableMap;
	private Map<String, Command> commandMap;
	
	private static TabPane tabPane;
	private static Tab tab;
	private static Pane myPane;
	
	@Override
	public void start(Stage stage) {
		myStage = stage;
		variableMap = new HashMap<>();
		commandMap = new HashMap<>();
		initialize();
	}

	private static Map<String, double[]> createMap() {
		Map<String, double[]> GUIProperties = new HashMap<>();
		// first index = xPos, second = yPos, third = width, fourth = length
		GUIProperties.put("turtleScreen", new double[] { 25, 25, 650, 425 });
		GUIProperties.put("textInput", new double[] { 25, 475, 605, 110 });

		GUIProperties.put("varTable", new double[] { 700, 25, 200, 120 });
		GUIProperties.put("funcTable", new double[] { 700, 150, 200, 120 });

		GUIProperties.put("prevCommandBox", new double[] { 700, 275, 200, 125 });

		GUIProperties.put("backgroundCombo", new double[] { 700, 435, 200, 15 });
		GUIProperties.put("languageCombo", new double[] { 700, 465, 200, 15 });
		GUIProperties.put("penCombo", new double[] { 700, 495, 200, 15 });

		GUIProperties.put("imageButton", new double[] { 700, 405, 200, 15 });
		GUIProperties.put("runButton", new double[] { 630, 475, 45, 55 });
		GUIProperties.put("clearButton", new double[] { 630, 530, 45, 55 });

		return GUIProperties;
	}

	private void initialize() {
		root = new Group();
		turtleList = new ArrayList<>();
		myScene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT, BACKGROUND);
		setStage();
		tabPane = new TabPane();
		tab = new Tab();
		myPane = new Pane();
		myPane.setMinHeight(SCREEN_HEIGHT);
		myPane.setMinWidth(SCREEN_WIDTH);


		setupGUIBoxes();
		setupComboboxes();
		setupButtons();
		setupTurtleCheckbox();
		
		tab.setContent(myPane);
		
		tabPane.getTabs().add(tab);
		
		root.getChildren().add(tabPane);

	}

	private void setupTurtleCheckbox() {
		VBox vbchecks = new VBox();
		vbchecks.setSpacing(0);
		vbchecks.setPadding(new Insets(0));
		for (Turtle t : turtleList) {
			final CheckBox cb = new CheckBox("turtle");
			cb.selectedProperty().addListener(new ChangeListener<Boolean>() {
				public void changed(ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) {
					System.out.println(cb.isSelected());
				}
			});
			vbchecks.getChildren().add(cb);
		}
		ScrollPane scroll = new ScrollPane(vbchecks);
		scroll.setMaxHeight(10);
		root.getChildren().add(scroll);

	}

	private void setupComboboxes() {
		new BackgroundCombo(myPane, turtleScreen, GUIProperties.get("backgroundCombo"), "Change Background Color");
		languageComboBox = new LanguageCombo(myPane, GUIProperties.get("languageCombo"), "Change Language");
		new PenCombo(myPane, turtleList, GUIProperties.get("penCombo"), "Change Pen Color");

	}

	private void setupGUIBoxes() {

		textInput = new TextInputBox(myPane, GUIProperties.get("textInput"));
		turtleScreen = new ScreenBox(myPane, GUIProperties.get("turtleScreen"), turtleList);
		Image image = new Image(getClass().getClassLoader().getResourceAsStream("images/turtle.png"), 0, 55, true,
				false);
		Turtle turtle = new Turtle(turtleScreen, image);

		turtleList.add(turtle);

		varTable = new UserDefTable(myPane, GUIProperties.get("varTable"), "Variable");
		funcTable = new UserDefTable(myPane, GUIProperties.get("funcTable"), "Function");
		prevCommandBox = new PrevCommandList(myPane, GUIProperties.get("prevCommandBox"), textInput, turtleList,
				variableMap);

	}

	private void setupButtons() {
		new RunButton(myPane, languageComboBox, GUIProperties.get("runButton"), "Run", textInput, prevCommandBox,
				turtleList, variableMap, commandMap, varTable, funcTable);

		new ClearButton(myPane, GUIProperties.get("clearButton"), "Clear", textInput, prevCommandBox, turtleList);

		new ChangeImageButton(myPane, GUIProperties.get("imageButton"), "Change Turtle Image", turtleScreen, myStage,
				turtleList);

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
