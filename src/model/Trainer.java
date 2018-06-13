// Last updated: 11/15 2104
// [WORKING ON BY NIVEN FRANCIS]

package model;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import pokemons.Pikachu;
import pokemons.Pokemon;

public class Trainer implements Serializable {
	
	
	private static String name;
	private BufferedImage trainerImage = null;
	private static BufferedImage trainer_sheet;
	private Bag backpack;
	private static Trainer myTrainer;
	private int totalHPLeft;
	
	private int steps;
	private int MAX_STEPS = 500;
	private Point location;
	
	private static ArrayList<Pokemon> pokemon;
	
	public Trainer(String name) {
		this.name = name;
		this.trainerImage = insertImage();
		backpack = new Bag();
		this.steps = 0;
		pokemon = new ArrayList<Pokemon>();
		
		this.location = new Point(0,0);
		totalHPLeft = 1000;
	}
	
	private static BufferedImage insertImage() {
		try {
			trainer_sheet = ImageIO.read(new File("images" + File.separator + "trainerSprite.png"));
		} catch (IOException e) {
			System.out.println("Can't find image");
		}
		return trainer_sheet.getSubimage(0, 0*32 , 32, 32);
	}
	
	public BufferedImage getBackOfTrainer() {
		return trainer_sheet.getSubimage(0, 1*32, 32, 32);
	}
	
	//adds pokemon into the arraylist
	public void addPokemon(Pokemon p){
		pokemon.add(p);
	}
	
	public ArrayList<Pokemon> getPokemons(){
		return this.pokemon;
	}
	
	//singleton OODP so only one instance is used throughout the game
	public static Trainer getInstance(){
		if(myTrainer == null){
			myTrainer = new Trainer(name);
		}
		
		return myTrainer;
	}
	
	public void setLocation(Point location) {
		this.location = location;
	}
	
	public Point getLocation() {
		return this.location;
	}
	
	// Returns this instance of the backpack
	public Bag getBackpack() {
		return backpack;
	}
	
	// Adds steps to the steps global variable
	public boolean addSteps(int add) {
		steps += 1;
		if(steps >= MAX_STEPS) {
			System.out.println("Trainer has walked maximum number of steps");
			return false;
		}
		return true;
	}
	
	// Returns number of steps
	public int stepCount() {
		steps++;
		return this.MAX_STEPS-this.steps;
	}
	
	// Returns name of trainer
	public String getName() {
		return this.name;
	}

	public int getTotalHealthLeft() {
		return totalHPLeft;
	}

//	public String getStepsLeft() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
}
