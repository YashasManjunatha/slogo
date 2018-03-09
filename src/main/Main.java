package main;

import GUIBoxes.Gui;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Main extends Application {

	private final static Paint BACKGROUND = Color.ANTIQUEWHITE;

	private String title;
	private final static double SCREEN_HEIGHT = 650;
	private final static double SCREEN_WIDTH = 1215;// 915;
	private Stage myStage;
	private int workSpaceNum = 1;
	private Group root;
	private TabPane tabPane;

	// private static final Map<String, double[]> GUIProperties = createMap();

	// Additional setup for the main menu
	private Scene myScene;

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

		setupNewTabButton();

		Tab firstTab = new Tab("Workspace " + workSpaceNum);
		workSpaceNum += 1;
		Gui firstGui = new Gui(root, myStage);

		firstTab.setContent(firstGui.getPane());
		tabPane.getTabs().add(firstTab);
		tabPane.getSelectionModel().select(firstTab);

		root.getChildren().add(tabPane);

	}

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
