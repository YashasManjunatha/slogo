package Turtle;

import GUIBoxes.ScreenBox;
import Pen.Pen;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Turtle implements TurtleInterface{
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
        turtle.setX(650/2);
        turtle.setY(425/2);
        screen.addToPane(turtle);
        turtleShowing = true;
        pen = new Pen();
        penShowing = true;
	}

	@Override
	public void move(double diffX, double diffY) {
		turtle.setX(getX() + diffX);
		turtle.setY(getY() + diffY);
	}

	@Override
	public void turn(double degrees) {
		turtle.setRotate(turtle.getRotate() + degrees);
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
}
