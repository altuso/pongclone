package altuso.pong.main;


import java.awt.Color;
import java.awt.Graphics;

import altuso.pong.graphics.MainMenu;
import altuso.pong.graphics.Sprites;
import altuso.pong.listener.HotKeyListener;
import basicGameLib.BasicGame;

public class Game extends BasicGame{

	private static final long serialVersionUID = 1946507029323180318L;

	private MainMenu mainMenu;
	private static Game instance;
	private int testX = 600;
	private int backgroundX;

	public synchronized static Game getInstance() {
		if(instance == null) {
			instance = new Game();
		}
		return instance;
	}
	
	private Game() {
		super(1280, "Pong-Clone", 16, 9);
		mainMenu = new MainMenu();
		addComponent(mainMenu);
		addKeyListener(new HotKeyListener());
		init();
		
	}
	
	private void init() {
		Sprites.init();
	}

	@Override
	protected void render() {
		
		Graphics g = getGameGraphics();
		
		g.setColor(Color.BLACK);
		g.drawImage(Sprites.background, backgroundX, 0, null);
		
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
		backgroundX -= 1 * delta;
		if(backgroundX < width * -1) {
			backgroundX = 0;
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
