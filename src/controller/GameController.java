// Last updated: 1042

package controller;

import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import model.MapOne;
import model.MapTwo;
import model.PokemonGame;
import model.PokemonMap;
import view.BattleView;
import view.GraphicViewMapTwo;
import model.Battle;
import view.PokemonTextView;

public class GameController extends JFrame implements Observer {
	private PokemonGame theGame;
	private MapOne firstMap;

	private JLayeredPane layeredPane;

	private MapTwo secondMap;


	private PokemonMap currentMap;
	private PokemonTextView textView;
	private BattleView battleView;
	private GraphicViewMapTwo graphicViewMapTwo;
	

	public GameController() {
		firstMap = new MapOne();
		currentMap = firstMap;
		theGame = new PokemonGame();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 1000);
		this.setLocation(0, 0);
		this.setTitle("Pokemon Safari Zone");
		setUpLayeredFrame();
		theGame.addObserver(this);
		graphicViewMapTwo = new GraphicViewMapTwo(theGame);
		layeredPane.add(graphicViewMapTwo,0);
		graphicViewMapTwo.setVisible(true);
		theGame.addObserver(graphicViewMapTwo);

	}


	

//	firstMap = new MapOne();
//	currentMap = firstMap;
//	theGame = new PokemonGame();
//	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	this.setSize(1000, 1000);
//	this.setLocation(0, 0);
//	this.setTitle("Pokemon Safari Zone");
//	textView = new PokemonTextView(theGame);
//	this.add(textView);
//	textView.setVisible(true);
//	theGame.addObserver(textView);
	
	
//	 firstMap = new MapOne();
//	 currentMap = firstMap;
//	 theGame = setUpGame(theGame);
//	 setUpFrame();
//	 theGame.addObserver(this);
//	
//	 this.setTitle("Pokemon Safari Zone");
//	 battleView = new BattleView(new Battle());
//	 this.add(battleView);
//	 battleView.setVisible(true);

	public static void main(String[] args) {
		GameController gameController = new GameController();
		gameController.setVisible(true);

	}
	
	private void setUpLayeredFrame() {
		this.layeredPane = new JLayeredPane();
		layeredPane.setLocation(0,0);
		layeredPane.setSize(1000, 1000);
		layeredPane.setVisible(true);
		this.add(layeredPane);
		
	}

	private void setUpFrame() {
		this.setLocation(0, 0);
		this.setSize(1000, 1000);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				int result = JOptionPane.showConfirmDialog(GameController.this, "Would you like to save your state?");
				if (result == JOptionPane.YES_OPTION) {
					saveGameState(theGame);
					System.exit(0);
				} else if (result == JOptionPane.NO_OPTION) {
					System.exit(0);
				}

			}
		});
	}

	private void saveGameState(PokemonGame theGame) {
		try {
			FileOutputStream bytesToDisk = new FileOutputStream("Pokemon_Saved_Data");
			ObjectOutputStream outFile = new ObjectOutputStream(bytesToDisk);
			outFile.writeObject(theGame);
			outFile.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.out.println("Writing objects failed");
		}
	}

	private PokemonGame setUpGame(PokemonGame theGame) {
		int result = JOptionPane.showConfirmDialog(this,
				"Start with previous saved state?\n" + "No means all new objects");
		if (result == JOptionPane.YES_OPTION) {
			try {
				FileInputStream rawBytes = new FileInputStream("Pokemon_Saved_Data");
				ObjectInputStream inFile = new ObjectInputStream(rawBytes);
				theGame = (PokemonGame) inFile.readObject();
				inFile.close();
			} catch (Exception e) {
				System.out.println("Reading objects failed");
			}
		} else if (result == JOptionPane.NO_OPTION) {
			theGame = new PokemonGame();
		} else {
			System.exit(0);
		}
		return theGame;

	}
	
	private void showBattle() {
		Battle battle = new Battle();
		battleView = new BattleView(battle);
		layeredPane.add(battleView);
		layeredPane.setLayer(battleView,1);
		battleView.setVisible(true);
		graphicViewMapTwo.setFocusable(false);
	}
	

	@Override
	public void update(Observable o, Object arg) {
		if(theGame.shouldLaunchBattle) {
			showBattle();
			theGame.shouldLaunchBattle = false;
			graphicViewMapTwo.setFocusable(true);
			graphicViewMapTwo.setVisible(true);
			
			
		}
		
		
		
	}

}