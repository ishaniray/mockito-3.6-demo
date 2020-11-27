package mockito.demo.staticmethods;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

/* Recommended if static methods are to be stubbed in certain scenarios only. */
public class LibraryTestWithTryWithResources {

	@Test
	public void testStaticMethods() {

		assertTrue(Library.staticBooleanMethod());
		assertEquals("Hello!", Library.staticStringMethod());

		/*
		 * By declaring it within a try-with-resources block, the MockedStatic object
		 * will be automatically closed, since AutoCloseable is its superinterface.
		 */
		try (MockedStatic<Library> mockStaticLibrary = Mockito.mockStatic(Library.class)) {

			mockStaticLibrary.when(() -> Library.staticBooleanMethod()).thenReturn(false);
			mockStaticLibrary.when(Library::staticStringMethod).thenReturn("World!");

			assertFalse(Library.staticBooleanMethod());
			assertEquals("World!", Library.staticStringMethod());
		}

		assertTrue(Library.staticBooleanMethod());
		assertEquals("Hello!", Library.staticStringMethod());
	}
}
