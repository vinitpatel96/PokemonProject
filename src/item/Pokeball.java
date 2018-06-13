
package item;

import model.*;
import pokemons.*;

//This class is for the Pokeball, which IS-A Item.
//Pokeball has the ability to capture a pokemon.

public class Pokeball extends Item{
	private Pokemon pokemon;
	
	public Pokeball(int numOfItems) {
		super("Pokeball", numOfItems);
		super.setPrice(100);
	}

	//Need to edit the probability portion
	public String capturePokemon(Pokemon p) {
		int runProbability = p.getRunProbability();
		if(runProbability < 50){
			this.pokemon = p;
			return "Captured: " + p.getName();
		}
		return "Pokemon not Captured...";
	}
	

	@Override
	public String toString() {
		return "Pokeball";
	}

//	@Override
//	public String useItem() {
////		return null;
//		return capturePokemon(pokemon);
//	}


}