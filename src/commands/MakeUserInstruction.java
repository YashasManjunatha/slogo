package commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MakeUserInstruction extends Command{
	//private Map<String, Double> paramToValueMap;
	private String myCommandText;
	private List<String> myParameters;
	public MakeUserInstruction(List<String> parameters, String commands) {
//		paramToValueMap = new HashMap<>();
		myCommandText = commands;
		myParameters = parameters;
//		for (String param: parameters) {
//			System.out.println("hm "+ param);
//			paramToValueMap.put(param, null);
//			System.out.println("no");
//		}
		System.out.println("bye");
	}
	
//	@Override
//	public double execute(List<CommandNode> children, Turtle t) {
//		
//	}
	
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

}
