import javax.swing.*;
public class HuntingGameMain extends JFrame
{
    public HuntingGameMain()
    {
        add(new ArrowBoard());
        setVisible(true);
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("game");
        setLocationRelativeTo(null);
        setResizable(false);
    }
    public static void main(String[] args)
    {
        HuntingGameMain n=new HuntingGameMain();
    }
}