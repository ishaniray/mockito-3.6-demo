package mockito.demo.constructor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.withSettings;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class LibraryTest {

	private Library library;

	@Before
	public void setup() {
		library = new Library();
	}

	/*
	 * This test has been written for demonstrative purposes only. In general,
	 * having to mock constructors is an indication of standard practices not being
	 * followed during the implementation of the class under test. In such cases,
	 * preference should be given to refactoring the said class rather than
	 * attempting to mock constructors during unit testing.
	 */
	@Test
	public void testGreet() {

		try (MockedConstruction<Greeting> mockConstructionGreeting = Mockito.mockConstruction(Greeting.class,
				withSettings().defaultAnswer(new Answer<Object>() {
					@Override
					public Object answer(InvocationOnMock invocation) throws Throwable {
						// May customize the value returned depending upon the method called on the mock
						if ("greet".equals(invocation.getMethod().getName())) {
							return "Hello, Earth!";
						}
						if ("someMethod".equals(invocation.getMethod().getName())) {
							return "Not some value.";
						}
						return null;
					}
				}))) {

			assertEquals("Hello, Earth!", library.greet("World"));
			assertEquals("Not some value.", library.someMethod());
			assertNull(library.someOtherMethod());
		}
	}
}
