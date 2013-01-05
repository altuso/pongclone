package altuso.pong.main;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import altuso.pong.enitities.Ball;
import altuso.pong.enitities.Bar;
import altuso.pong.graphics.MainMenu;
import altuso.pong.graphics.Sprites;
import altuso.pong.listener.HotKeyListener;
import basicGameLib.BasicGame;

public class Game extends BasicGame{

	private static final long serialVersionUID = 1946507029323180318L;

	private MainMenu mainMenu;
	private static Game instance;
	private int backgroundX;
	private Ball ball;
	private Bar playerBar;
	private Bar aiBar;

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
		getFrame().setLocationRelativeTo(null);
		Sprites.init();
		addKeyListener(new HotKeyListener());
		initGame();
		
	}
	
	private void initGame() {
		playerBar = new Bar(0, height / 2 - 75, 25, 150);
		playerBar.setControlEnabled(true);
		aiBar = new Bar(width - 25, height / 2 - 75, 25, 150);
		ball = new Ball(20, 20, playerBar, aiBar);
		aiBar.setBall(ball);
		aiBar.setAiControledEnabled(true);

	}

	@Override
	protected void render() {
		
		Graphics g = getGameGraphics();
		
		g.setColor(Color.BLACK);
		g.drawImage(Sprites.background, backgroundX, 0, null);
		
		g.setColor(Color.GREEN);
		
		ball.render(g);
		playerBar.render(g);
		aiBar.render(g);
		
		g.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		g.drawString("P: " + playerBar.getScore(), 25, 25);
		
		g.drawString("P: " + aiBar.getScore(), width - 100, 25);
		
		show();
	}

	@Override
	protected void update(double delta) {
		backgroundX -= 1 * delta;
		if(backgroundX < width * -1) {
			backgroundX = 0;
		}
		
		ball.update(delta);
		playerBar.update(delta);
		aiBar.update(delta);
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
		initGame();
	}

	public static void main(String[] args) {
		Game.getInstance();
	}
}
