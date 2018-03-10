package GUIBoxes;

import Turtle.Turtle;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Object for the table of turtles for GUI.
 * Dictates the vaules for each entry in the table.
 * Provides methods to set and get the values in the table.
 *
 */
public class TurtleListInsertion {
	//private Turtle t;
	private BooleanProperty active = new SimpleBooleanProperty();
	private StringProperty id = new SimpleStringProperty();
	private StringProperty xpos = new SimpleStringProperty();
	private StringProperty ypos = new SimpleStringProperty();
	private StringProperty heading = new SimpleStringProperty();
	private BooleanProperty pen_status = new SimpleBooleanProperty();
	private StringProperty pen_color = new SimpleStringProperty();
	private StringProperty pen_thickness = new SimpleStringProperty();
	
	/**
	 * Inserts a new data entry.
	 * @param active boolean whether turtle is active
	 * @param id id of turtle
	 * @param xpos x position of turtle
	 * @param ypos y position of turtle
	 * @param heading heading of turtle
	 * @param pen whether pen is up for turtle
	 * @param pen_color pen color for turtle
	 * @param pen_thickness pen thickness for turtle
	 */
	public TurtleListInsertion(/*Turtle t, */boolean active, int id, double xpos, double ypos, double heading, boolean pen, 
			String pen_color, double pen_thickness) {
		//this.t = t;
		this.setActive(active);
		this.setId(id);
		this.setXpos(xpos);
		this.setYpos(ypos);
		this.setHeading(heading);
		this.setPenActive(pen);
		this.setPenColor(pen_color);
		this.setPenThickness(pen_thickness);
	}
	
	public BooleanProperty isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active.set(active);
		//t.setTurtleShowing(active);
	}

	public StringProperty getId() {
		return id;
	}

	public void setId(int id) {
		this.id.set(Integer.toString(id));
	}

	public StringProperty getXpos() {
		return xpos;
	}

	public void setXpos(double xpos) {
		this.xpos.set(Double.toString(xpos));
		//t.moveTo(xpos-t.getStartingX(),t.getY()-t.getStartingY());
	}

	public StringProperty getYpos() {
		return ypos;
	}

	public void setYpos(double ypos) {
		this.ypos.set(Double.toString(ypos));
		//t.moveTo(t.getX()-t.getStartingX(),ypos-t.getStartingY());
	}

	public StringProperty getHeading() {
		return heading;
	}

	public void setHeading(double heading) {
		this.heading.set(Double.toString(heading));
		//t.turn(heading-t.getOrientation());
	}

	public BooleanProperty isPenActive() {
		return pen_status;
	}

	public void setPenActive(boolean pen_status) {
		this.pen_status.set(pen_status);
		//t.setPenDown(pen_status);
	}

	public StringProperty getPenColor() {
		return pen_color;
	}

	public void setPenColor(String pen_color) {
		this.pen_color.set(pen_color);
	}

	public StringProperty getPenThickness() {
		return pen_thickness;
	}

	public void setPenThickness(double pen_thickness) {
		this.pen_thickness.set(Double.toString(pen_thickness));
	}
}
