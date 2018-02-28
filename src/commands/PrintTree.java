package commands;

public class PrintTree {

	public static void main(String[] args) {
//		String test = "forward|fd";
//		String [] commands = test.split("\\|");
//		System.out.println(commands[0] + " " +commands[1]);
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
