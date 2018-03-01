package commands;

public class PrintTree {

	public static void main(String[] args) {
		Parser myParser = new Parser();
		String commands1 = "repeat 4 [ fd 5 ] bk 10";
		CommandNode superNode;
		try {
			superNode = myParser.parse(commands1);
			superNode.printTree();
			for (CommandNode child: superNode.getChildren()) {
				System.out.println("hello" + child.getChildren());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		

	}

}
