package altuso.pong.enitities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import altuso.pong.main.Game;

public class Ball extends Entity{
	
	private int speed, ySpeed;
	private int width, height;
	private Rectangle boundingBox;
	private Bar playerBar, aiBar;
	private Random random = new Random();
	
	public Ball(int width, int height, Bar playerBar, Bar aiBar) {
		this.width = width;
		this.height = height;
		this.playerBar = playerBar;
		this.aiBar = aiBar;
		setPosition(Game.width / 2 + width / 2, Game.height / 2 - height / 2);
		boundingBox = new Rectangle(width, height);
		speed = 10;
		ySpeed = 0;
	}
	
	@Override
	public void update(double delta) {
		xPos += speed * delta;
		yPos += ySpeed * delta;
		boundingBox.setBounds(getX(), getY(), width, height);
 
		if(this.boundingBox.intersects(playerBar.getBoundingBox())) {
			speed *= -1;
			if(boundingBox.getCenterY() < playerBar.getBoundingBox().getCenterY() - 25) {
				ySpeed = (random.nextInt(7) + 3) * -1; 
			} else if(boundingBox.getCenterY() > playerBar.getBoundingBox().getCenterY() + 25) {
				ySpeed = random.nextInt(7) + 3;
			} else {
				ySpeed = getySpeed();
			}
		}
		if(this.boundingBox.intersects(aiBar.getBoundingBox())) {
			speed *= -1;
			if(boundingBox.getCenterY() < aiBar.getBoundingBox().getCenterY() - 25) {
				ySpeed = (random.nextInt(7) + 3) * -1; 
			} else if(boundingBox.getCenterY() > aiBar.getBoundingBox().getCenterY() + 25) {
				ySpeed = random.nextInt(7) + 3;
			} else {
				ySpeed = getySpeed();
			}
		}
		if(yPos <= 0 || yPos + height >= Game.height) {
			ySpeed *= -1;
		} 
		if(xPos + width >= Game.width ) {
			setPosition(Game.width / 2 + width / 2, Game.height / 2 - height / 2);
			ySpeed = 0;
			playerBar.addScore();
		} else if(xPos <= 0) {
			setPosition(Game.width / 2 + width / 2, Game.height / 2 - height / 2);
			ySpeed = 0;
			aiBar.addScore();
		}		
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.GREEN);
		g.fillOval(getX(), getY(), width, height);
		
	}

	public int getySpeed() {
		return ySpeed;
	}
}
