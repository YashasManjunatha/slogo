package pen;

import javafx.scene.Group;
import javafx.scene.shape.Line;

public class Pen {
	private Group lines;
	private String color = "black";
	
	public Pen() {
		lines = new Group();
	}
	
	public void draw(double startX, double startY, double endX, double endY) {
		Line line = new Line();
		line.setStartX(startX);
		line.setStartY(startY);
		line.setEndX(endX);
		line.setEndY(endY);
		System.out.println(color);
		line.setStyle("-fx-background-color: " + color + ";");
		lines.getChildren().add(line);		
	}
	
	public Group getPen() {
		return lines;
	}
	
	public void changeColor(String pencolor) {
		color = pencolor;
	}
}
