package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTextArea;


import model.MapOne;
import model.PokemonGame;
import model.PokemonMap;


public class PokemonTextView extends JPanel implements Observer {
	private PokemonGame theGame;
	private JTextArea textArea;
	private JTextArea directions;
	private JPanel generalInfo;

	public PokemonTextView(PokemonGame theGame)  {
		this.theGame = theGame;
		initTextView();
	}


	private void initTextView() {
		setUpJPanel();
		setUpTextArea();

	}

	private void setUpJPanel() {
		setLayout(new GridLayout(1, 2));
		
		
		setSize(750, 500);
		setLocation(0, 0);
		this.add(generalInfo);
		this.setBackground(Color.WHITE);
		this.setFocusable(true);
		this.addKeyListener(new MovementListener(theGame));

	}

	private void setUpTextArea() {
		textArea = new JTextArea(theGame.toString());
		
		add(textArea);
		textArea.setLocation(0, 0);
		textArea.setSize(1000, 1000);
		textArea.setFont(new Font("Courier", Font.BOLD, 18));
		textArea.setEditable(false);
	}

	@Override
	public void update(Observable o, Object arg) {
		textArea.setText(theGame.toString());
	
		repaint();
		revalidate();
		
	}

	


}
