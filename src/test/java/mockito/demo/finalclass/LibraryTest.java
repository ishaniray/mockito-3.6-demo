package mockito.demo.finalclass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class LibraryTest {

	private AutoCloseable closeable;

	@Mock
	Library mockLibrary;

	Library realLibrary = new Library();

	@Before
	public void openMocks() {
		closeable = MockitoAnnotations.openMocks(this);
	}

	@After
	public void releaseMocks() throws Exception {
		closeable.close();
	}

	@Test
	public void testGreet() {

		when(mockLibrary.greet()).thenReturn("Hi!");

		assertNotEquals(mockLibrary.greet(), realLibrary.greet());
		assertEquals("Hi!", mockLibrary.greet());
	}
}
