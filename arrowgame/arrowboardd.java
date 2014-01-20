import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
public class arrowboardd extends JPanel implements ActionListener{
Timer timer;
Headball head;
body b;
public arrowboardd(){
setDoubleBuffered(true);
setSize(800, 800);
setFocusable(true);
setBackground(Color.BLACK);
head=new Headball();
b=new body();
timer=new Timer(5, this);
timer.start();
addKeyListener(new TAdapter());
}


public void actionPerformed(ActionEvent e){
head.move();
body.move();
repaint();

}

public void paint(Graphics g){
super.paint(g);
Graphics2D g2d=(Graphics2D)g;
g2d.drawImage(head.getImage(), head.getX(), head.getY(), this);
g2d.drawImage(body.getImage(), body.getX(), body.getY(), this);
}



private class TAdapter extends KeyAdapter{
public void keyPressed(KeyEvent e){
head.keyPressed(e);
}
public void keyReleased(KeyEvent e){
head.keyReleased(e);
}
}


























}