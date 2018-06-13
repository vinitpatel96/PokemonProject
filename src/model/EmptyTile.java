package model;
// A class for holding a tile with nothing in it. it's player IsOnTile method does nothing.
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public class EmptyTile extends Tile implements Serializable {

	public EmptyTile(BufferedImage tileImage) {
		super(tileImage);
	}

	// do nothing because we are on an empty tile
	@Override
	public void playerIsOnTile(PokemonGame game) {}
	
	// here we return an e for an empty tile
	@Override
	public String toString() {
		return "e";
	}
	

}
