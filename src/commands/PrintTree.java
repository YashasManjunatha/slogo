package commands;

public class PrintTree {

	public static void main(String[] args) {
		Parser myParser = new Parser();
		String commands1 = "repeat 4 [ fd 5 ] bk 10";
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
