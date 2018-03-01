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
	private ImageView turtle = new ImageView();
	private boolean turtleShowing;
	private Pen pen;
	private boolean penShowing;
	private static final double startingX = 300;
	private static final double startingY = 187.5;
	private double currentX;
	private double currentY;

	public Turtle(ScreenBox turtle_screen, Image turtle_image) {
		screen = turtle_screen;
		image = turtle_image;
		initalizeTurtle();

	}

	private void initalizeTurtle() {
		turtle.setImage(image);
		currentX = startingX;
		currentY = startingY;
		System.out.println("startingY = " + startingY);
		turtle.setX(startingX);
		turtle.setY(startingY);
		scaleTurtle();
		turtleShowing = true;
		screen.addToPane(turtle);
		pen = new Pen();
		screen.addToPane(pen.getPen());
		penShowing = true;
		cropTurtle();

	}

	private void scaleTurtle() {
		double imageRatio = image.getWidth() / image.getHeight();
		System.out.println(imageRatio);
		turtle.setFitHeight(50);
		turtle.setFitWidth(50 * imageRatio);
		turtle.setPreserveRatio(true);
		System.out.println(turtle.getX());

	}

	@Override
	public double move(double moveLength) {
		double degrees = this.getOrientation() % 360;
		if (degrees < 0) {
			degrees = 360 + degrees;
		}
		
		double prevX = currentX;
		double prevY = currentY;
		
		double radians = Math.toRadians(degrees);

		
		turtle.setY(turtle.getY() - moveLength * Math.cos(radians));
		currentY = currentY - moveLength * Math.cos(radians);
		
		turtle.setX(turtle.getX() + moveLength * Math.sin(radians));
		currentX = currentX + moveLength * Math.sin(radians);
		
		if (penShowing)
			pen.draw(prevX + image.getWidth()/2, prevY + image.getHeight()/2, currentX + image.getWidth()/2, currentY + image.getHeight()/2);

		cropTurtle();
		return moveLength;

	}

	@Override
	public double turn(double degrees) {
		turtle.setRotate(turtle.getRotate() + degrees);
		cropTurtle();
		return degrees;
	}

	@Override
	public double getX() {
		return turtle.getX() - startingX;
	}

	@Override
	public double getY() {
		return turtle.getY() - startingY;
	}

	@Override
	public double getOrientation() {
		return turtle.getRotate();
	}

	@Override
	public void setPenDown(boolean penDown) {

		if (penShowing && !penDown)
			penShowing = false;
		if (!penShowing && penDown)
			penShowing = true;
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

	public void cropTurtle() {
		Rectangle crop = new Rectangle(turtle.getX(), turtle.getY(), image.getWidth(), image.getHeight());

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

	@Override
	public void moveTo(double x, double y) {
		System.out.println("x + startingX = " + (x + currentX));
		System.out.println("y + startingY = " + (y + currentY));
		System.out.println("startingX" + currentX);
		System.out.println("startingY" + currentY);
		
		if (penShowing)
			pen.draw(currentX, currentY, currentX + x, currentY + y);
		
		turtle.setX(x + startingX);
		turtle.setY(y + startingY);
		currentX = x + currentX;
		currentY = y + currentY;
		
		cropTurtle();
	}
	

}
