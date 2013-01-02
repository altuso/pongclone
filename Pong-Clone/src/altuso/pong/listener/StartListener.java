package altuso.pong.listener;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import altuso.pong.main.Game;

public class StartListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		Game.getInstance().resetGame();
		Game.getInstance().startGame();
	}

}
