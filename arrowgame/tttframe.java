import javax.swing.JFrame;
public class tttframe extends JFrame{
public tttframe(){
add(new rotatemyimg());
setVisible(true);
setSize(800, 800);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setResizable(false);
}
public static void main(String[] args){
tttframe n=new tttframe();
}
}