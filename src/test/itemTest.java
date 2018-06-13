
//Test cases for the Item Class

package test;

import static org.junit.Assert.*;

import org.junit.Test;
import model.*;
import pokemons.*;
import item.*;

public class itemTest {

	@Test
	 public void pokeballTest() {
		Item pokeball = new Pokeball(50);
		assertEquals(pokeball.getItemName(), "Pokeball");
		assertEquals(pokeball.getNumOfItems(), 50);
		assertEquals(pokeball.getPrice(), 100);
		assertEquals(pokeball.toString(), "Pokeball");
	}
	
	@Test
	public void setterTest(){
		Item item = new Pokeball(10);
		item.setItemName("Poke");
		assertEquals(item.getItemName(), "Poke");
		item.setNumOfItems(100);
		assertEquals(item.getNumOfItems(),100);
		item.setPrice(5);
		assertEquals(item.getPrice(), 5);
		
	}
	
	@Test
	public void useItemTest(){
		Pokeball pb = new Pokeball(1);
		assertEquals(pb.getItemName(), "Pokeball");
		assertEquals(pb.getNumOfItems(), 1);
		pb.setPrice(500);
		assertEquals(pb.getPrice(), 500);
		Charmander ch = new Charmander(1, 1, "Charmander", "Fire", false, 35, null);
		assertEquals(pb.capturePokemon(ch), "Captured: Charmander");
		Charmander ch2 = new Charmander(1, 1, "Charmander", "Fire", false, 65, null);
		assertEquals(pb.capturePokemon(ch2), "Pokemon not Captured...");
	}
	
	@Test
	public void otherItemTest(){
		HealthPot hp = new HealthPot("HealthPot", 1);
		assertEquals(hp.getItemName(),"HealthPot");
		assertEquals(hp.getNumOfItems(), 1);
		assertEquals(hp.toString(), "HealthPot");
		Bait b = new Bait("Bait", 2);
		assertEquals(b.getItemName(), "Bait");
		assertEquals(b.getNumOfItems(), 2);
		assertEquals(b.toString(), "Bait");

		
	}
	
	
}