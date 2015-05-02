import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MovingObject extends JFrame {
	private BoxCar boxCar = new BoxCar();
	private final int NUMKEYS = 5;
	
	private boolean [] keys = new boolean [NUMKEYS];
		
	public MovingObject() {
		add(boxCar);
		
		boxCar.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
					case KeyEvent.VK_LEFT: 
						keys[0] = true;
						break;
							
					case KeyEvent.VK_RIGHT: 
						keys[1] = true;
						break;
							
					case KeyEvent.VK_UP:
						keys[2] = true;
						break;
					
					case KeyEvent.VK_DOWN:
						keys[3] = true;
						break;
							
					case KeyEvent.VK_A: 
						keys[4] = true;
						break;
				}
				moveCar();
			}
			
			public void keyReleased(KeyEvent e) {
				switch(e.getKeyCode()) {
					case KeyEvent.VK_LEFT: 
						keys[0] = false;
						break;
							
					case KeyEvent.VK_RIGHT: 
						keys[1] = false;
						break;
							
					case KeyEvent.VK_UP:
						keys[2] = false;
						break;
					
					case KeyEvent.VK_DOWN:
						keys[3] = false;
						break;
							
					case KeyEvent.VK_A: 
						keys[4] = false;
						break;
				}
				moveCar();
			}
		});
		boxCar.setFocusable(true);
		
		Timer timer = new Timer(30, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				moveCar();
				repaint();
			}
		});
		timer.start();
	}
	
	private void moveCar() {
		if(keys[0]) { 
			if(boxCar.getXCoordinate() > 10)
				boxCar.setXCoordinate(boxCar.getXCoordinate() - 10); 
		}
				
		if(keys[1]) { 
			if(boxCar.getXCoordinate() < (boxCar.getWidth() - boxCar.getCarWidth() - 10))
				boxCar.setXCoordinate(boxCar.getXCoordinate() + 10); 
		}
				
		if(keys[2]) {
			if(boxCar.getYCoordinate() > 10)
				boxCar.setYCoordinate(boxCar.getYCoordinate() - 10);
		}
		
		if(keys[3]) {
			if(boxCar.getYCoordinate() < (boxCar.getHeight() - boxCar.getCarHeight() - boxCar.getTireDiameter() - 10))
				boxCar.setYCoordinate(boxCar.getYCoordinate() + 10);
		}
				
		if(keys[4]) {	
			boxCar.setBullet();
			boxCar.setGun(true);
			if(boxCar.bulletDistanceTravel() > boxCar.getWidth())
				boxCar.setGun(false);
		}		
	}
	
	public static void main (String [] args) {
		MovingObject object = new MovingObject();
		object.setTitle("Running");
		object.setSize(1000, 500);
		object.setLocationRelativeTo(null);
		object.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		object.setVisible(true);
	}
}

