package commands;

import java.util.List;

public class MakeUserInstruction extends Command{
	private String myCommandText;
	private List<String> myParameters;
	public MakeUserInstruction(List<String> parameters, String commands) {
		myCommandText = commands;
		myParameters = parameters;
	}
		
	public String getInstructionText(List<String> paramValues) {
		String paramsInserted = myCommandText;
		for (int x=0; x<paramValues.size(); x++) {
			paramsInserted = paramsInserted.replaceAll(myParameters.get(x), paramValues.get(x));
		}
		return paramsInserted;
	}
	@Override 
	public int getNumberOfParameters() {
		return  myParameters.size();
	

	}


	@Override
	public String toString() {
		return myCommandText;
	}

}
