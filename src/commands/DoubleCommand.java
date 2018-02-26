package commands;

import java.util.List;

public class DoubleCommand extends Command {
	int numberOfInputs=0;
	double number;
	public DoubleCommand() {
		super();
		// TODO Auto-generated constructor stub
	}

   @Override
   public double execute(List<CommandNode> children ){
	   //how to get the double value?
	 
	   return number;
   }

   @Override
	public int getNumberOfParameters() {
		return numberOfInputs;
	}

}
