package altuso.pong.listener;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import altuso.pong.main.Game;

public class ExitListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Game.getInstance().closeFrame();
	}

}
