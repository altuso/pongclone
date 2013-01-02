package altuso.pong.listener;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import altuso.pong.main.Game;

public class HotKeyListener implements KeyListener{
	
	public static boolean upIsPressed = false;
	public static boolean downIsPressed = false;

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_ESCAPE : 
			Game.getInstance().pauseGame();
			break;
		case KeyEvent.VK_UP : 
			upIsPressed = true;
			break;
		case KeyEvent.VK_DOWN :
			downIsPressed = true;
			break;
	}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP :
			upIsPressed = false;
			break;
		case KeyEvent.VK_DOWN :
			downIsPressed = false;
			break;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
