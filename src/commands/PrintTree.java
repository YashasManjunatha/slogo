package commands;

import java.util.HashMap;
import java.util.Map;

public class PrintTree {

	public static void main(String[] args) {
		Map<String, Double> test = new HashMap<>();
		Parser myParser = new Parser(test);
		String commands1 = "for [ :x 1 5 1 ] [ fd 50 ]";
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
