package FelugroAblakok;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***
 * Sebzes erteket irja ki
 */
public class Sebzes extends JFrame implements ActionListener {
    //JFrame
    JLabel label;
    JFrame frame;
    /***
     *
     * @param a string amit ki kell irni
     * @throws InterruptedException timer miatt kell
     */
    public Sebzes(String a) throws InterruptedException {
        label = new JLabel();
        label.setText(a);
        label.setForeground(Color.white);
        label.setBackground(Color.black);
        label.setOpaque(true);
        frame = new JFrame();
        frame.setTitle("Sebzes");
        frame.setVisible(true);
        frame.add(label);
        frame.pack();
        Timer t = new Timer(4000, this);
        t.start();

    }
    public void actionPerformed(ActionEvent e) {
        this.dispose();
        frame.setVisible(false);
    }


}
