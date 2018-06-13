// Last updated: 1042
// A class that represents a model for the game map.
// This is represented by a double array of tile objects
// When the player lands on the tile objects the playerIsOnTile() method .
package model;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import pokemons.Blaziken;
import pokemons.Bulbasaur;
import pokemons.Charmander;
import pokemons.Eevee;
import pokemons.Garchomp;
import pokemons.Gengar;
import pokemons.Jigglypuff;
import pokemons.Lugia;
import pokemons.Mewtwo;
import pokemons.Pikachu;
import pokemons.Pokemon;
import pokemons.Squirtle;


//Abstract class for the Map
public abstract class PokemonMap implements Serializable {
	public static final int MAP_HEIGHT = 23;
	public static final int MAP_WIDTH = 23;
	protected Tile[][] map;
	public ArrayList<Point> pokemonLocations; 
	//protected transient BufferedImage placeholder;
	
	private BufferedImage fire;
	private BufferedImage water;
	private BufferedImage emptyGround;
	private BufferedImage grass;
	private BufferedImage trainer;
	private BufferedImage tree;

	
	
	public PokemonMap() {
		map = new Tile[MAP_HEIGHT][MAP_WIDTH];
		try {
			fire = ImageIO.read(new File("images/fire.png"));
			water = ImageIO.read(new File("images/water.png"));
			emptyGround = ImageIO.read(new File("images/emptyGround.png"));
			grass = ImageIO.read(new File("images/grass.png"));
			trainer = ImageIO.read(new File("images/trainer.png"));
			tree = ImageIO.read(new File("images/tree.png"));
			}
			catch(IOException e) {
			e.printStackTrace();

			}
	}
	
	public Tile getTile(int row, int column) {
		return map[row][column];
	}
	
	
	//returns the char of the item on each tile
	@Override
	public String toString() {
		StringBuilder mapRep = new StringBuilder();
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j].getHasTrainer()) {
					mapRep.append("[T] ");
				}
				else {
					mapRep.append("[" + map[i][j].toString() + "] ");
				}
			}
			mapRep.append("\n");
		}
		return mapRep.toString();
	}
	
	
	//sets the tile to empty (can walk through)
	public void setEveryTileToEmpty() {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				map[i][j] = new EmptyTile(emptyGround);
			}
		}
	}
	
	
	//sets a border of trees on the map
	public void treeBorder() {
		fillRowWithTrees(0);
		fillRowWithTrees(map.length - 1);
		fillColumnWithTrees(0);
		fillColumnWithTrees(map[0].length - 1);
		makeEntrance();
		
	}
	
	//sets a border fo fire on the map
	public void fireBorder(){
		fillRowWithFire(0);
		fillRowWithFire(map.length - 1);
		fillColumnWithFire(0);
		fillColumnWithFire(map[0].length - 1);
		makeEntrance();
	}
	
	
	//makes the entrance on the map
	private void makeEntrance() {
		map[8][0] = new EmptyTile(emptyGround);
		map[9][0] = new EmptyTile(emptyGround);
		map[10][0] = new EmptyTile(emptyGround);
	}
	
	//fills a row with tree tiles
	private void fillRowWithTrees(int rowToFill) {
		for(int i = 0; i < map.length; i++) {
			map[rowToFill][i] = new TerrainTile(tree,"t");
		}
	}
	
	//fills a colum with trees
	private void fillColumnWithTrees(int columnToFill) {
		for(int i = 0; i < map.length; i++) {
			map[i][columnToFill] = new TerrainTile(tree,"t");
		}
	}
	
	
	//fills a row with fire
	private void fillRowWithFire(int rowToFill) {
		for(int i = 0; i < map.length; i++) {
			map[rowToFill][i] = new TerrainTile(fire,"f");
		}
	}
	
	//fills a colum wit fire
	private void fillColumnWithFire(int columnToFill) {
		for(int i = 0; i < map.length; i++) {
			map[i][columnToFill] = new TerrainTile(fire,"f");
		}
	}
	
	
	//makes a grass rectangle
	public void makeGrassRectangle(Point start, int width, int height) {
		for(int i = start.x; i < width + start.x; i++ ) {
			for(int j = start.y; j < height + start.y; j++) {
				map[i][j] = new GrassTile(grass);
			}
		}
	}
	
	//makes a fire rectangle
	public void makeFireRectangle(Point start, int width, int height) {
		for(int i = start.x; i < width + start.x; i++ ) {
			for(int j = start.y; j < height + start.y; j++) {
				map[i][j] = new TerrainTile(fire,"f");
			}
		}
	}
	

	
//	public ArrayList getPokemonLocations(){
//		return this.pokemonLocations;
//	}
//	
	//intializes the map
	public abstract void initMap();
	
	
}
