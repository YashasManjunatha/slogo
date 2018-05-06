package Turtle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import GUIBoxes.ErrorBox;
import GUIBoxes.ScreenBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * Turtle Object with Implementations for Interacting with the Turtle
 *
 */
public class Turtle implements TurtleInterface {

	private boolean active;
	private int id = 1;
	private ScreenBox screen;
	private Image image;
	private boolean turtleShowing;
	// private Pen pen;
	private boolean penShowing;
	private double startingX;
	private double startingY;
	private double orientation = 0;
	private double xPos;
	private double yPos;
	private double xPosRelative;
	private double yPosRelative;
	private double prevXPos;
	private double prevYPos;
	private double penThickness;

	private Map<ImageView, Double> stampList = new HashMap<>();
	private List<Double[]> pathList = new ArrayList<>();

	private List<Color> penColorList = new ArrayList<>();

	private List<Double> orientationList = new ArrayList<>();

	private List<Image> imageList = new ArrayList<>();

	private Color[] penColors = { Color.WHITE, Color.BLACK, Color.RED, Color.DARKGREEN, Color.BLUE, Color.YELLOW,
			Color.PURPLE, Color.ORANGE };

	/**
	 * Creates and Initialized a new Turtle
	 * 
	 * @param turtle_screen
	 *            the screen the turtle is displayed
	 * @param turtle_image
	 *            image used for the turtle
	 */
	public Turtle(ScreenBox turtle_screen, Image turtle_image) {
		screen = turtle_screen;
		image = turtle_image;
		imageList.add(image);
		initalizeTurtle();
	}

	public Turtle() {

	}

	/**
	 * Initializes the turtle
	 */
	private void initalizeTurtle() {
		// scaleImage();
		active = true;
		turtleShowing = true;
		startingX = screen.getWidth() / 2;
		startingY = screen.getHeight() / 2;
		xPos = startingX;
		yPos = startingY;
		prevXPos = startingX;
		prevYPos = startingY;
		penThickness = 3.0;
		screen.addTurtleToCanvas(image, xPos, yPos);
		// pen = new Pen();
		penShowing = true;

		orientationList.add((double) 0);
		Double[] firstPath = { startingX, startingY, startingX, startingY };
		pathList.add(firstPath);
		penColorList.add(Color.BLACK);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Turtle.TurtleInterface#move(double)
	 */
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

		xPosRelative = xPosRelative + moveLength * Math.sin(radians);
		yPosRelative = yPosRelative + moveLength * Math.cos(radians);

		checkOffScreenAndDraw();

		screen.updateBox();

		return moveLength;

	}
    void setX(double x) {
    	xPos = x;
    }
    void setY(double y) {
    	yPos =y;
    }
    void setO(double or) {
    	orientation =or;
    }
    
	/**
	 * Makes screen toroidal
	 */
	private void checkOffScreenAndDraw() {
		boolean offScreen = false;
		double orgXPos = xPos, orgYPos = yPos;
		double tempXPos = prevXPos, tempYPos = prevYPos;
		if (yPos < 0) {
			offScreen = true;
			while (yPos < 0) {
				yPos += screen.getHeight();
				tempYPos = tempYPos + screen.getHeight();
			}
		}
		if (yPos > screen.getHeight()) {
			offScreen = true;
			while (yPos > screen.getHeight()) {
				yPos -= screen.getHeight();
				tempYPos = tempYPos - screen.getHeight();
			}
		}
		if (xPos < 0) {
			offScreen = true;
			while (xPos < 0) {
				xPos += screen.getWidth();
				tempXPos += screen.getWidth();
			}
		}
		if (xPos > screen.getWidth()) {
			offScreen = true;
			while (xPos > screen.getWidth()) {
				xPos -= screen.getWidth();
				tempXPos -= screen.getWidth();
			}
		}
		if (!offScreen) {
			addPath(prevXPos, prevYPos, xPos, yPos);
		} else {
			addPath(prevXPos, prevYPos, orgXPos, orgYPos);
			addPath(tempXPos, tempYPos, xPos, yPos);
		}
	}

