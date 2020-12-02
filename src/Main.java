import javax.swing.*;
import java.awt.*;

public class Main {
    public static  void main(String[] args){
        EmailGui frame=new EmailGui();
        frame.setSize(500,700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
