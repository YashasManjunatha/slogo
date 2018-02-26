package commands;

import Turtle.Turtle;

public class ForwardCommand extends Command{
     private int numberOfInputs = 1;
     
	public ForwardCommand() {
		super();
		// TODO Auto-generated constructor stub
	}

   @Override
   public double execute(){
	   return 0;
   }

   @Override
	public int getNumberOfParameters() {
		return numberOfInputs;
	}

}
