package mockito.demo.staticmethods;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;

/* Recommended if static methods are to be stubbed in all test scenarios */
public class LibraryTest {

	private AutoCloseable closeable;

	@Mock // may or may not prefer to use annotation
	private MockedStatic<Library> mockStaticLibrary;

	@Before
	public void openMocks() {
		closeable = MockitoAnnotations.openMocks(this); // if @Mock annotation is used
		/*
		 * If @Mock annotation is not used: mockStaticLibrary =
		 * Mockito.mockStatic(Library.class);
		 */
	}

	@After
	public void releaseMocks() throws Exception {
		closeable.close(); // if MockitoAnnotations.openMocks was used in @Before
		/*
		 * If the MockedStatic object was not created with annotation:
		 * mockStaticLibrary.closeOnDemand();
		 */
	}

	@Test
	public void testStaticMethodsWithoutStubbbing() {
		assertFalse(Library.staticBooleanMethod());
		assertNull(Library.staticStringMethod());
	}

	@Test
	public void testStaticMethodsWithStubbbing() {
		mockStaticLibrary.when(() -> Library.staticBooleanMethod()).thenReturn(true);
		mockStaticLibrary.when(() -> Library.staticStringMethod()).thenReturn("Hello!");

		assertTrue(Library.staticBooleanMethod());
		assertEquals("Hello!", Library.staticStringMethod());
	}
}
