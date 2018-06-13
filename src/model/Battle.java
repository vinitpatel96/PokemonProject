package model;

import java.io.Serializable;
import java.util.Random;

import javax.swing.JOptionPane;

import pokemons.*;
import pokemons.Pokemon;

public class Battle implements Serializable{

	private Trainer player;
	private PokemonGame game;
	private Pokemon battlePokemon;
	private static final int ROCK_HEALTH = 50;
	private boolean battleOver;
	private boolean caughtPokemon;
	int pokemonCatchProbability;
	Random rand;

	// constructor which will initialize variables
	public Battle() {
		player = player.getInstance();
		game = game.getInstance();
		rand = new Random();
		randomPokemon();
		battleOver = false;
		
		
		
	}

	// get random pokemon
	private void randomPokemon() {
		int rand = (int) (Math.random() * 100) + 1;

		if (rand < 60) {
			// common pokemons
			double commonPokemon = (Math.random() * 6) + 1;
			if (commonPokemon < 1) {
				battlePokemon = new Bulbasaur(); // common
				return;
			}
			if (commonPokemon < 2) {
				battlePokemon = new Charmander(); // common
				return;
			}
			if (commonPokemon < 3) {
				battlePokemon = new Eevee(); // common
				return;
			}
			if (commonPokemon < 4) {
				battlePokemon = new Jigglypuff(); // common
				return;
			}
			if (commonPokemon < 5) {
				battlePokemon = new Pikachu(); // common
				return;
			} else {
				battlePokemon = new Squirtle(); // common
				return;
			}
		}

		else if (rand < 90) {
			// medium rare
			double mediumRare = (Math.random() * 3) + 1;
			if (mediumRare < 1) {
				battlePokemon = new Blaziken(); // medium rare
				return;
			}
			if (mediumRare < 2) {
				battlePokemon = new Garchomp(); // medium rare
				return;
			} else {
				battlePokemon = new Gengar(); // medium rare
				return;
			}
		}

		else {
			// rare pokemons
			double rarePokemon = (Math.random() * 2) + 1;
			if (rarePokemon < 1) {
				battlePokemon = new Lugia(); // rare
				return;
			} else {
				battlePokemon = new Mewtwo(); // rare
				return;
			}
		}
	}

	// getter for random pokemon
	public Pokemon getRandomPokemon() {
		return battlePokemon;
	}
	
	public void pokemonShouldRun() {
		int  randomNum = rand.nextInt(200);
		if(randomNum < battlePokemon.getRunProbability()) {
			battleOver = true;
			JOptionPane.showMessageDialog(null, "The pokemon got away");
		}
		
		
	}


	// throw rock, each rock throw is -50 hp
	public void throwRock() {

		if (battlePokemon.getTotalHealth() <= 50) {
			battleOver = true;
		} else {
			battlePokemon.setTotalHealth(battlePokemon.getTotalHealth() - ROCK_HEALTH);
			battlePokemon.addRunProbability(10);
		}
	}

	// throw pokeball, will only catch pokemon if the pokemon's health is less
	// than 75
	public void throwPokeball() {
		int randNum = rand.nextInt(150);
		int catchProbability = battlePokemon.getTotalHealth() + battlePokemon.getRunProbability();
		if (catchProbability < randNum) {
			player.addPokemon(battlePokemon);
			JOptionPane.showMessageDialog(null, "You got the pokemon.... Awesome!");
			battleOver = true;
			
		} else {
			battlePokemon.addRunProbability(10);
			System.out.println("Run prob: " + battlePokemon.getRunProbability());
			System.out.println("rand " + randNum);

			pokemonShouldRun();
		}
	}

	// throw bait
	// run probability lowers
	public void throwBait() {
		battlePokemon.addRunProbability(-10);

		pokemonShouldRun();
	}

	// player run away
	public void runAway() {
		int randGen = (int) (Math.random() * 100) + 1; 
		if (randGen <  battlePokemon.getRunProbability()){
			battleOver = true;
		}
	}

	// sees if the battle is over or not
	public boolean battleOver() {
		pokemonShouldRun();
		return battleOver;
	}
	
	public Trainer getMyTrainer() {
		return this.player;
	}
	

	
	public boolean getCaughtPokemon(){
		return this.caughtPokemon;
	}
	
	public String battlePokemonToString() {
		return this.battlePokemon.getName() + "\n HP: " + this.battlePokemon.getTotalHealthLeft();
	}

	public String myTrainerToString() {
		return this.player.getName() + "\n HP: " + this.player.getTotalHealthLeft();
	}
	
	public String getName() {
		return this.battlePokemon.getName();
	}
	
	public String getHP() {
		return "" + this.battlePokemon.getTotalHealthLeft();
	}
	
	public String chosenName() {
		return this.player.getName();
	}
	
	public String chosenHP() {
		return "" + this.player.getTotalHealthLeft();
	}
}
