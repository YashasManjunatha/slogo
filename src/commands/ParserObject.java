package commands;

public interface ParserObject{
	
	CommandNode parse(String text) throws InvalidCommandException;

}
