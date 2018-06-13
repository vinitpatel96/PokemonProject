package model;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javax.imageio.ImageIO;

import pokemons.Blaziken;
import pokemons.Pokemon;


//One of the map's for the game
public class MapOne extends PokemonMap implements Serializable {
	public static final Point startPoint = new Point(9,1);
	
	
	public MapOne() {
		super();
		
		initMap();
	}

	//initializes the map by setting up the tiles
	@Override
	public void initMap() {
		setEveryTileToEmpty();
		treeBorder();
		makeGrassRectangle(new Point(1,1), 8,10);
		makeGrassRectangle(new Point(11, 1),11,10);
		makeGrassRectangle(new Point(1,13), 11,9);
		bottomGrassTriangle();
		//placePokemon();
		
		
	}
	
	//creates a triangle shape of grass on the map
	private void bottomGrassTriangle() {
		final int startRow = map.length - 1 - 6;
		final int startColumn = map[0].length - 1 - 6;
		for(int i = startRow; i < map.length; i++) {
			for(int j = startColumn; j < map[0].length - i + startRow; j++) {
				map[i][j] = new GrassTile(null);
			}
		}
	}

	
	
	

}
