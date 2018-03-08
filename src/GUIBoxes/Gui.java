package GUIBoxes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Turtle.Turtle;
import commands.Command;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Gui {

	private final static double SCREEN_HEIGHT = 600;
	private final static double SCREEN_WIDTH = 1215;// 915;
	
	private TextInputBox textInput;
	private ScreenBox turtleScreen;
	private GUIComboBox languageComboBox;
	private PrevCommandList prevCommandBox;
	private ArrayList<Turtle> turtleList;
	private UserDefTable varTable;
	private UserDefTable funcTable;
	private TurtleViewTable turtleTable;
	private final Map<String, double[]> GUIProperties = createMap();

	// Additional setup for the main menu
	private Group root;
	private Stage myStage;
	private Map<String, Double> variableMap;
	private Map<String, Command> commandMap;
	private static Pane myPane;

	
	public Gui(Group root, Stage stage) {
		variableMap = new HashMap<>();
		commandMap = new HashMap<>();
		turtleList = new ArrayList<>();
		this.root = root;
		myStage = stage;
		myPane = new Pane();
		myPane.setMinHeight(SCREEN_HEIGHT);
		myPane.setMinWidth(SCREEN_WIDTH);
		initializeGUI();
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
		GUIProperties.put("newTurtleButton", new double[] { 30, 30, 45, 55 });
		
		GUIProperties.put("redoMoveButton", new double[] { 50, 50, 45, 55 });
		
		GUIProperties.put("turtleList", new double[] {925, 50, 250, 500});

		


		return GUIProperties;
	}
	
	public void initializeGUI() {
		
		setupGUIBoxes();
		setupComboboxes();
		setupButtons();
		setupTurtleCheckbox();
		
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
		new PenCombo(myPane, turtleList, GUIProperties.get("penCombo"), "Change Pen Color");

	}

	private void setupGUIBoxes() {

		textInput = new TextInputBox(myPane, GUIProperties.get("textInput"));
		turtleScreen = new ScreenBox(myPane, GUIProperties.get("turtleScreen"), turtleList);
		Image image = new Image(getClass().getClassLoader().getResourceAsStream("images/turtle.png"), 0, 55, true,
				false);
		Turtle turtle = new Turtle(turtleScreen, image);

		turtleList.add(turtle);

		System.out.println(turtleList);

		varTable = new UserDefTable(myPane, GUIProperties.get("varTable"), "Variable");
		funcTable = new UserDefTable(myPane, GUIProperties.get("funcTable"), "Function");
		languageComboBox = new LanguageCombo(myPane, GUIProperties.get("languageCombo"), "Change Language");

		prevCommandBox = new PrevCommandList(myPane, GUIProperties.get("prevCommandBox"), textInput, turtleList,
				variableMap, commandMap, languageComboBox);
		
		turtleTable = new TurtleViewTable(myPane, GUIProperties.get("turtleList"), turtleList);
	


	}

	private void setupButtons() {
		new RunButton(myPane, languageComboBox, GUIProperties.get("runButton"), "Run", textInput, prevCommandBox,
				turtleList, variableMap, commandMap, varTable, funcTable);

		new ClearButton(myPane, GUIProperties.get("clearButton"), "Clear", textInput, prevCommandBox, turtleList);

		new ChangeImageButton(myPane, GUIProperties.get("imageButton"), "Change Turtle Image", turtleScreen, myStage,
				turtleList);
		
		new NewTurtleButton(myPane, GUIProperties.get("newTurtleButton"), "New Turtle", turtleScreen, myStage,
				turtleList);
		
		new RedoMoveButton(myPane, GUIProperties.get("redoMoveButton"), "Redo Move", turtleScreen, myStage,
				turtleList);

	}
	
	public Pane getPane() {
		return myPane;
	}
}
