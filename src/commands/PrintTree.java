package commands;

import java.util.HashMap;
import java.util.Map;

public class PrintTree {

	public static void main(String[] args) {
		Map<String, Double> test = new HashMap<>();
		Parser myParser = new Parser(test);
		String commands1 = "Make :x 50 bk :x";
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
