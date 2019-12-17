package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.EclemmaDemo;

public class EclemmaDemoTest {
	EclemmaDemo ecl;
	@Before
	public void setUp() throws Exception {
		ecl = new EclemmaDemo();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCheck() {
		assertEquals("Regular",ecl.check(3, 3, 3));
	}

}
