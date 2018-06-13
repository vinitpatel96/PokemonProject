// Last updated: 11/15 2104
// [WORKING ON BY NIVEN FRANCIS; EDITED AND FINISHED BY KATIE PAN]

/*
 * 						+-----------------------------------------------+
 * 						|				<VINIT LOOK HERE>				|
 * 						|												|
 * 						|			Make sure .getName() works			|
 * 						|		here and also the initializations		|
 * 						|			in the trainer tester class			|
 * 						|												|
 * 						+-----------------------------------------------+
 */

package model;

import java.io.Serializable;
import java.util.HashMap;

import item.Item;

public class Bag implements Serializable {
	private int numItems;
	private HashMap bag;

	// Creates a new bag with nothing in the backpack
	public Bag() {
		bag = new HashMap<String, Integer>();
	}

	// Adds item passed through parameters to the backpack
	// Won't add if there's no space left in backpack
	public void addItem(Item item) {
		String itemStr = item.getItemName();
		if(bag.containsKey(itemStr)){
			int num = (int) bag.get(itemStr);
			bag.put(itemStr, num +1);
		}
		else{
			bag.put(itemStr, 1);
		}
	}

	// Removes given item from backpack and shifts array
	public void removeItem(Item item) {
		if(bag.containsKey(item.getItemName()) && item.getNumOfItems() > 0){
			int num = (int) bag.get(item.getItemName());
			if(num == 1){
				bag.remove(item.getItemName());
			}
			else{
				bag.put(item.getItemName(), num-1);
			}
		}
	}

	// uses given item from backpack and shifts array
	public void useItem(Item item) {
		this.removeItem(item);
	}

	// Prints all current items in the trainer's backpack
	public String toString() {
		String str = "";
		for(Object s : bag.keySet()){
			str += ((Item) s).getItemName() + " " + ((Item) s).getNumOfItems();
		}
		return str;
	}

	// Returns the number of items in the trainer's backpack	
	public int numItems() {
		int count = 0;
		for(Object s : bag.keySet()){
			count += ((Item) s).getNumOfItems();
		}

		return count;
	}
}
