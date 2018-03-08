package commands;

public abstract class ParserObject{
	
	abstract CommandNode parse(String text) throws InvalidCommandException;

}
