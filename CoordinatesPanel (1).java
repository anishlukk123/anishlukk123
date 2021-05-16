package Csc1301;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class CoordinatesPanel extends JPanel {
  
private final int SIZE = 6;
private int x = 50, y = 50;
// create message field
private String msg = "Coordinates: (" + x + ", "+ y + ")";
public CoordinatesPanel() {
addMouseListener(new CoordinatesListener());
setBackground(Color.BLACK);
setPreferredSize(new Dimension(300,200));
}
public void paintComponent(Graphics page){
super.paintComponent(page);
page.setColor(Color.green);
page.fillOval(x, y, SIZE, SIZE);
page.drawString(msg, 5, 15); // pass message
}
private class CoordinatesListener implements MouseListener {
  
  
@Override
public void mousePressed(MouseEvent event) {
x = event.getX();
y = event.getY();
repaint();
}
  
@Override
public void mouseClicked(MouseEvent event) {
msg = "Mouse clicked"; // set message
repaint(); // repaint
}

@Override
public void mouseReleased(MouseEvent event) {
msg = "Mouse released";
repaint();
}
  
@Override
public void mouseEntered(MouseEvent event) {
msg = "Mouse entered";
repaint();
}

@Override
public void mouseExited(MouseEvent event) {
msg = "Mouse exited";
repaint();
}
}
}