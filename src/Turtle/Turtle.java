package Turtle;

import GUIBoxes.ScreenBox;
import Pen.Pen;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;


public class Turtle implements TurtleInterface{
    
	private final static double fixedImageHeight = 50;
    
	private static ScreenBox screen;
	private Image image;
	private ImageView turtle = new ImageView();
	private boolean turtleShowing;
	private Pen pen;
	private boolean penShowing;
	private final static double OFFSET = 25;
	
	public Turtle(ScreenBox turtle_screen, Image turtle_image) {
		screen = turtle_screen;
		image = turtle_image;
		initalizeTurtle();

	}

	private void initalizeTurtle() {
		turtle.setImage(image);
		turtle.setX(screen.getWidth()/2 - image.getWidth()/2);
		turtle.setY(screen.getHeight()/2 - image.getHeight()/2);
		scaleTurtle();
		cropTurtle();
		screen.addToPane(turtle);
		turtleShowing = true;
		pen = new Pen();
        penShowing = true;
	}

	private void scaleTurtle() {
		double imageRatio = image.getWidth()/image.getHeight();
		turtle.setFitHeight(fixedImageHeight);
		turtle.setFitWidth(fixedImageHeight * imageRatio);
		turtle.setPreserveRatio(true);

	}

	@Override
	public double move(double diff) {
		turtle.setY(turtle.getY() + diff);
		return diff;
	}
//	public void move(double diffX, double diffY) {
//		turtle.setX(getX() + diffX);
//		turtle.setY(getY() + diffY);
//		cropTurtle();
//	}

	@Override
	public void turn(double degrees) {
		turtle.setRotate(turtle.getRotate() + degrees);
		cropTurtle();
	}

	@Override
	public double getX() {
		return turtle.getX();
	}

	@Override
	public double getY() {
		return turtle.getY();
	}

	@Override
	public double getOrientation() {
		return turtle.getRotate();
	}

	@Override
	public void setPenDown(boolean penDown) {

		if (penShowing && !penDown)
			screen.removeFromPane(pen.getPen());
		if (!penShowing && penDown)
			screen.addToPane(pen.getPen());
	}

	@Override
	public boolean getPenDown() {
		return penShowing;
	}

	@Override
	public void setTurtleShowing(boolean should_be_showing) {
		if (turtleShowing && !should_be_showing)
			screen.removeFromPane(turtle);
		if (!turtleShowing && should_be_showing)
			screen.addToPane(turtle);
	}

	@Override
	public boolean getTurtleShowing() {
		return turtleShowing;
	}

	public void cropTurtle() {
		Rectangle crop = new Rectangle(turtle.getX(), turtle.getY(), image.getWidth(), image.getHeight());

		if (turtle.getX() < screen.getX()) {
			crop.setX(screen.getX());
			crop.setWidth(image.getWidth() - screen.getX());
		}

		if (turtle.getX() + image.getWidth() > screen.getX() + screen.getWidth()) {
			crop.setX(turtle.getX());
			crop.setWidth(screen.getX() + (screen.getWidth() - OFFSET) - (turtle.getX()));
		}

		if (turtle.getY() < screen.getY()) {
			crop.setY(screen.getY());
			crop.setHeight(image.getHeight() - screen.getY());
		}

		if (turtle.getY() + image.getHeight() > screen.getY() + screen.getHeight()) {
			crop.setY(turtle.getY());
			crop.setHeight(screen.getY() + (screen.getHeight() - OFFSET) - (turtle.getY()));
		}
		turtle.setClip(crop);
	}
	
	public ImageView getImage() {
		return turtle;
	}

}
