package altuso.pong.listener;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import altuso.pong.main.Game;

public class ContinueListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Game.getInstance().startGame();
		
	}

}
