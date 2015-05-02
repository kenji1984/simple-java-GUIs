import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class BoxCar extends JPanel {
	
	private int carWidth;
	private int carHeight;
	private int tireDiameter;
	private int xCoordinate = 10;
	private int yCoordinate = 50;
	private boolean gun = false;
	private int bulletCount;
	private final int MAGAZINE = 200;
	private int [] xBullet = new int[MAGAZINE];
	private int [] yBullet = new int[MAGAZINE];
	
	public BoxCar() {
		carWidth = 100;
		carHeight = 30;
		tireDiameter = 20;	
		bulletCount = 0;
		for(int i = 0; i < MAGAZINE; i++) {
			xBullet[i] = xCoordinate + carWidth;
			yBullet[i] = yCoordinate + carHeight / 2;
		}
	}
	
	public BoxCar(int w, int h, int t) {
		carWidth = w;
		carHeight = h;
		tireDiameter = t;
		bulletCount = 0;
		for(int i = 0; i < MAGAZINE; i++) {
			xBullet[i] = xCoordinate + carWidth;
			yBullet[i] = yCoordinate + carHeight / 2;
		}
	}
	
	public int getCarWidth() {
		return carWidth;
	}
	
	public int getCarHeight() {
		return carHeight;
	}
	
	public int getTireDiameter() {
		return tireDiameter;
	}
	
	public void setBullet() {
		if(bulletCount < MAGAZINE) {
			xBullet[bulletCount] = xCoordinate + carWidth + 30;
			yBullet[bulletCount] = yCoordinate + carHeight / 2;
			bulletCount++;
		}
		else {
			bulletCount = 0;
			xBullet[bulletCount] = xCoordinate + carWidth + 30;
			yBullet[bulletCount] = yCoordinate + carHeight / 2;
			bulletCount++;
		}
	}
	
	public int bulletDistanceTravel(){
		return xBullet[bulletCount-1];
	}
	
	public void setXCoordinate(int x) {
		xCoordinate = x;
	}
	
	public void setYCoordinate(int y) {
		yCoordinate = y;
	}
	
	public void setGun(boolean gun) {
		this.gun = gun;
	}
	
	public boolean getGun() {
		return gun;
	}
	
	 public int getXCoordinate() {
		return xCoordinate;
	}
	
	public int getYCoordinate() {
		return yCoordinate;
	}
	
	protected void paintComponent(Graphics g) {
	
		super.paintComponent(g);
		
		g.setColor(Color.BLUE);
		g.fillRect(xCoordinate, yCoordinate, carWidth, carHeight); 
		g.setColor(Color.BLACK);
		g.fillOval(xCoordinate + (int)(carWidth * 1 / 5), yCoordinate + carHeight, tireDiameter, tireDiameter);
		g.fillOval(xCoordinate + (int)(carWidth * 3 / 5), yCoordinate + carHeight, tireDiameter, tireDiameter);
		
		if(gun) {
			g.setColor(Color.RED);
			for(int i = 0; i < MAGAZINE; i++){
				g.fillOval(xBullet[i], yBullet[i], 10, 10);
				xBullet[i] += 30;
			}
		}
	}
}