package commands;

public class ParsedDouble extends Command{
	private double myDouble;
	private String myText;
	private Parser myParser;
	
	
	@Override
	public double execute(List<CommandNode> children) {
//		myParser.parse(myText);
		return myDouble;
	}
	@Override
	public int getNumberOfParameters() {
		return 0;
	}
	
}
