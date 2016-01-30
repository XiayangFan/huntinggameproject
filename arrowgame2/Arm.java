import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Rectangle;
public class Arm
{
    int x;
    int y;
    int dx;
    int dy;
    int width;
    int height;
    int theta;
    int dtheta;
    Image image;
    public Arm()
    {
        x=65;
        y=685;
        theta=0;
        dtheta=0;
        ImageIcon ii=new ImageIcon(this.getClass().getResource("arm.PNG"));
        image=ii.getImage();
        width=image.getWidth(null);
        height=image.getHeight(null);
    }
    public int gettheta()
    {
        return theta;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public Image getImage()
    {
        return image;
    }
    public Rectangle getBounds()
    {
        return new Rectangle(x, y, width, height);
    }
}