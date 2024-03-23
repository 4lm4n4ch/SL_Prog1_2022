package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***
 * Beallitasok kozben a hos kepessegeit, varazslatait lehet beallitani
 */
public class HosBeallit extends JFrame implements ActionListener {
    int penz;
    int hanyadikKepesseg=0;

    boolean varazserok[]={false,false,false,false,false};

    public void setPenz(int penz) {
        this.penz = penz;
    }

    /***
     * beallitja a kepeseget
     * @param hanyadikKepesseg egy egyesz szam
     */
    public void setHanyadikKepesseg(int hanyadikKepesseg) {
        this.hanyadikKepesseg = hanyadikKepesseg;
    }
    JButton submit;

    int tamadas=1;
    int vedekezes=1;
    int varazsero=1;
    int tudas=1;
    int moral=1;
    int szerencse=1;
    int ot = 5;

    JButton but1;
    JButton but2;
    JButton but3;
    JButton but4;
    JButton but5;
    JButton but6;

    JButton but8;
    JButton but9;
    JButton but10;
    JButton but11;
    JButton but12;

    JLabel text1;
    JLabel text2;
    JLabel text3;
    JLabel text4;
    JLabel text5;
    JLabel text6;

    JLabel text8;
    JLabel text9;
    JLabel text10;
    JLabel text11;
    JLabel text12;

    JLabel penzMutat;

