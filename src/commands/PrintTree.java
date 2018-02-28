package commands;

public class PrintTree {

	public static void main(String[] args) {
		Parser myParser = new Parser();
		String commands = "SumCommand SumCommand 5 5 5";
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
