package Turtle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import GUIBoxes.ErrorBox;
import GUIBoxes.ScreenBox;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import pen.Pen;

public class Turtle implements TurtleInterface {

	private ScreenBox screen;
	private Image image;
	private boolean turtleShowing;
	private Pen pen;
	private boolean penShowing;
	private double startingX;
	private double startingY;
	private double orientation = 0;
	private double xPos;
	private double yPos;
	private double prevXPos;
	private double prevYPos;
	private Map<double[], Color> pathList = new HashMap<>();
	
	private ArrayList<Double> orientationList = new ArrayList<>();
	
	private ArrayList<Image> imageList = new ArrayList<>();


	public Turtle(ScreenBox turtle_screen, Image turtle_image) {
		screen = turtle_screen;
		image = turtle_image;
		imageList.add(image);
		initalizeTurtle();
	}

	private void initalizeTurtle() {
		// scaleImage();
		turtleShowing = true;
		startingX = screen.getWidth()/2;
		startingY = screen.getHeight()/2;
		xPos = startingX;
		yPos = startingY;
		prevXPos = startingX;
		prevYPos = startingY;
		screen.addTurtleToCanvas(image, xPos, yPos);
		pen = new Pen();
		penShowing = true;
		orientationList.add((double) 0);

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
		
		orientationList.add(orientation);
		
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
		
		System.out.println(pathList);

		prevXPos = xPos;
		prevYPos = yPos;
		xPos = x + startingX;
		yPos = y + startingY;

		addPath(prevXPos, prevYPos, xPos, yPos);

		System.out.println(pathList);

		
		screen.updateBox();

		return Math.sqrt(x * x + y * y);
	}

	public double clearScreen() {
		double dist = this.moveTo(0, 0);
		orientation = 0;
		pathList.clear();
		screen.updateBox();
		return dist;
	}

	public void changeImage(String fileName) {
		
		imageList.add(image);
		
		try {
			image = new Image(new FileInputStream(fileName), 0, 50, true, false);
			screen.updateBox();
		} catch (FileNotFoundException e) {
			new ErrorBox("Invalid Image", "Please Choose a Valid Image");
		}
		
		
	}
	
	public void redoMove() {
		System.out.println(pathList);
		if (pathList.keySet().size() > 0) {
			double[] getKey = {prevXPos, prevYPos, xPos, yPos};
			pathList.remove(getKey);
			System.out.println("oList " + orientationList);
			orientation = orientationList.get(orientationList.size()-1);
			image = imageList.get(imageList.size()-1);
			screen.updateBox();
		}
		else {
			xPos = startingX;
			yPos = startingY;
			orientation = 0;
			screen.updateBox();
		}
	}
}
