//Katie Pan
//interface for Pokemon Class

package pokemons;

import java.awt.Image;

public interface PokemonModel {
	
	public int getLevel();
	public void setLevel(int newLevel);
	public int getTotalHealth();
	public void setTotalHealth(int val);
	public int getTotalHealthLeft();
	public String getName();
	public String getType();
	public boolean getCaptured();
	public void setCaptured(boolean bool);
	public int getRunProbability();
	public void setImage(Image i);
	public Image getImage();

}
