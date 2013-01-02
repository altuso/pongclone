package game.main;

import game.graphics.MainMenu;
import game.listener.HotKeyListener;

import java.awt.Color;
import java.awt.Graphics;

import basicGameLib.BasicGame;

public class Game extends BasicGame{

	private static final long serialVersionUID = 1946507029323180318L;

	private MainMenu mainMenu;
	private static Game instance;
	private int testX = 600;

	public synchronized static Game getInstance() {
		if(instance == null) {
			instance = new Game();
		}
		return instance;
	}
	
	
	
	//TODO: Idee Weltraum bild für den Hintergrund evtl. mit bewegung ? 
	
	private Game() {
		super(1280, "Pong-Clone", 16, 9);
		mainMenu = new MainMenu();
		addComponent(mainMenu);
		addKeyListener(new HotKeyListener());
	}

	@Override
	protected void render() {
		
		Graphics g = getGameGraphics();

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		
		g.setColor(Color.GREEN);
		g.drawString("GAME STARTED", testX, 355);

		show();
	}

	@Override
	protected void update(double delta) {
		testX += 5 * delta;
		if(testX > width) {
			testX = 0;
		}
	}
	
	public void startGame() {
		removeComponent(mainMenu);
		Game.getInstance().start();
	}
	
	public void pauseGame() {
		Game.getInstance().stop();
		addComponent(mainMenu);
		getFrame().setTitle(title);
		mainMenu.enableContinueButton();
	}
	
	public void resetGame() {
		testX = 600;
	}

	public static void main(String[] args) {
		Game.getInstance();
	}
}
