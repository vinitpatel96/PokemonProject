package model;
// A tile for holding items
// Contains an item and playerIsOnTile should perform the right action based on the item.
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.Serializable;

import item.Item;

public class ItemTile extends Tile implements Serializable {
	private Item itemOnTile;
	
	
	public ItemTile(BufferedImage tileImage, Item itemOnTile) {
		super(tileImage);
		this.itemOnTile = itemOnTile;
	}
	@Override
	public void playerIsOnTile(PokemonGame game) {
		//game.getTrainer().acquireItem();
		
	}

}
