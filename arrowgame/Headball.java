import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Rectangle;

public class Headball{
int x;
int y;
int dx;
int dy;
Image image;
int width;
int height;

public Headball(){

x=50;
y=40;


ImageIcon ii=new ImageIcon(this.getClass().getResource("head.png"));
image=ii.getImage();
width=image.getWidth(null);
height=image.getHeight(null);


}
Rectangle getBounds(){
return new Rectangle(x, y, width, height);
}
public int getX(){
return x;
}
public int getY(){
return y;
}
public Image getImage(){
return image;
}





}