	/**
	 * Draws a path using the pen
	 * 
	 * @param prevXPos
	 *            previous x position
	 * @param prevYPos
	 *            previous y position
	 * @param xPos
	 *            current x position
	 * @param yPos
	 *            current y position
	 */
	private void addPath(double prevXPos, double prevYPos, double xPos, double yPos) {

		if (penShowing) {
			Double[] newPath = { prevXPos, prevYPos, xPos, yPos };
			pathList.add(newPath);
			penColorList.add(screen.getPenColor());
			orientationList.add(orientation);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Turtle.TurtleInterface#turn(double)
	 */
	@Override
	public double turn(double degrees) {

		orientation = orientation + degrees;

		Double[] newPath = { prevXPos, prevYPos, xPos, yPos };
		pathList.add(newPath);
		penColorList.add(screen.getPenColor());
		orientationList.add(orientation);

		screen.updateBox();

		return degrees;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Turtle.TurtleInterface#getX()
	 */
	@Override
	public double getX() {
		return xPos;
	}

	public double getRelativeX() {
		return xPosRelative % screen.getWidth();
	}

	public double getStartingX() {
		return startingX;
	}

	public double getStartingY() {
		return startingY;
	}

	/**
	 * @return the path list of the pen
	 */
	public List<Double[]> getPaths() {
		return pathList;
	}

	/**
	 * @return pen color list
	 */
	public List<Color> getPenColors() {
		return penColorList;
	}

	/**
	 * @return previous x position
	 */
	public double getPrevX() {
		return prevXPos;
	}

	/**
	 * @return previous y position
	 */
	public double getPrevY() {
		return prevYPos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Turtle.TurtleInterface#getY()
	 */
	@Override
	public double getY() {
		return yPos;
	}

	public double getRelativeY() {
		return yPosRelative % screen.getHeight();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Turtle.TurtleInterface#getOrientation()
	 */
	@Override
	public double getOrientation() {
		return orientation % 360;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Turtle.TurtleInterface#setPenDown(boolean)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see Turtle.TurtleInterface#getPenDown()
	 */
	@Override
	public boolean getPenDown() {
		return penShowing;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Turtle.TurtleInterface#setTurtleShowing(boolean)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see Turtle.TurtleInterface#getTurtleShowing()
	 */
	@Override
	public boolean getTurtleShowing() {
		return turtleShowing;
	}

	/**
	 * @return Image of the turtle
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * Changes the pen color
	 * 
	 * @param color
	 *            new pen color
	 */
	public void changePenColor(Color color) {
		screen.changePenColor(color);
	}

	public void changePenColorIndex(int index) {
		try {
			screen.changePenColor(penColors[index]);
		} catch (Exception e) {
			new ErrorBox("Color Index out of Bounds", "Please Choose a Number Between 0 and 7");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Turtle.TurtleInterface#moveTo(double, double)
	 */
	@Override
	public double moveTo(double x, double y) {

		prevXPos = xPos;
		prevYPos = yPos;
		xPos = x + startingX;
		yPos = y + startingY;

		checkOffScreenAndDraw();

		screen.updateBox();

		return Math.sqrt(x * x + y * y);
	}

	/**
	 * Clears the pen and returns turtle to home
	 * 
	 * @return distance moved
	 */
	public double clearScreen() {
		double dist = this.moveTo(0, 0);
		xPos = startingX;
		yPos = startingY;
		orientation = 0;
		pathList.clear();
		screen.updateBox();
		return dist;
	}

	/**
	 * Changes the image of the turtle
	 * 
	 * @param fileName
	 *            new file to be used for image
	 */
	public void changeImage(String fileName) {

		imageList.add(image);

		try {
			image = new Image(new FileInputStream(fileName), 0, 50, true, false);
			screen.updateBox();
		} catch (FileNotFoundException e) {
			new ErrorBox("Invalid Image", "Please Choose a Valid Image");
		}

	}

	/**
	 * @return the turtle's id
	 */
	public int getID() {
		return this.id;
	}

	/**
	 * @return whether the turtle is active
	 */
	public boolean getActive() {
		return this.active;
	}

	/**
	 * Undoes a move
	 */
	public void undoMove() {

		try {
			if (!pathList.isEmpty()) {
				pathList.remove(pathList.get(pathList.size() - 1));
				orientationList.remove(orientationList.size() - 1);
				orientation = orientationList.get(orientationList.size() - 1);
				xPos = pathList.get(pathList.size() - 1)[2];
				yPos = pathList.get(pathList.size() - 1)[3];

				screen.updateBox();
			}

			else {
				xPos = startingX;
				yPos = startingY;
				orientation = 0;
				screen.updateBox();

			}
		} catch (Exception e) {
			new ErrorBox("No More Previous Commands", "Please Stop Pressing Undo");
		}

	}

	/**
	 * 
	 * @return returns pen thickness
	 */
	public double getPenThickness() {

		return penThickness;
	}

	/**
	 * sets the thickness of the pen to index
	 * 
	 * @param index
	 */
	public void setPenThickness(double index) {
		penThickness = index;
	}

	/**
	 * calls screen.updateBox which refreshes the screen
	 */
	public void updateOnScreen() {
		screen.updateBox();

	}

	/**
	 * 
	 * @return returns whether the turtle is active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * 
	 * @return returns list of current turtles
	 */
	public List<Turtle> getTurtleFriends() {
		return screen.getTurtleFriends();
	}
	
	public void setActiveBoolean (boolean b) {
		active = b;
		screen.updateBox();
	}

	/**
	 * sets current turtle to active
	 */
	public void setActive() {
		active = true;
	}

	/**
	 * sets current turtle to inactive
	 */
	public void setInactive() {
		active = false;
	}

	/**
	 * adds a new turtle to the screen
	 * 
	 * @param x
	 *            - number of turtles that will be added
	 */
	public void addFriends(Double x) {
		for (int i = 0; i < x; i++) {
			Turtle newTurtle = new Turtle(screen, image);
			newTurtle.setID(screen.getTurtleFriends().size() + 1);
			screen.getTurtleFriends().add(newTurtle);
		}
	}
    public void addTurtle() {
    	Turtle newTurtle = new Turtle(screen, image);
    	newTurtle.setID(id);
    	
    	newTurtle.setActive();
    	newTurtle.setX(this.xPos);
    	newTurtle.setY(this.yPos);
    	newTurtle.setO(this.orientation);
    	screen.getStampList().add(newTurtle);
    	screen.updateBox();
    }
    public double clearStamps() {
        return screen.clearStamps();
    }
	/**
	 * sets ID of current turtle
	 * @param newID
	 */
	public void setID(int newID) {
		id = newID;
	}

	public void stamp() {
	    double xPos = this.getX();
	    double yPos = this.getY();
	    screen.addTurtleToCanvas(this.getImage(), xPos, yPos);
	    ImageView stampImageView = new ImageView(this.getImage());
	    stampImageView.setX(xPos);
	    stampImageView.setY(yPos);
	    stampList.put(stampImageView, this.getOrientation());
	}
	
	public Map<ImageView, Double> getStampMap(){
	    return this.stampList;
	}
	
	public void removeStamps() {
	    this.stampList.clear();
	    screen.updateBox();
	}
}
