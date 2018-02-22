package main;

import GUIBoxes.ScreenBox;
import GUIBoxes.TextInputBox;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Main extends Application {

	private static final Paint BACKGROUND = Color.ANTIQUEWHITE;
	
	private static String title;
	private static double screen_height = 600;
	private static double screen_width = 800;
	private static Stage stage;
//	private static GUIBox textInputBox, newSimChoice, prevSimChoice = null;
	private static Button runButton;
	private static TextInputBox textInput;
	private static ScreenBox turtleScreen;

	// Additional setup for the main menu
	private Scene myScene;
	private Group root;

	
	@Override
	public void start(Stage stage) {
		this.stage = stage;
		initialize();
	}

	private void initialize() {
		root = new Group();
		//setScreenProperties();
		myScene = new Scene(root, screen_width, screen_height, BACKGROUND);
		setStage();
		setupGUIBoxes();
		setupButton();
	}

	private void setupGUIBoxes() {

		textInput = new TextInputBox(root, 25, 475, 110, 650);
		turtleScreen = new ScreenBox(root, 25, 25, 585, 650);
		
		
//		turtleScreen = new ScreenBox(stage, root);
//		textInputBox = new TextInputBox(stage, root);
//		showVariablesBox = new VarBox(stage, root);
//		showFunctionBox = new VarBox(stage, root);
	}
	
	private void setupButton() {
		runButton = new Button("Run");
		runButton.setLayoutX(50);
		runButton.setLayoutY(50);
		
		
		root.getChildren().add(runButton);
		runButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        System.out.println(textInput.getText());
		        textInput.clear();
		        //updateGUI();
		    }
		});
		
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
