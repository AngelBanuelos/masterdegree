
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawFractal extends JPanel {

    public Graphics2D circule;
    public Graphics2D tringule;
    public Dimension screenSize;

    private DrawFractal(Dimension screenSize) {
        this.screenSize = screenSize;
    }

    @Override
    public void paint(Graphics g) {
        circule = (Graphics2D) g;
        tringule = (Graphics2D) g;
        int middle = screenSize.width / 2;
        drawFractalIterative(middle, 300, 192); 
    }

    public void drawCircle(int x, int y, int radius) {
        circule.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
        //circule.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }

    public void drawTriangle(int x, int y, int radius) {

        double rad60 = Math.toRadians(60);
        int x1, y1, x2, y2, x3, y3;
        x1 = x + radius;
        y1 = y;
        x2 = x - (int) (radius * Math.cos(rad60));
        y2 = y - (int) (radius * Math.sin(rad60));
        x3 = x - (int) (radius * Math.cos(rad60));
        y3 = y + (int) (radius * Math.sin(rad60));
        drawCircle(x1, y1, 1);
        drawCircle(x2, y2, 1);
        drawCircle(x3, y3, 1);
        int[] xPoints = {x1, x2, x3};
        int[] yPoints = {y1, y2, y3};
        //tringule.fillPolygon(xPoints, yPoints, 3);
        tringule.drawPolygon(xPoints, yPoints, 3);

    }
// Recibe <x, y> del centro y radio del círculo 

    public void drawFractalRecursive(int x, int y, int radius) {
        if (radius <= 4) {
            return;
        }
        drawCircle(x, y, radius);
        drawTriangle(x, y, radius);
        drawFractalRecursive(x + radius / 4, y - radius / 3, radius / 3); // Superior derecho
        drawFractalRecursive(x + radius / 4, y + radius / 3, radius / 3); // Inferior derecho
        drawFractalRecursive(x - radius / 3, y, radius / 3); // Izquierdo
    }

    public void drawFractalIterative(int x, int y, int radius) {
        LinkedList<int[]> draws = new LinkedList();
        int[] d = {x, y, radius};
        draws.add(d);
        int level = 0;
        int newR = radius / 3;
        
        while (newR >= 4) {
            level++;
            int parent = 0;
            for (int h = 0; h < level - 1; h++) {
                parent += Math.pow(3, h);
            }
            for (int n = 1; n <= Math.pow(3, level - 1); n++) {
                int x1 = draws.get(parent)[0];
                int x2 = x1;
                int x3 = x1;
                int y1 = draws.get(parent)[1];
                int y2 = y1;
                int y3 = y1;
                
                int nRadius = draws.get(parent)[2];
                x1 = x1 + nRadius / 4;
                y1 = y1 - nRadius / 3;
                int[] a = {x1, y1, newR};
                draws.add(a);
                
                x2 = x2 + nRadius / 4;
                y2 = y2 + nRadius / 3;
                int[] b = {x2, y2, newR};
                draws.add(b);
                
                x3 = x3 - nRadius / 3;
                int[] c = {x3, y3, newR};
                draws.add(c);
                parent++;
            }
            newR = newR / 3;
        }

        while(!draws.isEmpty()){
            int[] poll = draws.pollLast();
            drawCircle(poll[0], poll[1], poll[2]);
            drawTriangle(poll[0], poll[1], poll[2]);
        }

    }
    

    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame frame = new JFrame("ADA- Fractales");
        frame.add(new DrawFractal(screenSize));
        frame.setSize(screenSize);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
