package game.listener;

import game.main.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HotKeyListener implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_ESCAPE : 
			Game.getInstance().pauseGame();
			break;
	}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
