package Turtle;

import GUIBoxes.ScreenBox;
import Pen.Pen;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;


public class Turtle implements TurtleInterface{
    
	private final static double fixedImageHeight = 50;
    
	private ScreenBox screen;
	private Image image;
	private ImageView turtle = new ImageView();
	private boolean turtleShowing;
	private Pen pen;
	private boolean penShowing;
	
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

	public double move(double moveLength) {
		double degrees = this.getOrientation()%360;
		double radians = Math.toRadians(degrees);
		if (degrees <= 90 || degrees >= 270) {
			turtle.setY(getY() + moveLength * Math.cos(radians));
		}
		else if ((degrees >= 90 && degrees <= 270)) {
			turtle.setY(getY() - moveLength * Math.cos(radians));
		}
		
		if (degrees >= 0 && degrees <= 180) {
			turtle.setX(getX() - moveLength * Math.sin(radians));
		}
		else if ((degrees >= 180 && degrees <= 360)) {
			turtle.setX(getX() + moveLength * Math.sin(radians));
		}
		
		cropTurtle();
		return moveLength;
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

		Node pane;
		if (turtle.getX() < screen.getX()) {
			crop.setX(screen.getX());
			crop.setWidth(image.getWidth() - screen.getX());
		}

		if (turtle.getX() + image.getWidth() > screen.getX() + 650) {
			crop.setX(turtle.getX());
			crop.setWidth(screen.getX() + 625 - (turtle.getX()));
		}

		if (turtle.getY() < screen.getY()) {
			crop.setY(screen.getY());
			crop.setHeight(image.getHeight() - screen.getY());
		}

		if (turtle.getY() + image.getHeight() > screen.getY() + 425) {
			crop.setY(turtle.getY());
			crop.setHeight(screen.getY() + 400 - (turtle.getY()));
		}
		turtle.setClip(crop);
	}
	
	public ImageView getImage() {
		return turtle;
	}

}
