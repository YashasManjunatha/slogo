package GUIBoxes;

import java.util.List;

import Turtle.Turtle;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

public class ScreenBox implements GUIBoxes{

	private Canvas turtleScreen;
	private Pane thisPane;
	private GraphicsContext gc;
	private List<Turtle> mainTurtleList;
	private Color thisBackgroundColor;
	private Color thisPenColor = Color.BLACK;
	

	public ScreenBox(Pane pane, double[] properties, List<Turtle> turtleList) {
		turtleScreen = new Canvas();
		thisPane = pane;
		mainTurtleList = turtleList;
		setupProperties(properties[0], properties[1], properties[2], properties[3]);
		thisPane.getChildren().add(turtleScreen);
		

	}

	private void setupProperties(double xPos, double yPos, double width, double height) {

		/**
		 * final Canvas canvas = new Canvas(); canvas.setLayoutX(25);
		 * canvas.setLayoutY(25); canvas.setWidth(650); canvas.setHeight(425);
		 * GraphicsContext gc = canvas.getGraphicsContext2D(); gc.setFill(Color.BLUE);
		 * gc.fillRect(0, 0, 650, 425); gc.drawImage(image, 300, 300);
		 * gc.setFill(Color.BLUE); gc.fillRect(0, 0, 650, 425);
		 */

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

	public void changeBackgroundColor(Color color) {
		thisBackgroundColor = color;
		updateBox();
	}

	public void changePenColor(Color color) {
		thisPenColor = color;
		gc.setStroke(thisPenColor);

	}


	public double getX() {
		return turtleScreen.getLayoutX();
	}
	
	public double getHeight() {
		return turtleScreen.getHeight();
	}
	
	public double getWidth() {
		return turtleScreen.getWidth();
	}


	public double getY() {
		return turtleScreen.getLayoutY();
	}



	public void addTurtleToCanvas(Image turtle, double xPos, double yPos) {
		System.out.println("drawing turtle to canvas");
		gc.drawImage(turtle, xPos, yPos);

	}

	@Override
	public void updateBox() {
		gc.setFill(thisBackgroundColor);
		gc.fillRect(0, 0, 650, 425);
		
		for (Turtle t : mainTurtleList) {

			drawLine(t);

			gc.save();
			rotate(gc, t.getOrientation(), t.getX() + t.getImage().getWidth() / 2,
					t.getY() + t.getImage().getHeight() / 2);
			if (t.getTurtleShowing()) {
				addTurtleToCanvas(t.getImage(), t.getX(), t.getY());
			}
			gc.restore();
		}

	}

	private void drawLine(Turtle t) {
				
		for (int i = 0; i < t.getPaths().size(); i++) {
			List<Double[]> path = t.getPaths();
			List<Color> colors = t.getPenColors();
			System.out.println("DRAWING");
			changePenColor(colors.get(i));
			gc.strokeLine(path.get(i)[0] + t.getImage().getWidth() / 2, path.get(i)[1] + t.getImage().getHeight() / 2,
					path.get(i)[2] + t.getImage().getWidth() / 2, path.get(i)[3] + t.getImage().getHeight() / 2);
		}

	}

	private void rotate(GraphicsContext gc, double angle, double x, double y) {
		Rotate r = new Rotate(angle, x, y);
		gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
	}
	
	public Color getPenColor() {
		return thisPenColor;
	}
	
	public Canvas getCanvas() {
		return turtleScreen;
	}

	

}
