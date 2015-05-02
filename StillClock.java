import javax.swing.*;
import java.util.*;
import java.awt.*;

public class StillClock extends JPanel {
	private int hour;
	private int minute;
	private int second;
	
	public StillClock() {
		setCurrentTime();
	}
	
	void setCurrentTime() {
		Calendar calendar = new GregorianCalendar();
		hour = calendar.get(Calendar.HOUR);
		minute = calendar.get(Calendar.MINUTE);
		second = calendar.get(Calendar.SECOND);
	}
	
	public StillClock(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public void setHour(int hour) {
		if(hour >= 1 && hour <= 12) {
			this.hour = hour;
			repaint();
		}
	}
	
	public void setMinute(int minute) {
		if(minute >= 0 && minute <= 59) {
		this.minute = minute;
		repaint();
		}
	}
	
	public int getHour() {
		return hour;
	}
		
	public int getMinute() {
		return minute;
	}
	
	public int getSecond() {
		return second;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		int radius = (int)(Math.min(getWidth(), getHeight()) * 0.5 * 0.8); 
		//radius = smaller of width and height * 0.5. then multiply 0.8 again to make the clock smaller than the screen
		int xCenter = getWidth() / 2;
		int yCenter = getHeight() / 2;
		
		g.setColor(Color.BLACK);
		g.drawOval(xCenter - radius, yCenter - radius, radius * 2, radius * 2);
		
		g.drawString("1", (int)(xCenter + radius * Math.sin(1 * 2 * Math.PI / 12) - 8),
								yCenter -(int)(radius * Math.cos(1 * 2 * Math.PI / 12) - 10));
		g.drawString("2", (int)(xCenter + radius * Math.sin(2 * 2 * Math.PI / 12) - 7),
								yCenter -(int)(radius * Math.cos(2 * 2 * Math.PI / 12) - 7));
		g.drawString("3", (int)(xCenter + radius * Math.sin(3 * 2 * Math.PI / 12) -12), 
								yCenter -(int)(radius * Math.cos(3 * 2 * Math.PI / 12)));
		g.drawString("4", (int)(xCenter + radius * Math.sin(4 * 2 * Math.PI / 12) - 5), 
								yCenter -(int)(radius * Math.cos(4 * 2 * Math.PI / 12) + 5));
		g.drawString("5", (int)(xCenter + radius * Math.sin(5 * 2 * Math.PI / 12) - 2), 
								yCenter -(int)(radius * Math.cos(5 * 2 * Math.PI / 12) + 2));
		g.drawString("6", (int)(xCenter + radius * Math.sin(6 * 2 * Math.PI / 12) - 3), 
								yCenter -(int)(radius * Math.cos(6 * 2 * Math.PI / 12) + 3));
		g.drawString("7", (int)(xCenter + radius * Math.sin(7 * 2 * Math.PI / 12)), 
								yCenter -(int)(radius * Math.cos(7 * 2 * Math.PI / 12)));
		g.drawString("8", (int)(xCenter + radius * Math.sin(8 * 2 * Math.PI / 12) + 2), 
								yCenter -(int)(radius * Math.cos(8 * 2 * Math.PI / 12) + 2));
		g.drawString("9", (int)(xCenter + radius * Math.sin(9 * 2 * Math.PI / 12) + 3), 
								yCenter -(int)(radius * Math.cos(9 * 2 * Math.PI / 12)));
		g.drawString("10", (int)(xCenter + radius * Math.sin(10 * 2 * Math.PI / 12) + 5), 
								yCenter -(int)(radius * Math.cos(10 * 2 * Math.PI / 12) - 5));
		g.drawString("11", (int)(xCenter + radius * Math.sin(11 * 2 * Math.PI / 12) + 5), 
								yCenter -(int)(radius * Math.cos(11 * 2 * Math.PI / 12) - 7));
		g.drawString("12", (int)(xCenter + radius * Math.sin(12 * 2 * Math.PI / 12) - 3), 
								yCenter -(int)(radius * Math.cos(12 * 2 * Math.PI / 12) - 12));
								
		int hourHand = (int)(radius * 0.5);
		int xHour = (int)(xCenter + hourHand * Math.sin((hour + minute / 60.0) * (2 * Math.PI / 12)));
		int yHour = (int)(yCenter - hourHand * Math.cos((hour + minute / 60.0) * (2 * Math.PI / 12)));
		g2.setColor(Color.BLUE);
		g2.setStroke(new BasicStroke(3));
		g2.drawLine(xCenter, yCenter, xHour, yHour);
					
		int minuteHand = (int)(radius * 0.65);
		int xMinute = (int)(xCenter + minuteHand * Math.sin(minute * (2 * Math.PI / 60)));
		int yMinute = (int)(yCenter - minuteHand * Math.cos(minute * (2 * Math.PI / 60)));
		g2.setColor(Color.RED);
		g2.setStroke(new BasicStroke(2));
		g2.drawLine(xCenter, yCenter, xMinute, yMinute);
					
		int secondHand = (int)(radius * 0.8);
		int xSecond = (int)(xCenter + secondHand * Math.sin(second * (2 * Math.PI / 60)));
		int ySecond = (int)(yCenter - secondHand * Math.cos(second * (2 * Math.PI / 60)));
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(1));
		g2.drawLine(xCenter, yCenter, xSecond, ySecond);
		
		String time = new Date().toString();
		FontMetrics fm = g.getFontMetrics();
		int stringWidth = fm.stringWidth(time);
		g.drawString(time, getWidth() / 2 - stringWidth /2, yCenter + radius + 30); 
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(200, 200);
	}
}
