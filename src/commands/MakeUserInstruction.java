package commands;

import java.util.List;
import java.util.Map;

import GUIBoxes.ErrorBox;
import Turtle.Turtle;

public class MakeUserInstruction extends Command{
	private String myCommandText;
	private List<String> myParameters;
	private CommandNode myArguments;
	private String parserLanguage;
	Map<String, Double> variableMap;
	Map<String, Command> userCommandMap;
	
	public MakeUserInstruction(List<String> parameters, String commands, CommandNode arguments, String lang, Map<String, Double> varMap,
			Map<String,Command> commandMap) {
		myCommandText = commands;
		myParameters = parameters;
		myArguments = arguments;
		parserLanguage = lang;
		variableMap = varMap;
		userCommandMap = commandMap;
	}

	@Override
	public double execute(List<CommandNode> children, Turtle t) {
		if (myArguments == null) {
			return 0;
		}
		String paramsInserted = myCommandText;
		List<CommandNode> paramChildren = myArguments.getChildren();
		for (int x=0; x<paramChildren.size(); x++) {
			paramsInserted = paramsInserted.replaceAll(myParameters.get(x), ""+paramChildren.get(x).execute(t));
		}
		Parser userCommandParser = new Parser(variableMap, userCommandMap, parserLanguage);
		CommandNode userCommandNode = null;
		try {
			userCommandNode = userCommandParser.parse(paramsInserted);
		} catch (InvalidCommandException e) {
			new ErrorBox("Error in executing method", myCommandText);
		}
		userCommandNode.execute(t);
		return 0;
	}
	
	void setArguments(CommandNode arguments){
//		MakeUserInstruction test = (MakeUserInstruction) arguments.getCommand();
//		System.out.println(test.toString());
		myArguments = arguments;
	}
	
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
