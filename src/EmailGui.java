import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class EmailGui extends JFrame {
    private JButton send;
    private JTextField username;
    private JPasswordField password;
    private JTextField fromEmail;
    private JTextField toEmail;
    private JTextArea login;
    private JLabel user, fromE, toE;
    private JLabel pass;
    private JTextArea body;
    private JTextField subject;
    private JLabel bod;
    private JLabel sub;
    private JButton choosf;
    private JLabel titulli;
    private JTextArea path;
    static File fil = null;

    EmailGui() {
        super("EMAIL GUI");

        setLayout(new FlowLayout());
        Panel tot = new Panel(new GridLayout(7, 1));
        titulli = new JLabel("  LOW  BUDGET EMAIL ");
        titulli.setFont(new Font("Arial", Font.BOLD, 40));
        add(titulli);
        send = new JButton("Send");
        username = new JTextField(20);
        password = new JPasswordField((20));
        user = new JLabel("Username:");
        pass = new JLabel("Password:");
        fromEmail = new JTextField(40);
        toEmail = new JTextField(40);
        fromE = new JLabel("From:");
        toE = new JLabel("     To:");
        fromE.setLabelFor(fromEmail);
        toE.setLabelFor(toEmail);
        Panel p1 = new Panel(new FlowLayout());
        p1.add(fromE);
        p1.add(fromEmail);

        Panel p2 = new Panel(new FlowLayout());
        p2.add(toE);
        p2.add(toEmail);
        tot.add(p1);
        tot.add(p2);
        login = new JTextArea("\tLog in");
        login.setEditable(false);
        login.setFont(new Font("Arial Black", Font.BOLD, 20));
        login.setOpaque(false);

        tot.add(login);
        Panel p3 = new Panel(new FlowLayout());
        p3.add(user);
        p3.add(username);
        Panel p4 = new Panel(new FlowLayout());
        p4.add(pass);
        p4.add(password);
        tot.add(p3);
        tot.add(p4);

        subject = new JTextField(40);
        body = new JTextArea(15, 40);
        bod = new JLabel("Text:");
        sub = new JLabel("Subject:");
        body.setBorder((BorderFactory.createLineBorder(Color.decode("#2C6791"))));
        bod.setLabelFor(body);
        sub.setLabelFor(subject);
        Panel p5 = new Panel(new FlowLayout());
        p5.add(sub);
        p5.add(subject);
        tot.add(p5);
        add(tot);
        Panel p6 = new Panel(new FlowLayout());
        p6.add(bod);
        p6.add(body);
        add(p6);
        path = new JTextArea();
        path.setOpaque(false);
        path.setEditable(false);
        send = new JButton("Send");
        choosf = new JButton("Choose File");
        Panel buttons = new Panel((new FlowLayout()));
        buttons.add(choosf);
        buttons.add(send);
        add(buttons);
        add(path);
        Button bt = new Button();
        send.addActionListener(bt);
        choosf.addActionListener(bt);
    }

    public class Button implements ActionListener {
        String filePath;

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == send) {

                SendEmail se = new SendEmail(fromEmail.getText(), toEmail.getText(), username.getText(), password.getText(), subject.getText(), body.getText(), fil);
                se.Send();

            }
            if (e.getSource() == choosf) {

                JFrame frame = new JFrame("JFileChooser Popup");
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

                JFileChooser fileChooser = new JFileChooser(".");
                fileChooser.setControlButtonsAreShown(true);
                frame.add(fileChooser, BorderLayout.CENTER);
                int option = fileChooser.showOpenDialog(frame);
                if (option == JFileChooser.APPROVE_OPTION) {
                    fil = fileChooser.getSelectedFile();
                    filePath = fil.getAbsolutePath();
                    path.setText("File:" + filePath);
                    frame.setVisible(false);
                } else frame.setVisible(false);


            }
        }
    }

}
