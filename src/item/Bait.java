package item;

// An item called bait to be used during battle to bait the pokemon and
//make it more likely to catch.
public class Bait extends Item {

	public Bait(String itemName, int numOfItems) {
		super("Bait", numOfItems);
		
	}

	@Override
	public String toString() {
		return "Bait";
	}

//	@Override
//	public void useItem() {}

}
