package altuso.pong.enitities;

import java.awt.Graphics;

public abstract class Entity {
	
	public int xPos;
	public int yPos;
	
	public Entity () {
		xPos = 0;
		yPos = 0;
	}
	
	public int getX() {
		return xPos;
	}
	
	public int getY() {
		return yPos;
	}
	
	public void setX(int x) {
		this.xPos = x;
	}
	
	public void setY(int y) {
		this.yPos = y;
	}
	
	public void setPosition(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}
	
	public abstract void update(double delta);
	
	
	public abstract void render(Graphics g);
	
}
