package commands;
/**
 * This class test if the reflection written in the parser works 
 */
public class TestReflection {

	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> clazz = Class.forName("commands.CommandNode");
		//.args.clazz.for
		System.out.println(clazz);

	}

}
