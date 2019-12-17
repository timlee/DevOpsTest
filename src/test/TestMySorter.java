package test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import main.mysorter.Sorter;

//import org.junit.Before;
public class TestMySorter extends TestCase {
    private double tc[][][] = {
		{{}, {}}, //test empty set
		{{1.0}, {1.0}}, //test single element set
		//test set with incremental order
		{{1.0, 1.1, 2.0, 2.1, 10.10, 100},
		{1.0, 1.1, 2.0, 2.1, 10.10, 100}},
		//test set with decremental order
		{{100,10.10, 2.1, 2.0, 1.1, 1.0}, 
		{1.0, 1.1, 2.0, 2.1, 10.10, 100}},
		//test set with random order
		{{2.0, 2.1, 1.1, 10.10, 100, 1.0},
		{1.0, 1.1, 2.0, 2.1, 10.10, 100}},
		//test set with odd number of elements
		{{2.0, 2.1, 1.1, 10.10, 100}, {1.1, 2.0, 2.1, 10.10, 100}},
		//test set with all integer value
		{{1}, {1}},
		{{1,2,3,4}, {1,2,3,4}},{{1,2,5,4,3}, {1,2,3,4,5}},
		//test set with negative number
		{{-1,-2,-99}, {-1,-2,-99}},{{1,2,-99}, {1,2,-99}},};	
    
     private Sorter sorter;
     public TestMySorter() { 
    	 sorter = new Sorter();
     }
     
     //@Before
     public void setup() {
    	 sorter = new Sorter();
     }
     
     public static Test suite() {
         return new TestSuite(TestMySorter.class);
      }
     
	 public void testSort() {
		for (int i=0; i<tc.length; i++) {
			double input[] = tc[i][0];
			double expected[] = tc[i][1];
			System.out.println("----");
			printArray(input); 
			sorter.sort(input);
			printArray(input); 
			assertArrayEquals(input, expected);
		}	
	 }
	 
	 private void assertArrayEquals(double a1[], double a2[]) {
		assertEquals(a1.length, a2.length);
		for (int i=0; i<a1.length; i++) {
			assertEquals(a1[i], a2[i],0);
		}
	 }	
	 
	 private void printArray(double[] d) {
		for (int i=0; i< d.length; i++) {
			System.out.print(d[i]+ " ");
		}
		System.out.println("");
	 }
}

