package game.listener;

import game.main.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		Game.getInstance().resetGame();
		Game.getInstance().startGame();
	}

}
