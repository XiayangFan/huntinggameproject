import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Rectangle;
public class Bird
{
    int x;
    int y;
    int dx;
    int dy;
    int width;
    int height;
    Image image;
    public Bird(int xo, int yo)
    {
        x=xo;
        y=yo;
        dx=-3;
        ImageIcon ii=new ImageIcon(this.getClass().getResource("bird.PNG"));
        image=ii.getImage();
        width=image.getWidth(null);
        height=image.getHeight(null);
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public int getwidth()
    {
        return width;
    }
    public int getheight()
    {
        return height;
    }
    public Image getImage()
    {
        return image;
    }
    public Rectangle getBounds()
    {
        return new Rectangle(x, y, width, height);
    }
    public void move()
    {
        x+=dx;
        if(x<-5)
        {
            x=1250;
        }
    }
}