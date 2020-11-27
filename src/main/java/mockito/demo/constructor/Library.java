package mockito.demo.constructor;

/* Poorly-designed class.
 * Inversion of control not being practised.
 */
public class Library {

	public String greet(String name) {
		return new Greeting("Hello", name).greet();
	}

	public String someMethod() {
		return new Greeting().someMethod();
	}

	public String someOtherMethod() {
		return new Greeting().someOtherMethod();
	}
}
