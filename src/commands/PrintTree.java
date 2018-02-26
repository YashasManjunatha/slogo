package commands;

public class PrintTree {

	public static void main(String[] args) {
		Parser myParser = new Parser();
		String commands = "fd 50 fd 50";
		CommandNode superNode;
		try {
			superNode = myParser.parse(commands);
			superNode.printTree();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		

	}

}
