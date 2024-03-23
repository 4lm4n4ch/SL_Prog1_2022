package Main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/***
 * A jatekbeli nehezseget lehet beallitani
 * hivja a HosBeallit class-t
 */
public class Nehezseg extends JFrame implements ActionListener{
    JRadioButton easy;
    JRadioButton medium;
    JRadioButton hard;

    int nehezseg;

    JButton submit;

    ButtonGroup group;

    Nehezseg(){
    //Cím beállítása
        JPanel cim = new JPanel();
        cim.setBackground(Color.black);
        cim.setPreferredSize(new Dimension(100,100));
        JPanel panel1 = new JPanel();


    //Címszöveg
        JLabel cimSzoveg = new JLabel();
        cimSzoveg.setText("Ez itt a jatek, valassz nehezseget");
        cimSzoveg.setForeground(Color.white);
        cimSzoveg.setVerticalTextPosition(JLabel.CENTER);
        cimSzoveg.setHorizontalTextPosition(JLabel.CENTER);
        cimSzoveg.setFont(new Font("Consolas",Font.PLAIN,35));
        cim.add(cimSzoveg);


    //Nehézség beálítása
        easy = new JRadioButton("Könnyű");
        medium = new JRadioButton("Közepes");
        hard = new JRadioButton("Nehéz");

        easy.setSelected(true);

        hard.setFont(new Font("Consolas",Font.PLAIN,35));
        medium.setFont(new Font("Consolas",Font.PLAIN,35));
        easy.setFont(new Font("Consolas",Font.PLAIN,35));

        group = new ButtonGroup();

        group.add(easy);
        group.add(medium);
        group.add(hard);

        panel1.add(easy);
        panel1.add(medium);
        panel1.add(hard);
    //Submit
        submit = new JButton("Submit");
        submit.addActionListener(this);
        submit.setFont(new Font("Consolas",Font.PLAIN,35));
        panel1.add(submit);

        //frame beállítása

        ImageIcon image = new ImageIcon("Main/icon.png");
        this.setIconImage(image.getImage());
        this.setTitle("Kotprog");
        this.setPreferredSize(new Dimension(800,800));
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(cim,BorderLayout.NORTH);
        this.add(panel1,BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
    }
    @Override
    /***
     * megjelenik, ha meg lett nyomva egy gomb
     * a nehezseget allitja be
     */
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit) {
            if(easy.isSelected()) {
                System.out.println("EAsy");
                this.nehezseg=1300;
            }
            if(medium.isSelected()) {
                System.out.println("kozepes");
                this.nehezseg=1000;
            }
            if(hard.isSelected()) {
                System.out.println("nehez");
                this.nehezseg=700;
            }
            submit.setEnabled(false);
            this.dispose();
            HosBeallit hosBeallit = new HosBeallit(this.nehezseg);
        }
    }
}
