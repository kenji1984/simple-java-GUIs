import javax.swing.JOptionPane;

public class NumberGuessingGame {
	public static void main (String [] args) {
		String box1, box2, box3, box4, box5;
		
		box5 = "  1   3   5   7\n" + "  9 11 13 15\n" +
			   "17 19 21 23\n" + "25 27 29 31";
				
		box4 = "  2   3   6   7\n" + "10 11 14 15\n" +
			   "18 19 22 23\n" + "26 27 30 31";
				
		box3 = "  4   5   6   7\n" + "12 13 14 15\n" +
			   "20 21 22 23\n" + "28 29 30 31";
				
		box2 = "  8   9 10 11\n" + "12 13 14 15\n" +
			   "24 25 26 27\n" + "28 29 30 31";
				
		box1 = "16 17 18 19\n" + "20 21 22 23\n" +
			   "24 25 26 27\n" + "28 29 30 31";
		
		do {
			int magicNumber = 0;
			int choice = displayUI(box1);
			if(choice == JOptionPane.YES_OPTION) 
				magicNumber += 16;
			else if (choice == JOptionPane.CANCEL_OPTION)
				System.exit(0);
				
			choice = displayUI(box2);
			if(choice == JOptionPane.YES_OPTION) 
				magicNumber += 8;
			else if (choice == JOptionPane.CANCEL_OPTION)
				System.exit(0);
				
			choice = displayUI(box3);
			if(choice == JOptionPane.YES_OPTION) 
				magicNumber += 4;
			else if (choice == JOptionPane.CANCEL_OPTION)
				System.exit(0);
				
			choice = displayUI(box4);
			if(choice == JOptionPane.YES_OPTION) 
				magicNumber += 2;
			else if (choice == JOptionPane.CANCEL_OPTION)
				System.exit(0);
				
			choice = displayUI(box5);
			if(choice == JOptionPane.YES_OPTION) 
				magicNumber += 1;
			else if (choice == JOptionPane.CANCEL_OPTION)
				System.exit(0);	

			JOptionPane.showMessageDialog(null, "You're thinking " + magicNumber + " !");
		}
		while(again());
	}
	
	private static int displayUI(String s) {
		int choice = JOptionPane.showConfirmDialog(null, "Is the number in here?\n" + s);
		return choice;
	}
	private static boolean again() {
		int choice = JOptionPane.showConfirmDialog(null, "Play again? ");
		if(choice == JOptionPane.YES_OPTION)
			return true;
		else
			return false;
	}
}