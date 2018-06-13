package item;

//HealthPot Item IS-A Item
public class HealthPot extends Item {

	public HealthPot(String itemName, int numOfItem) {
		super("HealthPot", numOfItem);
	}

	@Override
	public String toString() {
		return "HealthPot";
	}

//	@Override
//	public void useItem(){}

}
