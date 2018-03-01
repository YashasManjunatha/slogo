package pen;

import javafx.scene.Group;
import javafx.scene.shape.Line;

public class Pen {
	private Group lines;
	public Pen() {
		lines = new Group();
	}
	
	public void draw(double startX, double startY, double endX, double endY) {
		Line line = new Line();
		line.setStartX(startX);
		line.setStartY(startY);
		line.setEndX(endX);
		line.setEndY(endY);
		lines.getChildren().add(line);		
	}
	
	public Group getPen() {
		return lines;
	}
}
