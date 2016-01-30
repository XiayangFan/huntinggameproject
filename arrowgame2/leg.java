import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Rectangle;

public class leg{
int x;
int y;
int dx;
int dy;
int width;
int height;
Image image;
public leg(){
x=65;
y=720;
ImageIcon ii=new ImageIcon(this.getClass().getResource("leg.PNG"));
image=ii.getImage();
width=image.getWidth(null);
height=image.getHeight(null);
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
public Rectangle getBounds(){
return new Rectangle(x, y, width, height);
}

}