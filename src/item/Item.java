package item;

//Item Class is the Abstract class for all Items such as Pokeball.
//Item has has a name, price, number of items and a toString.
public abstract class Item {
	private String itemName;
	private int numOfItems;
	private int price;
	
	Item(String itemName, int numOfItems){
		this.itemName=itemName;
		this.numOfItems = numOfItems;
	}

	//set Name
	public void setItemName(String itemName){
		this.itemName = itemName;
	}
	
	//set Num of Item
	public void setNumOfItems(int numOfItems){
		this.numOfItems = numOfItems;
	}
	
	//set Price of item
	public void setPrice(int price){
		this.price = price;
	}
	
	//get the name of an Item
	public String getItemName(){
		return this.itemName;
	}
	
	//get the number of Items
	public int getNumOfItems(){
		return this.numOfItems;
	}
	
	
	//get the price of an Item
	public int getPrice(){
		return this.price;
	}

	//This is the toString which returns the name 
	public abstract String toString();
//	public abstract String useItem();

}