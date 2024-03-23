package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***
 * A kulombozo egysegeket lehet kivalasztani
 */
public class EgysegValasztas extends JFrame implements ActionListener{
    Jatekos elsoJatekos;

    UjEgysegLetrehozasa egysegletrehoz = new UjEgysegLetrehozasa();
    Egyseg foldmuves = new Egyseg();
    Egyseg ilyasz = new Egyseg();
    Egyseg griff = new Egyseg();
    Egyseg lovag = new Egyseg();
    Egyseg lovas = new Egyseg();
    Egyseg[] egysegek = new Egyseg[5];
    JPanel panel;
    JButton button1;
    JTextField egysegValaszto;
    JComboBox comboBox;
    String[] egysegnevek ={"foldmuves","ilyasz","griff","lovag","lovas"};
    JLabel penzMutat;
    JButton submit;



    public EgysegValasztas (Jatekos elsoJatekos) {
        this.elsoJatekos=elsoJatekos;


        panel1();
        panel2();
        panel3();
        panel4();
        panel5();
        penz();
        submit();

        egysegVasarlas();

        frame();
    }
    //panelek
    void panel1(){
        egysegek[0]= new UjEgysegLetrehozasa().letrehoz(0,true);
        panel = new JPanel();
        panel.setBounds(0,0,1000,20);
        egysegek[0].label = new JLabel(egysegletrehoz.tooString(egysegek[0]));
        egysegek[0].label.setHorizontalTextPosition(JLabel.LEFT);
        egysegek[0].label.setFont(new Font("Consolas",Font.PLAIN,15));

        panel.add(egysegek[0].label);
        this.add(panel);
    }
    void panel2(){

        egysegek[1]=egysegletrehoz.letrehoz(1,true);

        panel = new JPanel();
        panel.setBounds(0,20,1000,20);

        egysegek[1].label = new JLabel(egysegletrehoz.tooString(egysegek[1]));
        egysegek[1].label.setHorizontalTextPosition(JLabel.LEFT);
        egysegek[1].label.setFont(new Font("Consolas",Font.PLAIN,15));

        panel.add(egysegek[1].label);
        this.add(panel);
    }
    void panel3(){
        egysegek[2]=egysegletrehoz.letrehoz(2,true);
        panel = new JPanel();
        panel.setBounds(0,40,1000,20);
        egysegek[2].label = new JLabel(egysegletrehoz.tooString(egysegek[2]));
        egysegek[2].label.setHorizontalTextPosition(JLabel.LEFT);
        egysegek[2].label.setFont(new Font("Consolas",Font.PLAIN,15));

        panel.add(egysegek[2].label);
        this.add(panel);
    }
    void panel4(){
        egysegek[3]=egysegletrehoz.letrehoz(3,true);
        panel = new JPanel();
        panel.setBounds(0,60,1000,20);
        egysegek[3].label = new JLabel(egysegletrehoz.tooString(egysegek[3]));
        egysegek[3].label.setHorizontalTextPosition(JLabel.LEFT);
        egysegek[3].label.setFont(new Font("Consolas",Font.PLAIN,15));

        panel.add(egysegek[3].label);
        this.add(panel);
    }
    void panel5(){
        egysegek[4]=egysegletrehoz.letrehoz(4,true);
        panel = new JPanel();
        panel.setBounds(0,80,1000,20);
        egysegek[4].label = new JLabel(egysegletrehoz.tooString(egysegek[4]));
        egysegek[4].label.setHorizontalTextPosition(JLabel.LEFT);
        egysegek[4].label.setFont(new Font("Consolas",Font.PLAIN,15));

        panel.add(egysegek[4].label);
        this.add(panel);
    }

    void egysegVasarlas(){
        panel = new JPanel();
        panel.setBounds(0,100,1000,60);

        button1 = new JButton("Vetel");
        button1.addActionListener((ActionListener) this);
        comboBox = new JComboBox(egysegnevek);

        egysegValaszto = new JTextField();
        egysegValaszto.setPreferredSize(new Dimension(250,40));
        egysegValaszto.setFont(new Font("Consolas",Font.PLAIN,35));
        egysegValaszto.setForeground(new Color(0x00FF00));
        egysegValaszto.setBackground(Color.black);

        panel.add(button1);
        panel.add(comboBox);
        panel.add(egysegValaszto);
        this.add(panel);
    }
    //penz
    void penz(){
        JPanel panel = new JPanel();
        panel.setBounds(0, 160, 800, 30);

        penzMutat = new JLabel();
        penzMutat.setText("Maradek penz: " + elsoJatekos.penz);

        panel.add(penzMutat);
        add(panel);
    }

    void submit(){
        JPanel panel = new JPanel();
        panel.setBounds(0, 200, 1200, 50);
        submit = new JButton("Jatek");
        submit.addActionListener(this);
        submit.setFont(new Font("Consolas",Font.PLAIN,35));
        panel.add(submit);
        add(panel);
    }

    void frame(){
        //frame beállítása

        ImageIcon image = new ImageIcon("Main/icon.png");
        this.setIconImage(image.getImage());
        this.setTitle("Kotprog");
        this.setPreferredSize(new Dimension(1000,1000));
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.pack();
        this.setVisible(true);
    }

    void egysegVetel(int a) {
        //leteszteli, hogy int e.
        try {
            if (egysegek[a].ar * Integer.parseInt(egysegValaszto.getText()) <= elsoJatekos.penz) {
                elsoJatekos.penz -= egysegek[a].ar * Integer.parseInt(egysegValaszto.getText());
                egysegek[a].megvett += Integer.parseInt(egysegValaszto.getText());
                penzMutat.setText("Maradek penz: " + elsoJatekos.penz);
                egysegek[a].label.setText(egysegletrehoz.tooString(egysegek[a]));
            } else {
                penzMutat.setText("Maradek penz: " + elsoJatekos.penz + " Nincs elég pénzed, hogy " + Integer.parseInt(egysegValaszto.getText()) + " darab egysegt vegyel");
            }
        } catch (Exception ignore) {}
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(button1)) {
            switch (comboBox.getSelectedIndex()) {

                case 0:
                    egysegVetel(0);
                    break;
                case 1:
                    egysegVetel(1);
                    break;
                case 2:
                    egysegVetel(2);
                    break;
                case 3:
                    egysegVetel(3);
                    break;
                case 4:
                    egysegVetel(4);
                    break;
            }
        }
        //submit
        if(e.getSource().equals(submit)) {
           for (Egyseg a: egysegek) {
               if (a.megvett>0) {
                   submit.setEnabled(false);
                   this.dispose();
                   elsoJatekos.egysegek=egysegek;
                   try {
                       new Csata(this.elsoJatekos);
                       return;
                   } catch (InterruptedException ignored) {}
               }
           }
        }
    }
}
