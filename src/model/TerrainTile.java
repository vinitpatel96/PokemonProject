package model;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public class TerrainTile extends Tile implements Serializable {
	private String terrainType;

	public TerrainTile(BufferedImage tileImage, String terrainType) {
		super(tileImage);
		this.terrainType = terrainType;
		super.canMove = false;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void playerIsOnTile(PokemonGame game) {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		return terrainType;
	}

}
