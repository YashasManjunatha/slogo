package commands;

import java.util.List;

public class MakeUserInstruction extends Command{
	private String myCommandText;
	private List<String> myParameters;
	public MakeUserInstruction(List<String> parameters, String commands) {
		myCommandText = commands;
		myParameters = parameters;
	}
		
//	public String getInstructionText(List<String> paramValues) {
//		String paramsInserted = myCommandText;
//		for (int x=0; x<paramValues.size(); x++) {
//			paramsInserted = paramsInserted.replaceAll(myParameters.get(x), paramValues.get(x));
//		}
//		return paramsInserted;
//	}
	
	public String getInstructionText(CommandNode parameters) {
		String paramsInserted = myCommandText;
		List<CommandNode> paramChildren = parameters.getChildren();
		for (int x=0; x<paramChildren.size(); x++) {
			paramsInserted = paramsInserted.replaceAll(myParameters.get(x), ""+paramChildren.get(x).execute(paramChildren.get(x).getCommand().getTurtle()));
		}
		return paramsInserted;
	}
	
	@Override
	public String toString() {
		return myCommandText;
	}
}
