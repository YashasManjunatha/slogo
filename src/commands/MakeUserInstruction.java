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
		String paramsInserted = getInstructionText(myArguments, t);
		Parser userCommandParser = new Parser(variableMap, userCommandMap, parserLanguage);
		CommandNode userCommandNode = null;
		try {
			userCommandNode = userCommandParser.parse(paramsInserted);
		} catch (InvalidCommandException e) {
			new ErrorBox("Error in executing method", myCommandText);
		}
		return userCommandNode.execute(t);
	}
	
	void setArguments(CommandNode arguments){
		myArguments = arguments;
	}
	
	public String getInstructionText(CommandNode parameters, Turtle t) {
		String paramsInserted = myCommandText;
		List<CommandNode> paramChildren = parameters.getChildren();
		for (int x=0; x<paramChildren.size(); x++) {
			paramsInserted = paramsInserted.replaceAll(myParameters.get(x), ""+paramChildren.get(x).execute(t));
		}
		return paramsInserted;
	}

	@Override
	public String toString() {
		return myCommandText;
	}

}
