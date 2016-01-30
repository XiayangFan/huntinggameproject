import javax.swing.*;
public class rectframe extends JFrame{
public rectframe(){
add(new arrowboard());
setVisible(true);
setSize(1200, 800);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setTitle("game");
setLocationRelativeTo(null);
setResizable(false);
}
public static void main(String[] args){
rectframe n=new rectframe();
}
}
