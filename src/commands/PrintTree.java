package commands;

public class PrintTree {

	public static void main(String[] args) {
		Parser myParser = new Parser();
		String commands1 = "fd 50";
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
