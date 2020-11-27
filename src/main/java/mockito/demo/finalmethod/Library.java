package mockito.demo.finalmethod;

public class Library {

	private String hello = "Hello!";

	public final String greet() {
		return hello;
	}
}
