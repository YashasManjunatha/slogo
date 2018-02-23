package GUIBoxes;


import Turtle.Turtle;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class ScreenBox{
	
	private Pane turtleScreen;
	
	public ScreenBox(Group root, double xPos, double yPos, double height, double width) {
		turtleScreen = new Pane();
		setupProperties(xPos, yPos, height, width);
		turtleScreen.setStyle("-fx-background-color: white;");
		root.getChildren().add(turtleScreen);
	}

	private void setupProperties(double xPos, double yPos, double height, double width) {
		turtleScreen.setLayoutX(xPos);
		turtleScreen.setLayoutY(yPos);
		turtleScreen.setMinWidth(width);
		turtleScreen.setMaxWidth(width);
		turtleScreen.setMinHeight(height);
		turtleScreen.setMaxHeight(height);
		
	}
	
	public void changeColor(String color) {
		turtleScreen.setStyle("-fx-background-color: " + color + ";");
	}
	
	public Pane getPane() {
		return this.turtleScreen;
	}

	public void addTurtle(Turtle turtle) {
		// TODO Auto-generated method stub
		
	}


}
