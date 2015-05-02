
import java.util.ArrayList;


public class Points {
    
    private ArrayList<Point> points; 
    
    public Points(){
        points = new ArrayList<>(); //makes an arraylist of points
    }
    
    public ArrayList<Point> getPoints(){  //return the arraylist of points
        return points;
    }
    
    public void addPoint(Point point){  //add point instance to arraylist
        points.add(point);
    }
    
    public void addPoint(int x, int y){ //add 2 points to arraylist as point
        points.add(new Point(x, y));
    }
    
    public int getX(int index){  //returns point X at index
        return points.get(index).getX();
    }
    
    public int getY(int index){
        return points.get(index).getY();
    }
    
    class Point {

        private int x;
        private int y;

        public Point() {
            x = 0;
            y = 0;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
