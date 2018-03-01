package pen;

import javafx.scene.Group;
import javafx.scene.shape.Line;

public class Pen {
	private Group lines;
	private String color;
	
	public Pen() {
		lines = new Group();
		color = "black";
	}
	
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
	
	public Group getPen() {
		return lines;
	}
	
	public void changeColor(String pencolor) {
		color = pencolor;
	}
}
