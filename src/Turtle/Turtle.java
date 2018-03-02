package Turtle;

import GUIBoxes.ScreenBox;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import pen.Pen;

public class Turtle implements TurtleInterface {

	private final static double fixedImageHeight = 50;

	private ScreenBox screen;
	private Image image;
	private boolean turtleShowing;
	private Pen pen;
	private boolean penShowing;
	private final static double startingX = 300.0;
	private final static double startingY = 187.5;
	private double orientation = 0;
	private double xPos;
	private double yPos;

	public Turtle(ScreenBox turtle_screen, Image turtle_image) {
		screen = turtle_screen;
		image = turtle_image;
		initalizeTurtle();
	}

	private void initalizeTurtle() {
		//scaleImage();
		turtleShowing = true;
		xPos = startingX;
		yPos = startingY;
		screen.addTurtleToCanvas(image, xPos, yPos);
		pen = new Pen();
		penShowing = true;

	}


	@Override
	public double move(double moveLength) {
		double degrees = this.getOrientation() % 360;
		if (degrees < 0) {
			degrees = 360 + degrees;
		}

		double prevX = this.getX() + startingX;
		double prevY = this.getY() + startingY;

		double radians = Math.toRadians(degrees);

		xPos = xPos + moveLength * Math.sin(radians);
		yPos = yPos - moveLength * Math.cos(radians);

		screen.updateBox();
		
		if (penShowing) {
			pen.draw(prevX + image.getWidth() / 2, prevY + image.getHeight() / 2,
					this.getX() + startingX + image.getWidth() / 2,
					this.getY() + startingY + image.getHeight() / 2);
		}
		
		return moveLength;

	}

	@Override
	public double turn(double degrees) {
		orientation = orientation + degrees;

		System.out.println(orientation);
		screen.updateBox();
		return degrees;
	}

	@Override
	public double getX() {
		return xPos;
	}

	@Override
	public double getY() {
		return yPos;
	}

	@Override
	public double getOrientation() {
		return orientation%360;
	}

	@Override
	public void setPenDown(boolean penDown) {

		if (penShowing && !penDown) {
			//screen.removeFromPane(pen.getPen());
			penShowing = false;
		}
		if (!penShowing && penDown) {
			//screen.addToPane(pen.getPen());
			penShowing = true;
		}
	}

	@Override
	public boolean getPenDown() {
		return penShowing;
	}

	@Override
	public void setTurtleShowing(boolean should_be_showing) {
		if (turtleShowing && !should_be_showing) {
			screen.removeFromPane(turtle);
			turtleShowing = false;
		}
		if (!turtleShowing && should_be_showing) {
			screen.addToPane(turtle);
			turtleShowing = true;
		}
	}

	@Override
	public boolean getTurtleShowing() {
		return turtleShowing;
	}


	public Image getImage() {
		return image;
	}
	
	public void changePenColor (String color) {
		pen.changeColor(color);
	}

	@Override
	public double moveTo(double x, double y) {

		if (penShowing) {
			pen.draw(this.getX() + startingX + image.getWidth()/2,
					this.getY() + startingY + image.getHeight()/2,
					x + startingX + image.getWidth()/2,
					y + startingY + image.getHeight()/2);
		}
		
		
		
		xPos = x;
		yPos = y;

		
		return Math.sqrt(x*x + y*y);
	}

	public double clearScreen() {
		double dist = this.moveTo(0,0);
		pen.emptyPen();
		return dist;
	}
}
