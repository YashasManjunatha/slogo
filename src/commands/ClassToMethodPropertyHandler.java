package commands;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import GUIBoxes.ErrorBox;

/**
 * This class controls the classNameToMethod.properties file which indicates which method should be invoked for each particular class in order to create and instance of that command.
 * @author milestodzo
 *
 */

public class ClassToMethodPropertyHandler {
	private static String classPath = "src/generateCommandMethods/classNameToMethod.properties";
	/**
	 * Returns the method to generate the command for the particular class name
	 * @param parser
	 * @param className
	 * @return Method to be invoked to generate command
	 */
	Method getGenerateMethod(Parser parser, String className) {
		Properties classToMethodProps = new Properties();
		try {
			FileInputStream input = new FileInputStream(classPath);
			classToMethodProps.load(input);
			String methodName = classToMethodProps.getProperty(className);
			Method m = parser.getClass().getDeclaredMethod(methodName, className.getClass());
			return m;
		}
		catch(Exception e) {
			e.printStackTrace();
			new ErrorBox("Failed to generate command method", className);
		}
		return null;
	}
}
