import java.awt.Container;
import javax.swing.*;

public class Paint extends JFrame {
    private EtchASketch sketch = new EtchASketch();
    
    public Paint(){
        Container contentPane = getContentPane();
        contentPane.add(sketch);
    }
    public static void main(String [] args){
        JFrame paint = new Paint();
        paint.setTitle("Paint");
        paint.setSize(500, 500);
        paint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        paint.setVisible(true);
    }
}
