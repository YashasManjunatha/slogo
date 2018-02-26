package commands;

public class ParsedDouble implements CommandObject{
	private double myDouble;
	private String myText;
	private Parser myParser;
	
	ParsedDouble(double parsedDouble){
		myDouble = parsedDouble;
//		myParser = new Parser();
//		String [] splitText = text.split(" ");
//		String parsedDouble = splitText[0];
//		myDouble = Double.parseDouble(parsedDouble);
//		myText = text.replaceFirst(parsedDouble, "");
	}
	@Override
	public double execute() {
//		myParser.parse(myText);
		return myDouble;
	}
	@Override
	public int getNumberOfParameters() {
		return 0;
	}
	
}
