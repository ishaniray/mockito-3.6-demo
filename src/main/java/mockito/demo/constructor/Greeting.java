package mockito.demo.constructor;

public class Greeting {

	private String greetText;

	private String name;

	private String someValue = "Some value.";

	private String someOtherValue = "Some other value.";

	public Greeting(String greetText, String name) {
		this.greetText = greetText;
		this.name = name;
	}

	public Greeting() {
		// Defaults
		this.greetText = "Good morning";
		this.name = "Kolkata";
	}

	public String greet() {
		return String.format("%s, %s!", greetText, name);
	}

	public String someMethod() {
		return someValue;
	}

	public String someOtherMethod() {
		return someOtherValue;
	}
}
