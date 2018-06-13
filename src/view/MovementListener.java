package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Direction;
import model.PokemonGame;
import model.PokemonMap;



public class MovementListener implements KeyListener {
	PokemonGame theGame;

	public MovementListener(PokemonGame theGame) {
		this.theGame = theGame;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 38) {
			theGame.moveTrainer(Direction.North);
		} else if (e.getKeyCode() == 39) {
			theGame.moveTrainer(Direction.East);
		} else if (e.getKeyCode() == 37) {
			theGame.moveTrainer(Direction.West);
		} else if (e.getKeyCode() == 40) {
			theGame.moveTrainer(Direction.South);
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}



