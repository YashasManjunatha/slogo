package commands;

public class InvalidCommandException extends Exception {
	/**
	 * default for serialization
	 */
	private static final long serialVersionUID = 1L;
	

	InvalidCommandException(String invalidCommand){
		super(String.format(invalidCommand));
		
	}
}
