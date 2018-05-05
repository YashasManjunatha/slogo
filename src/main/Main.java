package main;

import GUIBoxes.Gui;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

/**
 * Main class where Tabs are created
 * 
 * @author Calvin Ma
 *
 */
public class Main extends Application {

	private final static Paint BACKGROUND = Color.ANTIQUEWHITE;

	private String title;
	private final static double SCREEN_HEIGHT = 650;
	private final static double SCREEN_WIDTH = 1300;// 915;
	private Stage myStage;
	private int workSpaceNum = 1;
	private Group root;
	private TabPane tabPane;

	// private static final Map<String, double[]> GUIProperties = createMap();

	// Additional setup for the main menu
	private Scene myScene;

	/**
	 * initalizes the stage
	 */
	@Override
	public void start(Stage stage) {
		myStage = stage;
		initialize();
	}

	/**
	 * initializes the group and scene. Creates a tabpane which is used for multiple
	 * workspaces
	 */
	private void initialize() {
		root = new Group();
		myScene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT, BACKGROUND);
		setStage();
		tabPane = new TabPane();

		
		
		setupHelpButton();

		setupNewTabButton();

		Tab firstTab = new Tab("Workspace " + workSpaceNum);
		workSpaceNum += 1;
		Gui firstGui = new Gui(root, myStage);

		firstTab.setContent(firstGui.getPane());
		tabPane.getTabs().add(firstTab);
		tabPane.getSelectionModel().select(firstTab);

		root.getChildren().add(tabPane);

	}

	/**
	 * The first tab is changed to a help button. When pressed, two tabs of commands
	 * are opened in the local machine's default browser
	 */
	private void setupHelpButton() {
		Tab newTabButton = new Tab();

		Button newTab = new Button("Press for Help");

		newTab.setOnAction(event -> {
			getHostServices()
					.showDocument("https://www2.cs.duke.edu/courses/compsci308/current/assign/03_slogo/commands.php");
			getHostServices().showDocument(
					"https://www2.cs.duke.edu/courses/compsci308/current/assign/03_slogo/commands2_J2W.php");
		});

		newTabButton.setGraphic(newTab);
		newTabButton.setClosable(false);

		tabPane.getTabs().add(newTabButton);

	}

	/**
	 * the second tab is changed into a new tab button, which creates a new tab upon
	 * press
	 */
	private void setupNewTabButton() {
		Tab newTabButton = new Tab();
				
		Button newTab = new Button("New Tab");

		newTab.setOnAction(event -> {
			Tab nextTab = new Tab("Workspace " + workSpaceNum);
			workSpaceNum += 1;
			Gui nextGui = new Gui(root, myStage);
			nextTab.setContent(nextGui.getPane());
			tabPane.getTabs().add(nextTab);
			tabPane.getSelectionModel().select(nextTab);
		});

		newTabButton.setGraphic(newTab);
		newTabButton.setClosable(false);

		tabPane.getTabs().add(newTabButton);

	}

	/**
	 * sets up stage
	 */
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
