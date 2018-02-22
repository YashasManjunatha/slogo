package GUIBoxes;


import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class ScreenBox {
	
	private static HBox turtleScreen;
	
	public ScreenBox(Group root, double xPos, double yPos, double height, double width) {
		turtleScreen = new HBox();
		setupProperties(xPos, yPos, height, width);
		root.getChildren().add(turtleScreen);
	}

	private void setupProperties(double xPos, double yPos, double height, double width) {
		turtleScreen.setLayoutX(xPos);
		turtleScreen.setLayoutY(yPos);
		turtleScreen.setMinWidth(width);

		turtleScreen.setMaxWidth(width);
		turtleScreen.setMaxHeight(height);
		
	}

}
