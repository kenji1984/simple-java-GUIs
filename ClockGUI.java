import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class ClockGUI extends JFrame{

	private StillClock clock = new StillClock();
	
	public ClockGUI() {
		add(clock);
		
		javax.swing.Timer timer = new javax.swing.Timer(30, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clock.setCurrentTime();
				clock.repaint();
			}
		});
		timer.start();
		
		
	/*	new javax.swing.Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clock.setCurrentTime();
				clock.repaint();
			}
		}).start(); */
	}
		
	
	public static void main (String [] args) {
		ClockGUI frame = new ClockGUI();
		frame.setTitle("StillClock");
		frame.setSize(300, 350);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
