package Turtle;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Turtle implements TurtleInterface {
	
	private final static double fixedImageHeight = 50;
	
	private Pane pane;
	private Image image;
	private ImageView turtle = new ImageView();
	boolean turtleShowing;

	public Turtle(Pane display_pane, Image turtle_image) {
		pane = display_pane;
		image = turtle_image;
		initalizeTurtle();

	}

	private void initalizeTurtle() {
		turtle.setImage(image);
		turtle.setX(585 / 2);
		turtle.setY(650 / 2);
		scaleTurtle();
		cropTurtle();
		pane.getChildren().add(turtle);
		turtleShowing = true;
	}

	private void scaleTurtle() {
		double imageRatio = image.getWidth()/image.getHeight();
		turtle.setFitHeight(fixedImageHeight);
		turtle.setFitWidth(fixedImageHeight * imageRatio);
		turtle.setPreserveRatio(true);
	}

	@Override
	public void move(double diffX, double diffY) {
		turtle.setX(getX() + diffX);
		turtle.setY(getY() + diffY);
		cropTurtle();
	}

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
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getPenDown() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setTurtleShowing(boolean should_be_showing) {
		if (turtleShowing && !should_be_showing)
			pane.getChildren().remove(turtle);
		if (!turtleShowing && should_be_showing)
			pane.getChildren().add(turtle);
	}

	@Override
	public boolean getTurtleShowing() {
		return turtleShowing;
	}

	public void cropTurtle() {
		Rectangle crop = new Rectangle(turtle.getX(), turtle.getY(), image.getWidth(), image.getHeight());

		if (turtle.getX() < pane.getLayoutX()) {
			crop.setX(pane.getLayoutX());
			crop.setWidth(image.getWidth() - pane.getLayoutX());
		}

		if (turtle.getX() + image.getWidth() > pane.getLayoutX() + 650) {
			crop.setX(turtle.getX());
			crop.setWidth(pane.getLayoutX() + 625 - (turtle.getX()));
		}

		if (turtle.getY() < pane.getLayoutY()) {
			crop.setY(pane.getLayoutY());
			crop.setHeight(image.getHeight() - pane.getLayoutY());
		}

		if (turtle.getY() + image.getHeight() > pane.getLayoutY() + 425) {
			crop.setY(turtle.getY());
			crop.setHeight(pane.getLayoutY() + 400 - (turtle.getY()));
		}
		turtle.setClip(crop);
	}
	
	public ImageView getImage() {
		return turtle;
	}

}
