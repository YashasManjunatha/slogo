package commands;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import GUIBoxes.ErrorBox;

public class ClassToMethodPropertyHandler {
	private static String classPath = "src/generateCommandMethods/classNameToMethod.properties";
	
	Method getGenerateMethod(Parser parser, String className) {
		Properties classToMethodProps = new Properties();
		try {
			FileInputStream input = new FileInputStream(classPath);
			classToMethodProps.load(input);
			// method = obj.getClass().getMethod(methodName, param1.class, param2.class;
			String methodName = classToMethodProps.getProperty(className);
			System.out.println(methodName);
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
