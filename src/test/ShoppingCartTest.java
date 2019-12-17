package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.shoppingcar.Product;
import main.shoppingcar.ProductNotFoundException;
import main.shoppingcar.ShoppingCart;

public class ShoppingCartTest {
	private ShoppingCart cart;
	private Product book1;


	@Before
	public void setUp() throws Exception {
		cart = new ShoppingCart();
		book1 = new Product("Pragmatic Unit Testing", 29.95);
		cart.addItem(book1); 
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testShoppingCart() {

	}

	@Test
	public void testGetBalance() {

	}

	@Test
	public void testAddItem() {
		Product book2 = new Product("Pragmatic Project Automation", 29.95);
		cart.addItem(book2);
		assertEquals(2, cart.getItemCount());
//		double expectedBalance = book1.getPrice() + book2.getPrice();
//		assertEquals(expectedBalance, cart.getBalance(), 0.0);
	}
	
	//throws ProductNotFoundException If the product was not in the cart.
	@Test
	public void testRemoveItem() throws ProductNotFoundException {
		cart.removeItem(book1);
		assertEquals(0, cart.getItemCount());
		
		
	}
	
	@Test(expected = ProductNotFoundException.class)
	public void testRemoveItem2() throws Exception {
		// �|�ߥX�ҥ~
		cart.empty();
		cart.removeItem(book1);
	}
	
    public void testRemoveItemNotInCart() {
        try {
             Product book3 = new Product("Pragmatic Version Control", 29.95);
             cart.removeItem(book3);
             fail("Should raise a ProductNotFoundException");
        } 
        catch(ProductNotFoundException expected) {
            // successful test
        }
    }



	@Test
	public void testGetItemCount() {
		Product book3 = new Product("Pragmatic Version Control", 29.95);
		double expectedBalance = book1.getPrice() + book3.getPrice();
		assertEquals(expectedBalance, cart.getBalance(), 0.0);

	}

	@Test
	public void testEmpty() {
		cart.empty();
		assertEquals(0, cart.getItemCount());
	}

}
