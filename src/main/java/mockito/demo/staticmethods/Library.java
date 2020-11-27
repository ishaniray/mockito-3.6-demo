package mockito.demo.staticmethods;

public class Library {

	private static String hello = "Hello!";

	private Library() {

	}

	public static boolean staticBooleanMethod() {
		return true;
	}

	public static String staticStringMethod() {
		return hello;
	}
}
