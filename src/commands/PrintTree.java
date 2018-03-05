package commands;

import java.util.HashMap;
import java.util.Map;

public class PrintTree {

	public static void main(String[] args) {
		Map<String, Double> test = new HashMap<>();
		Parser myParser = new Parser(test);
		String commands1 = "repeat 4 "+ "\n" + "[ fd 50 rt 90 ]";
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
