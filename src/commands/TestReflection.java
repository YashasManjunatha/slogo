package commands;

public class TestReflection {

	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> clazz = Class.forName("commands.CommandNode");
		//.args.clazz.for
		System.out.println(clazz);

	}

}
