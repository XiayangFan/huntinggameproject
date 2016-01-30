import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Rectangle;

public class ammo{
int x;
int y;
int dx;
int dy;
int width;
int height;
double t;
int xo;
int yo;

double angle;
double dtheta;
Image image;
double length;

double vo;
public ammo(int xcoord, int ycoord, double theta, double xy){
x=0;
y=0;


length=xy;
if(length>1100){
length=1100;
}
xo=xcoord;
yo=ycoord;
angle=theta;
dtheta=angle;
dx=4;
t=0;

dy=1;
vo=1.3*length;
ImageIcon ii=new ImageIcon(this.getClass().getResource("ammo.PNG"));
image=ii.getImage();
width=image.getWidth(null);
height=image.getHeight(null);

}
public int getX(){
return x;
}
public int getwidth(){
return width;
}
public int getheight(){
return height;
}
public double getAngle(){
return angle;
}
public double getdtheta(){
return dtheta;
}
public int getY(){
return y;
}
public Image getImage(){
return image;
}
public Rectangle getBounds(){
return new Rectangle(x, y, width, height);
}

public void move(){
t+=1;



x=(int)(vo*Math.cos(angle)*(t/65))+xo;
y=(int)((vo*Math.sin(angle)*(t/65))+(0.5*635*(t/65)*(t/65)))+yo;

dtheta=Math.atan((Math.tan(angle))+((635*(x-xo))/((vo*Math.cos(angle))*(vo*Math.cos(angle)))));



}

}