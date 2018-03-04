package Turtle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import GUIBoxes.ScreenBox;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
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
	private double prevXPos;
	private double prevYPos;
	private Map<double[], Color> pathList = new HashMap<>();

	public Turtle(ScreenBox turtle_screen, Image turtle_image) {
		screen = turtle_screen;
		image = turtle_image;
		initalizeTurtle();
	}

	private void initalizeTurtle() {
		// scaleImage();
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

		prevXPos = xPos;
		prevYPos = yPos;

		double radians = Math.toRadians(degrees);

		xPos = xPos + moveLength * Math.sin(radians);
		yPos = yPos - moveLength * Math.cos(radians);

		addPath(prevXPos, prevYPos, xPos, yPos);

		screen.updateBox();

		System.out.println("prevXPos = " + prevXPos);
		System.out.println("prevXPos = " + prevXPos);

		// if (penShowing) {
		// screen.draw(prevX + image.getWidth() / 2, prevY + image.getHeight() / 2,
		// xPos + image.getWidth() / 2,
		// yPos + startingY + image.getHeight() / 2);
		// }

		return moveLength;

	}

	private void addPath(double prevXPos, double prevYPos, double xPos, double yPos) {

		System.out.println(prevXPos);
		System.out.println(prevYPos);
		System.out.println(xPos);
		System.out.println(yPos);
		System.out.println(pathList);
		if (penShowing) {
			double[] newPath = { prevXPos, prevYPos, xPos, yPos };
			pathList.put(newPath, screen.getPenColor());
		}
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

	public Map<double[], Color> getPaths() {
		return pathList;
	}

	public double getPrevX() {
		return prevXPos;
	}

	public double getPrevY() {
		return prevYPos;
	}

	@Override
	public double getY() {
		return yPos;
	}

	@Override
	public double getOrientation() {
		return orientation % 360;
	}

	@Override
	public void setPenDown(boolean penDown) {

		if (penShowing && !penDown) {
			// screen.removeFromPane(pen.getPen());
			penShowing = false;
		}
		if (!penShowing && penDown) {
			// screen.addToPane(pen.getPen());
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
			turtleShowing = false;
		}
		if (!turtleShowing && should_be_showing) {
			turtleShowing = true;
		}
		screen.updateBox();
	}

	@Override
	public boolean getTurtleShowing() {
		return turtleShowing;
	}

	public Image getImage() {
		return image;
	}

	public void changePenColor(Color color) {
		screen.changePenColor(color);
	}

	@Override
	public double moveTo(double x, double y) {

		xPos = x;
		yPos = y;

		addPath(prevXPos, prevYPos, xPos, yPos);

		screen.updateBox();

		return Math.sqrt(x * x + y * y);
	}

	public double clearScreen() {
		double dist = this.moveTo(startingX, startingY);
		pathList.clear();
		screen.updateBox();
		return dist;
	}

}
