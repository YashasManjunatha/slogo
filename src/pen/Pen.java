package pen;

import javafx.scene.Group;
import javafx.scene.shape.Line;

/**
 * Obsolete Method
 * Now draw lines directly on canvas in Turtle Object
 *
 */
public class Pen {
	private Group lines;
	private String color;
	
	/**
	 * Creates and intializes new instance of Pen
	 */
	public Pen() {
		lines = new Group();
		color = "black";
	}
	
	/**
	 * Draws a line with the pen
	 * @param startX starting x position
	 * @param startY starting y position
	 * @param endX end x
	 * @param endY end y
	 */
	public void draw(double startX, double startY, double endX, double endY) {
		Line line = new Line();
		line.setStartX(startX);
		line.setStartY(startY);
		line.setEndX(endX);
		line.setEndY(endY);
		System.out.println(color);
		line.setStrokeWidth(3);
		line.setStyle("-fx-stroke: " + color + ";");
		lines.getChildren().add(line);		
	}
	
	/**
	 * @return all the lines drawn by the pen
	 */
	public Group getPen() {
		return lines;
	}
	
	/**
	 * Changes the pen's color
	 * @param pencolor new pen color
	 */
	public void changeColor(String pencolor) {
		color = pencolor;
	}
	
	/**
	 * Empties the pen
	 */
	public void emptyPen() {
		lines.getChildren().clear();
	}
}
