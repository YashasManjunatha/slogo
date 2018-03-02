package GUIBoxes;

import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import Turtle.Turtle;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

public class ScreenBox implements GUIBoxes{

	private Canvas turtleScreen;
	private static Group thisRoot;
	private static GraphicsContext gc;
	private static StackPane stackPane;
	private static ArrayList<Turtle> mainTurtleList;
	
	public ScreenBox(Group root, double[] properties, ArrayList<Turtle> turtleList) {
		turtleScreen = new Canvas();
		thisRoot = root;
		mainTurtleList = turtleList;
		setupProperties(properties[0], properties[1], properties[2], properties[3]);
		
		root.getChildren().add(turtleScreen);
	}

	private void setupProperties(double xPos, double yPos, double width, double height) {
		
		/**
		 * final Canvas canvas = new Canvas();
		canvas.setLayoutX(25);
		canvas.setLayoutY(25);
		canvas.setWidth(650);
		canvas.setHeight(425);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.BLUE);
		gc.fillRect(0, 0, 650, 425);
		gc.drawImage(image, 300, 300);
		gc.setFill(Color.BLUE);
		gc.fillRect(0, 0, 650, 425);
		 */
		
		turtleScreen.setLayoutX(xPos);
		turtleScreen.setLayoutY(yPos);
		turtleScreen.setWidth(width);
		turtleScreen.setHeight(height);
		gc = turtleScreen.getGraphicsContext2D();
		gc.setFill(Color.BLUE);
		gc.fillRect(0, 0, 650, 425);

	}

	public void changeColor(String color) {
		turtleScreen.setStyle("-fx-background-color: " + color + ";");
	}


	public void replaceImage(String fileName) {
		for (Turtle t : mainTurtleList) {
			// Point location = new Point();
			// location.setLocation(t.getX(), t.getY());
			// basically just set locations for the new image
			mainTurtleList.remove(t);
			System.out.println(fileName);
			Image image = null;
			try {
				image = new Image(new FileInputStream(fileName), 0, 50, true, false);
			} catch (FileNotFoundException e) {
				new ErrorBox("Image Not Found", "Please Choose A Valid Image");
			}
			updateBox();
			Turtle turtle = new Turtle(this, image);
			mainTurtleList.add(turtle);
		}

	}

	public double getX() {
		return turtleScreen.getLayoutX();
	}
	
	public double getY() {
		return turtleScreen.getLayoutY();
	}
	
	public double getHeight() {
		return turtleScreen.getHeight();
	}
	
	public double getWidth() {
		return turtleScreen.getWidth();
	}

	public void addToCanvas(Group pen) {
		
	}

	public void addTurtleToCanvas(Image turtle, double xPos, double yPos) {
		gc.drawImage(turtle, xPos, yPos);
		
	}

	@Override
	public void updateBox() {
		gc.setFill(Color.BLUE);
		gc.fillRect(0, 0, 650, 425);
		for (Turtle t : mainTurtleList) {
			gc.save();
			rotate(gc, t.getOrientation(), t.getX() + t.getImage().getWidth() / 2, t.getY() + t.getImage().getHeight() / 2);
			addTurtleToCanvas(t.getImage(), t.getX(), t.getY());
			gc.restore();
		}
		
	}
	
	private void rotate(GraphicsContext gc, double angle, double x, double y) {
        Rotate r = new Rotate(angle, x, y);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }

}
