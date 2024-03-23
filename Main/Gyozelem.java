package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A jatek vegen, a gyozelmi ablakot hozza elo
 */
public class Gyozelem extends JFrame implements ActionListener {
    JFrame frame;
    JButton jButton;
    Timer t;
    public Gyozelem (String a){
        JLabel label = new JLabel();
        label.setText(a);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setBounds(250,0,500,250);
        label.setFont(new Font("Consolas",Font.PLAIN,35));

        jButton = new JButton();
        jButton.setBackground(Color.red);
        jButton.setBounds(0, 0, 250, 250);
        jButton.setLayout(new BorderLayout());
        jButton.setText("Kilepes");
        jButton.setFont(new Font("Consolas",Font.PLAIN,35));
        jButton.addActionListener(this);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(750,250);
        frame.setVisible(true);
        frame.add(jButton);
        frame.add(label);
        t = new Timer(10000, this);
        t.start();
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==t) {
            System.exit(0);
        }
        if (e.getSource()==jButton) {
            System.exit(0);
        }
    }
}
