package main;

import java.util.ArrayList;
import java.util.HashMap;

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
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Main extends Application {

	private static final Paint BACKGROUND = Color.ANTIQUEWHITE;

	private static String title;
	private final static double SCREEN_HEIGHT = 600;
	private final static double SCREEN_WIDTH = 915;
	private static Stage stage;
	private static TextInputBox textInput;
	private static ScreenBox turtleScreen;
	private static GUIComboBox languageComboBox;
	private static PrevCommandList prevCommandBox;
	private static ArrayList<Turtle> turtleList;
	private static final HashMap<String, double[]> GUIProperties = createMap();

	// Additional setup for the main menu
	private Scene myScene;
	private Group root;

	@Override
	public void start(Stage stage) {
		this.stage = stage;
		initialize();
	}

	private static HashMap<String, double[]> createMap() {
		HashMap<String, double[]> GUIProperties = new HashMap<>();
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
		setupGUIBoxes();
		setupButtons();
		setupComboboxes();
		
	}

	private void setupComboboxes() {
		new BackgroundCombo(root, turtleScreen, GUIProperties.get("backgroundCombo"), "Change Background Color");
		languageComboBox = new LanguageCombo(root, GUIProperties.get("languageCombo"), "Change Language");
		((LanguageCombo) languageComboBox).getLanguage();
		new PenCombo(root, turtleList, GUIProperties.get("penCombo"), "Change Pen Color");

	}

	private void setupGUIBoxes() {

		textInput = new TextInputBox(root, GUIProperties.get("textInput"));
		turtleScreen = new ScreenBox(root, GUIProperties.get("turtleScreen"), turtleList);
		Image image = new Image(getClass().getClassLoader().getResourceAsStream("images/turtle.png"), 0, 55, false, false);
		Turtle turtle = new Turtle(turtleScreen, image);
		turtleList.add(turtle);		
		new UserDefTable(root, GUIProperties.get("varTable"), "Variable");
		new UserDefTable(root, GUIProperties.get("funcTable"), "Function");
		prevCommandBox = new PrevCommandList(root, GUIProperties.get("prevCommandBox"), textInput);

	}

	private void setupButtons() {
		new RunButton(root, languageComboBox, GUIProperties.get("runButton"), "Run", textInput, prevCommandBox,
				turtleList);

		new ClearButton(root, GUIProperties.get("clearButton"), "Clear", textInput, prevCommandBox, turtleList);

		new ChangeImageButton(root, GUIProperties.get("imageButton"), "Change Turtle Image", turtleScreen, stage,
				turtleList);

	}

	private void setStage() {
		stage.setScene(myScene);
		stage.setTitle(title);
		stage.show();
		stage.setResizable(false);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
