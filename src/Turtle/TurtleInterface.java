package Turtle;

interface TurtleInterface {
	public double move(double diff);
	//public void move(double diffX, double diffY);
    public void turn(double degrees);
    public double getX();
    public double getY();
    public double getOrientation();
    public void setPenDown(boolean penDown);
    public boolean getPenDown();
    public void setTurtleShowing(boolean showing);
    public boolean getTurtleShowing();
}
