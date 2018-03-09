package Turtle;

/**
 * Public Interface for the Turtle
 * Allows the back end commands to alter the state of the turtle and it's properties.
 *
 */
interface TurtleInterface {

	/**
	 * Moves turtle in the y direction a certain length.
	 * @param movementLength length to be moved in y direction
	 * @return length moved
	 */
	public double move(double movementLength);
    /**
     * Turns the turtle
     * @param degrees how much to turn the turtle in degrees
     * @return how much the turtle was turned
     */
    public double turn(double degrees);
    /**
     * @return x position of turtle
     */
    public double getX();
    /**
     * @return y position of turtle
     */
    public double getY();
    /**
     * @return orientation of turtle
     */
    public double getOrientation();
    /**
     * Sets the pen down or up
     * @param penDown whether the pen should be down
     */
    public void setPenDown(boolean penDown);
    /**
     * @return whether the pen is down
     */
    public boolean getPenDown();
    /**
     * Sets the turtle showing
     * @param showing whether the turtle should be showing
     */
    public void setTurtleShowing(boolean showing);
    /**
     * @return whether the turtle is showing
     */
    public boolean getTurtleShowing();
	/**
	 * Moves the turtle to a location on the screen
	 * @param x x position of where it should be moved
	 * @param y y position of where it should be moved
	 * @return how much the turtle moved
	 */
	public double moveTo(double x, double y);

}
