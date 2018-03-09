package commands;

import java.util.HashMap;
import java.util.Map;

public class PrintTree {

	public static void main(String[] args) {
		String lang = "English";
		Map<String, Double> test = new HashMap<>();
		Map<String, Command> test2 = new HashMap<>();
		Parser myParser = new Parser(test, test2, lang);
		String commands1 = "if greater\\? 5 10 fd 50";
		CommandNode superNode;
		try {
			superNode = myParser.parse(commands1);
			superNode.printTree();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		

	}

}
