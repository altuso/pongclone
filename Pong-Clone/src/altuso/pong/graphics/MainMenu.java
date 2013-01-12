package altuso.pong.graphics;


import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import altuso.pong.listener.ContinueListener;
import altuso.pong.listener.ExitListener;
import altuso.pong.listener.StartListener;
import altuso.pong.main.Game;

public class MainMenu extends JPanel{

	private static final long serialVersionUID = 7932168066244757869L;
	
	private JButton startButton;
	private JButton exitButton;
	private JButton continueButton;
	private JLabel headerLabel;
	private JLabel footerLabel;

	private int width;
	private int height;

	public MainMenu() {

		this.width = Game.width;
		this.height = Game.height;
		Dimension size = new Dimension(width, height);
		this.setPreferredSize(size);
		this.setBackground(Color.BLACK);
		this.setLayout(null);
		
		startButton = new JButton(new ImageIcon(getClass().getResource("/start.png")));
		startButton.addActionListener(new StartListener());
		exitButton = new JButton(new ImageIcon(getClass().getResource("/exit.png")));
		exitButton.addActionListener(new ExitListener());
		continueButton = new JButton(new ImageIcon(getClass().getResource("/continue.png")));
		continueButton.addActionListener(new ContinueListener());
	    headerLabel = new JLabel(new ImageIcon(getClass().getResource("/header.png")));
	    footerLabel = new JLabel(new ImageIcon(getClass().getResource("/footer.png")));
		
	    this.add(headerLabel);
	    headerLabel.setBounds(290, 50, 700, 75);
	    
		this.add(continueButton);
		continueButton.setBounds(100, 250, 200, 50);
		continueButton.setVisible(false);
	    
		this.add(startButton);
		startButton.setBounds(100, 310, 200, 50);
		
		this.add(exitButton);
		exitButton.setBounds(100, 370, 200, 50);
		
		this.add(footerLabel);
		footerLabel.setBounds(25, 680, 150, 25);
	}
	
	public void enableContinueButton() {
		continueButton.setVisible(true);
	}
}
