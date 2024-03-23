package FelugroAblakok;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***
 * Pajzsal valo vedekezesnel megjeleno ablakot hozza letre
 */
public class Pajzs extends JFrame implements ActionListener {
    //JFrame
    JFrame frame;
    /***
     *
     * @param a string amit ki kell irni
     * @throws InterruptedException timer miatt kell
     */
    public Pajzs(String a) throws InterruptedException {
        JLabel label = new JLabel();
        label.setText(a);
        label.setForeground(Color.white);
        label.setBackground(Color.black);
        label.setOpaque(true);
        frame = new JFrame();
        frame.setTitle("Pajzs hasznalat");
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
