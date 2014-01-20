import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.geom.*;
public class arrowboard extends JPanel implements ActionListener, MouseListener, MouseMotionListener{
Timer timer;
Head head;
body b;
leg l;
arm a;
arrow aa;
int x1;
int y1;
int x2;
int y2;
int newx;
int newy;
int corner1x;
int corner1y;
int corner2x;
int corner2y;
int corner3x;
int corner3y;
int corner4x;
int corner4y;



double cornerangle;
double hyp;
int x2test;
int y2test;
int deltax;
int deltay;
double slope;
double theta;
int toolong;
double length;
double length2;
ArrayList<ammo>am;
ArrayList<bird>br;
public arrowboard(){
setDoubleBuffered(true);
setSize(1200, 800);
setFocusable(true);
setBackground(Color.BLACK);
head=new Head();
b=new body();
l=new leg();
a=new arm();
aa=new arrow();
am=new ArrayList<ammo>();
br=new ArrayList<bird>();


toolong=0;
timer=new Timer(5, this);
timer.start();
addbirds();
addMouseListener(this);
addMouseMotionListener(this);
}
public void addbirds(){
br.add(new bird(1000, 5));
br.add(new bird(900, 10));
br.add(new bird(900, 200));
br.add(new bird(600, 100));
br.add(new bird(750, 130));
br.add(new bird(700,6));
br.add(new bird(960, 100));
br.add(new bird(500, 55));
br.add(new bird(600, 130));
br.add(new bird(900, 455));
}
public void actionPerformed(ActionEvent e){
for(int i=0; i<br.size(); i++){
br.get(i).move();
}
for(int i=0;i<am.size();i++){
ammo p=am.get(i);
p.move();
}
for(int i=0; i<am.size(); i++){
ammo p=am.get(i);

hyp=Math.sqrt(Math.pow(0.5*p.getwidth(), 2)+Math.pow(0.5*(p.getheight()/2), 2));
newx=p.getX()+(p.getwidth()/2);
newy=p.getY()+(p.getheight()/2);
cornerangle=Math.atan((double)p.getheight()/(double)p.getwidth());
corner1x=newx-(int)(hyp*Math.cos(cornerangle-p.dtheta));
corner1y=newy+(int)(hyp*Math.sin(cornerangle-p.dtheta));
corner2x=corner1x+(int)(p.getwidth()*Math.cos(-1*p.dtheta));
corner2y=corner1y-(int)(p.getwidth()*Math.sin(-1*p.dtheta));
corner3x=corner1x+(int)(hyp*2*Math.cos(cornerangle-p.dtheta));
corner3y=corner1y-(int)(hyp*2*Math.sin(cornerangle-p.dtheta));

for(int v=0; v<br.size(); v++){
bird a=br.get(v);
int corner1x2=a.getX();
int corner1y2=a.getY();
int corner2x2=a.getX()+a.getwidth();
int corner2y2=a.getY();
int corner3x2=a.getX();
int corner3y2=a.getY()+a.getheight();
if((corner2x<corner2x2 && corner2x>corner1x2 && corner2y>corner1y2 && corner2y<corner3y2) || (corner3x<corner2x2 && corner3x>corner1x2 && corner3y>corner1y2 && corner3y<corner3y2)){
am.remove(i);
br.remove(v);
}
}



}



repaint();
}


public void mousePressed(MouseEvent e){
x1=e.getX();
y1=e.getY();
}
public void mouseDragged(MouseEvent e){
if(length>1100){
toolong=1;
}
if(length<1100){
toolong=0;
}
if(toolong==0){
x2=e.getX();
y2=e.getY();
deltay=(y2-y1);
deltax=x2-x1;
slope=(double)deltay/(double)deltax;
}
x2test=e.getX();
y2test=e.getY();
length=Math.sqrt(Math.pow(x2test-x1, 2)+Math.pow(y2test-y1, 2));

}
public void mouseReleased(MouseEvent e){
if(toolong==0){
x2=e.getX();
y2=e.getY();
deltay=(y2-y1);
deltax=x2-x1;
slope=(double)deltay/(double)deltax;

}
theta=Math.atan(slope);


am.add(new ammo(a.getX(), a.getY(), theta, length));
toolong=0;

}
public void mouseEntered(MouseEvent e) {
    }
	public void mouseMoved(MouseEvent e){
	x1=0;
	x2=0;
	y1=0;
	y2=0;
	slope=0;
	theta=0;
	}
    
    public void mouseExited(MouseEvent e) {
      }
  public void mouseClicked(MouseEvent e) {
      }

public void paint(Graphics g){
super.paint(g);
Graphics2D g2d=(Graphics2D)g;
g2d.setColor(Color.GRAY);
g2d.drawLine(x1, y1, x2, y2);

g2d.drawImage(b.getImage(), b.getX(), b.getY(), this);
g2d.drawImage(l.getImage(), l.getX(), l.getY(), this);
for(int i=0; i<br.size(); i++){
g2d.drawImage(br.get(i).getImage(), br.get(i).getX(), br.get(i).getY(), this);
}
AffineTransform orig=g2d.getTransform();
AffineTransform newt=(AffineTransform)(orig.clone());
int Xrot=a.getX();
int Yrot=a.getY();


newt.rotate(Math.atan(slope), Xrot, Yrot);


g2d.setTransform(newt);
g2d.drawImage(a.getImage(), a.getX(), a.getY(), this);

g2d.drawImage(aa.getImage(), aa.getX(), aa.getY(), this);
g2d.setTransform(orig);
g2d.drawOval(50, 635, 20, 20);
g2d.setColor(Color.YELLOW);
g2d.fillOval(50, 640,35, 35);
for(int i=0;i<am.size();i++){
AffineTransform old=g2d.getTransform();
AffineTransform neww=(AffineTransform)(old.clone());
ammo p=am.get(i);
int Xrott=p.getX()+(p.getwidth()/2);
int Yrott=p.getY()+(p.getheight()/2);
neww.rotate(p.getdtheta(), Xrott, Yrott);
g2d.setTransform(neww);
g2d.drawImage(p.getImage(), p.getX(), p.getY(), this);
g2d.setTransform(old);
}




length2=length;
if(length2>1100){
length2=1100;
}
g2d.drawString("Meters Bow Stretched:"+(length2/1100), 14, 14);


}






























}