package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.AbsoluteAdd;

public class AbsoluteAddTest {
	AbsoluteAdd asoluteAddObject;

	@Before
	public void setUp() throws Exception {
		asoluteAddObject = new AbsoluteAdd();
	}

	@After
	public void tearDown() throws Exception {
		asoluteAddObject = null;
	}

	@Test
	public void testXAdd() {
		assertEquals(8,asoluteAddObject.xAdd(3, 5));
		assertEquals(8,asoluteAddObject.xAdd(-3, -5));
		assertEquals(8,asoluteAddObject.xAdd(-3, 5));
		assertEquals(8,asoluteAddObject.xAdd(3, -5));
		
	}

}
