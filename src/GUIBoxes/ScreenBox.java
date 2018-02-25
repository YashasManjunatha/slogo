package GUIBoxes;


import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import Turtle.Turtle;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class ScreenBox{
	
	private Pane turtleScreen;
	private static Group thisRoot;
	
	public ScreenBox(Group root, double[] properties) {
		turtleScreen = new Pane();
		thisRoot = root;
		setupProperties(properties[0], properties[1], properties[2], properties[3]);
		turtleScreen.setStyle("-fx-background-color: white;");
		root.getChildren().add(turtleScreen);
	}

	private void setupProperties(double xPos, double yPos, double width, double height) {
		turtleScreen.setLayoutX(xPos);
		turtleScreen.setLayoutY(yPos);
		turtleScreen.setMinWidth(width);
		turtleScreen.setMaxWidth(width);
		turtleScreen.setMinHeight(height);
		turtleScreen.setMaxHeight(height);
		turtleScreen.setFocusTraversable(false);
		turtleScreen.setMouseTransparent(true);
		
	}
	
	public void changeColor(String color) {
		turtleScreen.setStyle("-fx-background-color: " + color + ";");
	}
	
	public Pane getPane() {
		return this.turtleScreen;
	}


	public void replaceImage(String fileName, ArrayList<Turtle> turtleList) {
		for (Turtle t : turtleList) {
//			Point location = new Point();
//			location.setLocation(t.getX(), t.getY());
			//basically just set locations for the new image 
			turtleScreen.getChildren().remove(t.getImage());
			turtleList.remove(t);
			System.out.println(fileName);
			Image image = null;
			try {
				image = new Image(new FileInputStream(fileName));
			} catch (FileNotFoundException e) {
				e.printStackTrace();//CHANGE THIS LINE - MAKE ALERT BOX POP UP
			}
			Turtle turtle = new Turtle(turtleScreen, image);
			turtleList.add(turtle);
		}
		
	}


}
