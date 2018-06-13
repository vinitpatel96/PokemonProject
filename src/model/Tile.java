package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public abstract class Tile implements Serializable {
	//private transient BufferedImage tileImage;
	private boolean hasTrainer;
	private boolean hasPokemon;
	protected boolean canMove;
	
	public Tile(BufferedImage tileImage) {
		//this.tileImage = null;
		this.hasTrainer = false;
		this.hasPokemon = false;
		canMove = true;
	}
	
	public boolean canMove() {
		return this.canMove;
	}
	
//	public BufferedImage getImage() {
//		return this.tileImage;
//	}
	
	public boolean getHasTrainer() {
		return hasTrainer;
	}
	
	public boolean getHasPokemon() {
		return false;
	}
	
	public void setHasTrainer(boolean hasHunter) {
		this.hasTrainer = hasHunter;
	}
	public abstract void playerIsOnTile(PokemonGame game);
	

}
