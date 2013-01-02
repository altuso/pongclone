package game.listener;

import game.main.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContinueListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Game.getInstance().startGame();
		
	}

}