    /***
     * beallitja a framet, hozzaadja a nehezsegi szintet
     * @param nehezseg egesz szam nehezsegi szintet jeloli
     */
    public HosBeallit(int nehezseg) {
        if(false) {
            System.err.println("Hali");
            return;
        } else {
            this.penz = nehezseg;
        }
    //Cím beállítása
        JPanel cim = new JPanel();
        cim.setBackground(Color.black);
        cim.setPreferredSize(new Dimension(100,50));

        JLabel cimSzoveg = new JLabel();
        cimSzoveg.setText("Hos tulajdonsag valasztasa");
        cimSzoveg.setForeground(Color.white);
        cimSzoveg.setVerticalTextPosition(JLabel.CENTER);
        cimSzoveg.setHorizontalTextPosition(JLabel.CENTER);
        cimSzoveg.setFont(new Font("Consolas",Font.PLAIN,35));

        JLabel karakter = new JLabel();
        karakter.setText("Penz");
        karakter.setForeground(Color.white);
        karakter.setVerticalTextPosition(JLabel.CENTER);
        karakter.setHorizontalTextPosition(JLabel.CENTER);
        karakter.setFont(new Font("Consolas",Font.PLAIN,35));
        
        
        cim.add(cimSzoveg);


    //Panel beállítása
        //panel1
        JPanel panel1 = new JPanel();
        panel1.setBounds(0, 50, 800, 50);

        JLabel hos = new JLabel();
        hos.setText("Tamadas");
        hos.setVerticalTextPosition(JLabel.CENTER);
        hos.setHorizontalTextPosition(JLabel.CENTER);
        hos.setFont(new Font("Consolas",Font.PLAIN,30));
        but1 = new JButton("+");
        but1.addActionListener(this);
        but1.setFont(new Font("Consolas",Font.PLAIN,30));

        text1= new JLabel();
        text1.setText(" Ertek: " + this.tamadas);
        text1.setFont(new Font("MV Boli",Font.PLAIN,25));

        panel1.add(hos);
        panel1.add(but1);
        panel1.add(text1);
        add(panel1);

        //panel2
        JPanel panel2 = new JPanel();
        panel2.setBounds(0, 100, 800, 50);

        JLabel hos2 = new JLabel();
        hos2.setText("Vedekezes");
        hos2.setVerticalTextPosition(JLabel.CENTER);
        hos2.setHorizontalTextPosition(JLabel.CENTER);
        hos2.setFont(new Font("Consolas",Font.PLAIN,30));
        but2 = new JButton("+");
        but2.addActionListener(this);
        but2.setFont(new Font("Consolas",Font.PLAIN,30));

        text2= new JLabel();
        text2.setText(" Ertek: " + this.vedekezes);
        text2.setFont(new Font("MV Boli",Font.PLAIN,25));

        panel2.add(hos2);
        panel2.add(but2);
        panel2.add(text2);
        add(panel2);
        //panel3
        JPanel panel3 = new JPanel();
        panel3.setBounds(0, 150, 800, 50);

        JLabel hos3 = new JLabel();
        hos3.setText("Varazsero");
        hos3.setVerticalTextPosition(JLabel.CENTER);
        hos3.setHorizontalTextPosition(JLabel.CENTER);
        hos3.setFont(new Font("Consolas",Font.PLAIN,30));
        but3 = new JButton("+");
        but3.addActionListener(this);
        but3.setFont(new Font("Consolas",Font.PLAIN,30));

        text3= new JLabel();
        text3.setText(" Ertek: " + this.varazsero);
        text3.setFont(new Font("MV Boli",Font.PLAIN,25));

        panel3.add(hos3);
        panel3.add(but3);
        panel3.add(text3);
        add(panel3);

        //panel4
        JPanel panel4 = new JPanel();
        panel4.setBounds(0, 200, 800, 50);

        JLabel hos4 = new JLabel();
        hos4.setText("Tudas");
        hos4.setVerticalTextPosition(JLabel.CENTER);
        hos4.setHorizontalTextPosition(JLabel.CENTER);
        hos4.setFont(new Font("Consolas",Font.PLAIN,30));
        but4 = new JButton("+");
        but4.addActionListener(this);
        but4.setFont(new Font("Consolas",Font.PLAIN,30));

        text4= new JLabel();
        text4.setText(" Ertek: " + this.tudas);
        text4.setFont(new Font("MV Boli",Font.PLAIN,25));

        panel4.add(hos4);
        panel4.add(but4);
        panel4.add(text4);
        add(panel4);

        //panel5
        JPanel panel5 = new JPanel();
        panel5.setBounds(0, 250, 800, 50);

        JLabel hos5 = new JLabel();
        hos5.setText("Moral");
        hos5.setVerticalTextPosition(JLabel.CENTER);
        hos5.setHorizontalTextPosition(JLabel.CENTER);
        hos5.setFont(new Font("Consolas",Font.PLAIN,30));
        but5 = new JButton("+");
        but5.addActionListener(this);
        but5.setFont(new Font("Consolas",Font.PLAIN,30));

        text5= new JLabel();
        text5.setText(" Ertek: " + this.moral);
        text5.setFont(new Font("MV Boli",Font.PLAIN,25));

        panel5.add(hos5);
        panel5.add(but5);
        panel5.add(text5);
        add(panel5);

        //panel6
        JPanel panel6 = new JPanel();
        panel6.setBounds(0, 300, 800, 50);

        JLabel hos6 = new JLabel();
        hos6.setText("Szerencse");
        hos6.setVerticalTextPosition(JLabel.CENTER);
        hos6.setHorizontalTextPosition(JLabel.CENTER);
        hos6.setFont(new Font("Consolas",Font.PLAIN,30));
        but6 = new JButton("+");
        but6.addActionListener(this);
        but6.setFont(new Font("Consolas",Font.PLAIN,30));

        text6= new JLabel();
        text6.setText(" Ertek: " + this.szerencse);
        text6.setFont(new Font("MV Boli",Font.PLAIN,25));

        panel6.add(hos6);
        panel6.add(but6);
        panel6.add(text6);
        add(panel6);


        //penz mutatas
        JPanel panel7 = new JPanel();
        panel7.setBounds(0, 350, 800, 30);

        penzMutat = new JLabel();
        penzMutat.setText("Maradek penz: " + this.penz + " Kovetkezo kepesseg ara: " + this.ot);

        panel7.add(penzMutat);
        add(panel7);

        
        //Villamcsapas
        JPanel panel8 = new JPanel();
        panel8.setBounds(-50, 375, 800, 50);

        JLabel hos8 = new JLabel();
        hos8.setText("Villamcsapas: 5 mana");
        hos8.setVerticalTextPosition(JLabel.CENTER);
        hos8.setHorizontalTextPosition(JLabel.CENTER);
        hos8.setFont(new Font("Consolas",Font.PLAIN,30));
        but8 = new JButton("+");
        but8.addActionListener(this);
        but8.setFont(new Font("Consolas",Font.PLAIN,30));

        text8= new JLabel();
        text8.setText(" 60 arany ");
        text8.setFont(new Font("MV Boli",Font.PLAIN,25));

        panel8.add(hos8);
        panel8.add(but8);
        panel8.add(text8);
        add(panel8);

        
        //Tuzlabda
        JPanel panel9 = new JPanel();
        panel9.setBounds(-50, 425, 900, 50);

        JLabel hos9 = new JLabel();
        hos9.setText("Tuzlabda: 9 mana ");
        hos9.setVerticalTextPosition(JLabel.CENTER);
        hos9.setHorizontalTextPosition(JLabel.CENTER);
        hos9.setFont(new Font("Consolas",Font.PLAIN,30));
        but9 = new JButton("+");
        but9.addActionListener(this);
        but9.setFont(new Font("Consolas",Font.PLAIN,30));

        text9= new JLabel();
        text9.setText(" 120 arany ");
        text9.setFont(new Font("MV Boli",Font.PLAIN,25));

        panel9.add(hos9);
        panel9.add(but9);
        panel9.add(text9);
        add(panel9);
        
        
        //feltamasztas
        JPanel panel10 = new JPanel();
        panel10.setBounds(-100, 475, 1000, 50);

        JLabel hos10 = new JLabel();
        hos10.setText("Feltamasztas: 9 mana ");
        hos10.setVerticalTextPosition(JLabel.TOP);
        hos10.setHorizontalTextPosition(JLabel.LEFT);
        hos10.setFont(new Font("Consolas",Font.PLAIN,30));
        but10 = new JButton("+");
        but10.addActionListener(this);
        but10.setFont(new Font("Consolas",Font.PLAIN,30));

        text10= new JLabel();
        text10.setText(" 120 arany ");
        text10.setFont(new Font("MV Boli",Font.PLAIN,25));

        panel10.add(hos10);
        panel10.add(but10);
        panel10.add(text10);
        add(panel10);

        
        //LifeSteal
        JPanel panel11 = new JPanel();
        panel11.setBounds(-150, 525, 1100, 50);

        JLabel hos11 = new JLabel();
        hos11.setText("EletLopas 8 mana");
        hos11.setVerticalTextPosition(JLabel.CENTER);
        hos11.setHorizontalTextPosition(JLabel.CENTER);
        hos11.setFont(new Font("Consolas",Font.PLAIN,30));
        but11 = new JButton("+");
        but11.addActionListener(this);
        but11.setFont(new Font("Consolas",Font.PLAIN,30));

        text11= new JLabel();
        text11.setText(" 120 arany ");
        text11.setFont(new Font("MV Boli",Font.PLAIN,25));

        panel11.add(hos11);
        panel11.add(but11);
        panel11.add(text11);
        add(panel11);

        //Foldrenges
        JPanel panel12 = new JPanel();
        panel12.setBounds(-200, 575, 1200, 50);

        JLabel hos12 = new JLabel();
        hos12.setText("Teleportalas: 5 mana");
        hos12.setVerticalTextPosition(JLabel.CENTER);
        hos12.setHorizontalTextPosition(JLabel.CENTER);
        hos12.setFont(new Font("Consolas",Font.PLAIN,30));
        but12 = new JButton("+");
        but12.addActionListener(this);
        but12.setFont(new Font("Consolas",Font.PLAIN,30));

        text12= new JLabel();
        text12.setText(" 120 arany ");
        text12.setFont(new Font("MV Boli",Font.PLAIN,25));

        panel12.add(hos12);
        panel12.add(but12);
        panel12.add(text12);
        add(panel12);

        //submit
        JPanel panel13 = new JPanel();
        panel13.setBounds(0, 650, 1200, 50);
        submit = new JButton("Folytatas");
        submit.addActionListener(this);
        submit.setFont(new Font("Consolas",Font.PLAIN,35));
        panel13.add(submit);
        add(panel13);

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
    public void actionPerformed(ActionEvent e) {
        //tamadas
        if (e.getSource().equals(but1)) {
            int futo=5;
            for (int i=0;i<hanyadikKepesseg;i++) {
                futo+=Math.ceil(futo*0.1);
            }
            if(futo<this.penz && this.tamadas<10) {
                this.tamadas++;
                this.ot= (int) (futo+Math.ceil(futo*0.1));
                this.penz-=futo;
                hanyadikKepesseg++;
                text1.setText(" Ertek: " + this.tamadas);
                penzMutat.setText("Maradek penz: " + this.penz + "  Kovetkezo kepesseg ara: " + this.ot);
            } else {
                but1.setEnabled(false);
                return;
            }
        }
        //vedekezes
        if (e.getSource().equals(but2)) {
            int futo=5;
            for (int i=0;i<hanyadikKepesseg;i++) {
                futo+=Math.ceil(futo*0.1);
            }
            if(futo<this.penz && this.vedekezes<10) {
                this.vedekezes++;
                this.ot= (int) (futo+Math.ceil(futo*0.1));
                this.penz-=futo;
                hanyadikKepesseg++;
                text2.setText(" Ertek: " + this.vedekezes);
                penzMutat.setText("Maradek penz: " + this.penz + "  Kovetkezo kepesseg ara: " + this.ot);
            } else {
                but2.setEnabled(false);
                return;
            }
        }
        //varazsero
        if (e.getSource().equals(but3)) {
                int futo=5;
                for (int i=0;i<hanyadikKepesseg;i++) {
                    futo+=Math.ceil(futo*0.1);
                }
                if(futo<this.penz && this.varazsero<10) {
                    this.varazsero++;
                    this.ot= (int) (futo+Math.ceil(futo*0.1));
                    this.penz-=futo;
                    hanyadikKepesseg++;
                    text3.setText(" Ertek: " + this.varazsero);
                    penzMutat.setText("Maradek penz: " + this.penz + "  Kovetkezo kepesseg ara: " + this.ot);
                } else {
                    but3.setEnabled(false);
                    return;
                }
            }
        //tudas
        if (e.getSource().equals(but4)) {
            int futo=5;
            for (int i=0;i<hanyadikKepesseg;i++) {
                futo+=Math.ceil(futo*0.1);
            }
            if(futo<this.penz && this.tudas<10) {
                this.tudas++;
                this.ot= (int) (futo+Math.ceil(futo*0.1));
                this.penz-=futo;
                hanyadikKepesseg++;
                text4.setText(" Ertek: " + this.tudas);
                penzMutat.setText("Maradek penz: " + this.penz + "  Kovetkezo kepesseg ara: " + this.ot);
            } else {
                but4.setEnabled(false);
                return;
            }
        }
        //moral
        if (e.getSource().equals(but5)) {
            int futo=5;
            for (int i=0;i<hanyadikKepesseg;i++) {
                futo+=Math.ceil(futo*0.1);
            }
            if(futo<this.penz && this.moral<10) {
                this.moral++;
                this.ot= (int) (futo+Math.ceil(futo*0.1));
                this.penz-=futo;
                hanyadikKepesseg++;
                text5.setText(" Ertek: " + this.moral);
                penzMutat.setText("Maradek penz: " + this.penz + "  Kovetkezo kepesseg ara: " + this.ot);
            } else {
                but5.setEnabled(false);
                return;
            }
        }
        //szerencse
        if (e.getSource().equals(but6)) {
            int futo=5;
            for (int i=0;i<hanyadikKepesseg;i++) {
                futo+=Math.ceil(futo*0.1);
            }
            if(futo<this.penz && this.szerencse<10) {
                this.szerencse++;
                this.ot= (int) (futo+Math.ceil(futo*0.1));
                this.penz-=futo;
                hanyadikKepesseg++;
                text6.setText(" Ertek: " + this.szerencse);
                penzMutat.setText("Maradek penz: " + this.penz + "  Kovetkezo kepesseg ara: " + this.ot);
            } else {
                but6.setEnabled(false);
                return;
            }
        }
        
        //varazserok
        if (e.getSource()==but8) {
            if(this.penz<60) {
                but8.setEnabled(false);
                return;
            }
            but8.setEnabled(false);
            this.penz-=60;
            penzMutat.setText("Maradek penz: " + this.penz);
            varazserok[0]=true;
        }
        if (e.getSource()==but9) {
            if(this.penz<120) {
                but9.setEnabled(false);
                return;
            }
            but9.setEnabled(false);
            this.penz-=120;
            penzMutat.setText("Maradek penz: " + this.penz);
            varazserok[1]=true;
        }
        if (e.getSource()==but10) {
            if(this.penz<120) {
                but10.setEnabled(false);
                return;
            }
            but10.setEnabled(false);
            this.penz-=120;
            penzMutat.setText("Maradek penz: " + this.penz);
            varazserok[2]=true;
        }
        if (e.getSource()==but11) {
            if(this.penz<120) {
                but11.setEnabled(false);
                return;
            }
            but11.setEnabled(false);
            this.penz-=120;
            penzMutat.setText("Maradek penz: " + this.penz);
            varazserok[3]=true;

        }
        if (e.getSource()==but12) {
            if(this.penz<120) {
                but12.setEnabled(false);
                return;
            }
            but12.setEnabled(false);
            this.penz-=120;
            penzMutat.setText("Maradek penz: " + this.penz);
            varazserok[4]=true;

        }
        //submit
        if(e.getSource().equals(submit)) {
            submit.setEnabled(false);
            this.dispose();
            Jatekos elsoJatekos = new Jatekos();
            elsoJatekos.setTamadas(tamadas);
            elsoJatekos.setVarazsero(varazsero);
            elsoJatekos.setVedekezes(vedekezes);
            elsoJatekos.setMoral(moral);
            elsoJatekos.setSzerencse(szerencse);
            elsoJatekos.setPenz(penz);
            elsoJatekos.setVarazserok(varazserok);
            elsoJatekos.setTudas(tudas*10);
            elsoJatekos.jatekos=true;
            int[] penz;
            new EgysegValasztas(elsoJatekos);
        }
    }
}