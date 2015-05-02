import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class EtchASketch extends JPanel{
    
    private ArrayList<Points> lists = new ArrayList<>();
    private int line_num = 0;
    
    public EtchASketch(){
        setLayout(new BorderLayout());
        JButton bClear = new JButton("Clear");
        
        add(bClear, BorderLayout.SOUTH);
        
        MouseHandler mh = new MouseHandler();
        addMouseMotionListener(mh);
        addMouseListener(mh);
        
        bClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                lists.clear();
                line_num = 0;
                repaint();
            }
        });
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        for (int j = 0; j < lists.size(); j++) {
           for(int k = 0; k < lists.get(j).getPoints().size() - 1; k++){
                g.drawLine(lists.get(j).getX(k), lists.get(j).getY(k),
                        lists.get(j).getX(k+1), lists.get(j).getY(k+1));
            }
        }
    }
    
    private class MouseHandler extends MouseAdapter implements MouseMotionListener{
        
        //algorithm: create and fill an arraylist of points when dragged
        //           add that arraylist to list when released.
        @Override
        public void mousePressed(MouseEvent e){
            lists.add(new Points());
            lists.get(line_num).addPoint(e.getX(), e.getY());
            System.out.println("mouse is pressed");
            repaint();
        }
        
        @Override
        public void mouseReleased(MouseEvent e){
            ++line_num;
            System.out.println("mouse is released");
            repaint();
        }
        
        @Override
        public void mouseDragged(MouseEvent e){
            //if(e.getX() <= getWidth() && e.getY() <= getHeight() - 20)
                lists.get(line_num).addPoint(e.getX(), e.getY());
            repaint();            
        }
    }
}