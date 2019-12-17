package main.shoppingcar;
import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingCart {
	
	private ArrayList items;    
	
	public ShoppingCart() {
		items = new ArrayList();
	}   
	
	//�p���ʪ������ثe���~����
	public double getBalance() {
		double balance = 0.00;
		for (Iterator i = items.iterator(); i.hasNext();) {
			Product item = (Product)i.next();
			balance += item.getPrice();
		} 	
		return balance;
	}
	
	//�b�ʪ����[�J�ʶR���~
	public void addItem(Product item) {
		items.add(item);
	}  
	
	//�b�ʪ������X���~
	public void removeItem(Product item) throws ProductNotFoundException {
		if (!items.remove(item)) {
			throw new ProductNotFoundException();
		}
	} 
	
	//���o�ثe�ʪ��������~���ƶq
	public int getItemCount() {
		return items.size();
	}
	
	//�M���ʪ���
	public void empty() {
		items.clear();
	}    


}
