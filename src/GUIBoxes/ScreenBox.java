package GUIBoxes;


import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class ScreenBox{
	
	private static Pane turtleScreen;
	
	public ScreenBox(Group root, double xPos, double yPos, double height, double width) {
		turtleScreen = new Pane();
		setupProperties(xPos, yPos, height, width);
		turtleScreen.setStyle("-fx-background-color: black;");
		Circle circle = new Circle(50,Color.BLUE);
	    circle.relocate(20, 20);
	    Rectangle rectangle = new Rectangle(100,100,Color.RED);
	    rectangle.relocate(70,70);
	    turtleScreen.getChildren().addAll(circle,rectangle);
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


}
