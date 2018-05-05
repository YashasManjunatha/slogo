package GUIBoxes;

import java.util.ArrayList;
import java.util.List;

import Turtle.Turtle;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

/**
 * implements GUIBoxes - screenbox which displays all the turtles
 * 
 * @author Calvin Ma
 *
 */
public class ScreenBox implements GUIBoxes {

	private Canvas turtleScreen;
	private Pane thisPane;
	private GraphicsContext gc;
	private List<Turtle> mainTurtleList;
	private List<Turtle> stampList = new ArrayList<>();
	private Color thisBackgroundColor;
	private Color thisPenColor = Color.BLACK;

	/**
	 * Constructor for screenbox
	 * 
	 * @param pane
	 *            - needs pane so that Canvas can be added to Pane
	 * @param properties
	 *            - properties of the canvas/screenbox
	 * @param turtleList
	 *            - needs all the turtles for updating the screen
	 */
	public ScreenBox(Pane pane, double[] properties, List<Turtle> turtleList) {
		turtleScreen = new Canvas();
		thisPane = pane;
		mainTurtleList = turtleList;
		setupProperties(properties[0], properties[1], properties[2], properties[3]);
		thisPane.getChildren().add(turtleScreen);

	}

	/**
	 * Sets up the properties of the canvas
	 * 
	 * @param xPos
	 *            - x position of canvas
	 * @param yPos
	 *            - y position of canvas
	 * @param width
	 *            - width of canvas
	 * @param height
	 *            - height of canvas
	 */
	private void setupProperties(double xPos, double yPos, double width, double height) {

		turtleScreen.setLayoutX(xPos);
		turtleScreen.setLayoutY(yPos);
		turtleScreen.setWidth(width);
		turtleScreen.setHeight(height);
		gc = turtleScreen.getGraphicsContext2D();
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, 650, 425);
		gc.setLineWidth(3);
		updateBox();

	}

	/**
	 * changes background color of the canvas
	 * 
	 * @param color
	 *            - color that background is being changed to
	 */
	public void changeBackgroundColor(Color color) {
		thisBackgroundColor = color;
		updateBox();
	}

	/**
	 * gets the list of turtles
	 * @return - returns list of current turtles
	 */
	public List<Turtle> getTurtleFriends() {
		return mainTurtleList;
	}
	public List<Turtle> getStampList(){
		return stampList;
	}

	/**
	 * changes the color of the pen
	 * 
	 * @param color
	 *            - new color of pen
	 */
	public void changePenColor(Color color) {
		thisPenColor = color;
		gc.setStroke(thisPenColor);

	}

	/**
	 * gets x value of canvas
	 * 
	 * @return - x value of canvas
	 */
	public double getX() {
		return turtleScreen.getLayoutX();
	}

	/**
	 * get height of canvas
	 * 
	 * @return - height of canvas
	 */
	public double getHeight() {
		return turtleScreen.getHeight();
	}

	/**
	 * get width of canvas
	 * 
	 * @return - width of canvas
	 */
	public double getWidth() {
		return turtleScreen.getWidth();
	}

	/**
	 * get y position of canvas
	 * 
	 * @return - y position of canvas
	 */
	public double getY() {
		return turtleScreen.getLayoutY();
	}

	/**
	 * adds a turtle onto the canvas
	 * 
	 * @param turtle
	 *            - image being drawn onto canvas
	 * @param xPos
	 *            - x position of image
	 * @param yPos
	 *            - y position of image
	 */
	public void addTurtleToCanvas(Image image, double xPos, double yPos) {
		gc.drawImage(image, xPos, yPos);
		

	}

	/**
	 * this method updates the box - basically it draws over whatever is already
	 * drawn but with the updated images and properties
	 */
	@Override
	public void updateBox() {
	
		gc.setFill(thisBackgroundColor);
		gc.fillRect(0, 0, 650, 425);
		addStamps();
		for (Turtle t : mainTurtleList) {

			drawLine(t);

			Image i = t.getImage();
			ImageView iv = new ImageView(i);
			iv.setOpacity(50);

			gc.save();
			rotate(gc, t.getOrientation(), t.getX() + t.getImage().getWidth() / 2,
					t.getY() + t.getImage().getHeight() / 2);
			if (t.getTurtleShowing()) {
				if (t.isActive()) {
					addTurtleToCanvas(t.getImage(), t.getX(), t.getY());
				} else {
					addTranspTurtleToCanvas(t.getImage(), t.getX(), t.getY());
				}
			}

			gc.restore();
		}

	}
	public void addStamps() {
		if(stampList.size()!=0) {
		for(Turtle t : stampList) {
			Image i = t.getImage();
			ImageView iv = new ImageView(i);
			iv.setOpacity(50);
			gc.save();
			rotate(gc, t.getOrientation(), t.getX() + t.getImage().getWidth() / 2,
					t.getY() + t.getImage().getHeight() / 2);
				
					addTurtleToCanvas(t.getImage(), t.getX(), t.getY());
				
			

			gc.restore();
		
		 }
		}
	}
	public double clearStamps() {
		if(stampList.size()!=0) {
		stampList.clear();
		gc.save();
		return 1;
		
		}
		else { return 0;    }
	}

	/**
	 * if image is invalid, the image is slightly transparent
	 * 
	 * @param image
	 *            - image being drawn
	 * @param x
	 *            - x position of image
	 * @param y
	 *            - y position of image
	 */
	private void addTranspTurtleToCanvas(Image image, double x, double y) {

		gc.setGlobalAlpha(0.4);

		gc.drawImage(image, x, y);

		gc.setGlobalAlpha(1);

	}

	/**
	 * draws a line on the canvas depending on list of paths
	 * 
	 * @param t
	 *            - each turtle contains its own path list
	 */
	private void drawLine(Turtle t) {

		for (int i = 0; i < t.getPaths().size(); i++) {
			List<Double[]> path = t.getPaths();
			List<Color> colors = t.getPenColors();
			changePenColor(colors.get(i));
			gc.strokeLine(path.get(i)[0] + t.getImage().getWidth() / 2, path.get(i)[1] + t.getImage().getHeight() / 2,
					path.get(i)[2] + t.getImage().getWidth() / 2, path.get(i)[3] + t.getImage().getHeight() / 2);
		}

	}

	/**
	 * draws a rotated image
	 * 
	 * @param gc
	 *            - graphics context of canvas
	 * @param angle
	 *            - angle that the image is rotated
	 * @param x
	 *            - x position of image
	 * @param y
	 *            - y position of image
	 */
	private void rotate(GraphicsContext gc, double angle, double x, double y) {
		Rotate r = new Rotate(angle, x, y);
		gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
	}

	/**
	 * gets the current pen color of canvas - depends on the turtles
	 * 
	 * @return - current pen color
	 */
	public Color getPenColor() {
		return thisPenColor;
	}

}
