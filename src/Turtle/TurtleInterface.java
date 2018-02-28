package Turtle;

interface TurtleInterface {

	public double move(double movementLength);
    public double turn(double degrees);
    public double getX();
    public double getY();
    public double getOrientation();
    public void setPenDown(boolean penDown);
    public boolean getPenDown();
    public void setTurtleShowing(boolean showing);
    public boolean getTurtleShowing();
	public void moveTo(double x, double y);

}
