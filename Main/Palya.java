package Main;

import Korulotte.*;
import Kozel.*;
import Varazserok.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/***
 * A csata fo szintere, itt tesztel az ActionListeren, itt nezi kinek a kore van
 * palyat letrehozza, egysegeket megnezi
 * elso, masodik jatekos koreinek megnezese
 * gyozelem teszteles
 * meghivja a tamadas osztalyt, majd lekezeli
 */
public class Palya extends JFrame implements ActionListener {
    JButton kivalasztottButton;
    int soronLevoEgyseg = -1;
    boolean ketJatekosMod;
    Egyseg[] egysegek;

    //5 figyelj ra
    static int palyax = 12;
    static int palyay = 10;

    public Jatekos elsoJatekos;
    public Jatekos masodikJatekos;
    //Jatekosok akcioinak figyelese
    boolean akcioElso;
    boolean akcioMasodik;
    //melette
    Melette melette = new Melette();

    JLabel topText = new JLabel();
    JPanel topPanel = new JPanel();
    //kor
    int kor;

    public static JLabel leftText = new JLabel();
    public static JPanel leftPanel = new JPanel();
    JButton[] lerakEgyseg = new JButton[5];
    JButton tamadas = new JButton("Tamadas");
    JButton varakozas = new JButton("Varakozas");
    JButton kezdoButton = new JButton("Kezdes");
    JButton reset = new JButton("Reset");
    JPanel soronLevo;

    JPanel leftVarazserok = new JPanel();
    JLabel rightText = new JLabel();
    JPanel rightPanel = new JPanel();

    JPanel csatater = new JPanel();
    public static JButton[][] negyzetRacs = new JButton[palyay][palyax];

    public JButton[] varazserok = new JButton[5];
    public String[] varazserokNevei = {"villamTamadas", "tuzLabda", "feltamasztas", "lifeSteal", "teleportalas"};
    public int[] manaKoltseg={5,9,6,10,3};


    //tamadas
    Tamadas tamadasClass;

    //egysegek egyTombben
    Egyseg[] egysegTomb;
    int[] egysegSebesseg;

    /***
     *
     * @param elsoJatekos palya megtervezese, egysegek lerakasaert felel a konstruktor
     * @throws InterruptedException just in case, biztosra kell menni
     */
    public Palya(Jatekos elsoJatekos) throws InterruptedException {
        this.elsoJatekos = elsoJatekos;
        //test
        robot();
        tombosites();

        //frame
        top();
        left();
        right();
        csatater();
        frame();
        new EllenfelLerak().lerak(negyzetRacs);
        //setRobotEgysegek();

    }

    /***
     * //ellenfel letrehozasa, a palyan, es az adatait is
     */
    void robot() {
        boolean[] varazserok ={true,false,false,false,false};
        masodikJatekos= new Jatekos(10,1,1,2,2,2,0,varazserok,false);
    }


    /***
     * egysegek tombbe rendezese, hogy melyikuk lepjen hamarabb
     */
    void tombosites(){
        Egyseg[] tomb   =new Egyseg[masodikJatekos.egysegek.length*2];
        int i;
        int hossz=0;
        Egyseg koviNagyobb;
        for (i=0;i<masodikJatekos.egysegek.length;i++) {
            tomb[i]=elsoJatekos.egysegek[i];
            tomb[masodikJatekos.egysegek.length*2-i-1] = masodikJatekos.egysegek[i];
            if(elsoJatekos.egysegek[i].megvett>0) {
                hossz++;
            }
            hossz++;
        }
        int moral1;
        int moral2;
        Egyseg futo;
        for (i=0;i<tomb.length-1;i++) {
            if (tomb[i].jatekos) tomb[i].kezdemenyezes += elsoJatekos.moral;
            else tomb[i].kezdemenyezes += masodikJatekos.moral;
            if (tomb[i].megvett == 0) tomb[i].kezdemenyezes = 0;
        }
        for (i=0;i<tomb.length-1;i++) {

            for (int j=i+1;j<tomb.length;j++)  {
                if(tomb[i].kezdemenyezes<=tomb[j].kezdemenyezes)  {
                    futo=tomb[j];
                    tomb[j]=tomb[i];
                    tomb[i]=futo;
                }
            }
        }
        for (i=0;i<tomb.length;i++) {
            if(tomb[i].megvett==0) {
                for (int j=i;j<tomb.length;j++) {
                    if(tomb[j].megvett!=0) {
                        tomb[i]=tomb[j];
                        tomb[j].megvett=0;
                    }
                }
            }
        }
        egysegTomb=new Egyseg[hossz];
        egysegSebesseg=new int[hossz];
        for (i=0;i<hossz;i++) {
            egysegTomb[i]=tomb[i];
            // System.out.println(tomb[i].nev + tomb[i].jatekos);
            egysegSebesseg[i]=egysegTomb[i].sebesseg;
            //   System.out.println(egysegTomb[i].nev + egysegTomb[i].jatekos);
        }
    }

    /***
     * magat a framet hozza letre
     */
    void frame() {
        //palya letrehoz
        ImageIcon image = new ImageIcon("Main/icon.png");
        this.setIconImage(image.getImage());
        this.setTitle("Kotprog");
        this.setPreferredSize(new Dimension(1400, 1000));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.pack();
        this.setVisible(true);
    }

    /***
     * a paja felso reszet hozza letre
     */
    void top() {
        topText.setBackground(new Color(25, 25, 25));
        topText.setForeground(new Color(25, 255, 0));
        topText.setFont(new Font("Consolas", Font.BOLD, 15));
        topText.setHorizontalAlignment(JLabel.CENTER);
        topText.setText("Ez egy jatek");
        topText.setOpaque(true);

        topPanel.setLayout(new BorderLayout());
        topPanel.setBounds(0, 0, 1400, 50);


        topPanel.add(topText);
        this.add(topPanel, BorderLayout.NORTH);
    }

    void left() throws InterruptedException {
        leftText.setFont(new Font("Consolas", Font.BOLD, 15));
        leftText.setHorizontalAlignment(JLabel.CENTER);
        leftText.setVerticalTextPosition(JLabel.TOP);
        leftText.setText("Elso Jatekos: " + elsoJatekos.tudas + " mana");
        leftText.setOpaque(true);
        leftText.setLayout(new FlowLayout());


        leftPanel.setBackground(new Color(150, 150, 150));
        leftPanel.setBounds(0, 50, 200, 1150);


        leftVarazserok.setLayout(new FlowLayout());
        leftVarazserok.setLayout(new GridLayout(5,1));
        for (int i = 0; i < elsoJatekos.varazserok.length; i++) {
            if (elsoJatekos.varazserok[i]) {
                varazserok[i] = new JButton(varazserokNevei[i] + " mana: " +manaKoltseg[i]);
                leftVarazserok.add(varazserok[i]);
                varazserok[i].setFont(new Font("MV Boli", Font.BOLD, 10));
                varazserok[i].addActionListener(this);
            }
        }


        leftPanel.add(leftText);
        leftPanel.add(leftVarazserok);


        //System.out.println(elsoJatekos.egysegek[i].nev);
        for (int i = 0; i < elsoJatekos.egysegek.length; i++) {
            if (elsoJatekos.egysegek[i].megvett != 0) {
                lerakEgyseg[i] = new JButton(elsoJatekos.egysegek[i].nev);
                lerakEgyseg[i].setBounds(0, 100, 200, 400);
                lerakEgyseg[i].addActionListener(this);
                kivalasztottButton = lerakEgyseg[i];
                leftPanel.add(lerakEgyseg[i]);
            }
        }
        kezdoButton.addActionListener(this);
        reset.addActionListener(this);



        leftPanel.add(kezdoButton);
        leftPanel.add(reset);
        System.out.println("lerak");
        eleteroTablazatLetrehoz(elsoJatekos);
        this.add(leftPanel);
    }
    void right(){


        rightText.setFont(new Font("Consolas", Font.BOLD, 15));
        rightText.setHorizontalAlignment(JLabel.CENTER);
        rightText.setVerticalTextPosition(JLabel.TOP);
        rightText.setText("<html><body>Masodik Jatekos <br> Adatai:</body></html>" );
        rightText.setOpaque(true);
        rightText.setLayout(new FlowLayout());



        rightPanel.setBackground(new Color(150, 150, 150));
        rightPanel.setBounds(1200, 50, 170, 1150);

        rightPanel.add(rightText);
        rightPanel.add(new JLabel("Tamadas: " + masodikJatekos.tamadas));
        rightPanel.add(new JLabel("Vedekezes: " + masodikJatekos.vedekezes));
        rightPanel.add(new JLabel("Varazsero: " + masodikJatekos.varazsero));
        rightPanel.add(new JLabel("Tudas: " + masodikJatekos.tudas));
        rightPanel.add(new JLabel("Moral: " + masodikJatekos.moral));
        rightPanel.add(new JLabel("Szerencse: " + masodikJatekos.szerencse));
        rightPanel.add(new JLabel("<html><body>Vasarolt varazslatok:<br>Villamcsapas</body></html>"));
        rightPanel.add(new JLabel("mana: "+ masodikJatekos.getTudas()*10));
        rightPanel.add(new JLabel("Egysegek:    "));
        eleteroTablazatLetrehoz(masodikJatekos);
        this.add(rightPanel);

    }

    /***
     * egy jatekos tablazatat hozza letre
     * @param jatekos a jatekos akinek a tablazot letre akarjuk hozni
     */
    void eleteroTablazatLetrehoz(Jatekos jatekos){
        for (Egyseg egyseg: jatekos.egysegek) {
            egyseg.eloEgysegek=egyseg.megvett;
            egyseg.osszesEletero= egyseg.eletero*egyseg.megvett;
            eletero(egyseg);
            if (jatekos.jatekos) leftPanel.add(egyseg.label);
            else rightPanel.add(egyseg.label);
        }


    }
    //eletero megnezes

    /***
     * Eleterot megnez, kiir
     * @param egyseg egyseg, akinek ki kell irni az eletet
     */
    void eletero(Egyseg egyseg) {
        if (egyseg.label==null) egyseg.label=new JLabel();
        egyseg.label.setText(egyseg.nev + " [" + egyseg.eloEgysegek + "/" +  egyseg.osszesEletero + "]  ");
    }


    //tomb letrehozas
    void egysegTombLetrehozasa(boolean a){
        for(int i=0;i<5;i++) {
            egysegek[i]=new UjEgysegLetrehozasa().letrehoz(i,a);
        }
    }
    void csatater() {
        csatater.setLayout(new GridLayout(palyay, palyax));
        csatater.setBackground(new Color(150, 150, 150));
        csatater.setBounds(200, 50, 1000, 900);

        for (int r = 0; r < palyay; r++) {
            for (int c = 0; c < palyax; c++) {
                negyzetRacs[r][c] = new JButton("[____]");
                negyzetRacs[r][c].setFont(new Font("MV Boli", Font.BOLD, 15));
                negyzetRacs[r][c].setBackground(Color.BLACK);
                negyzetRacs[r][c].setForeground(Color.WHITE);
                negyzetRacs[r][c].addActionListener(this);
                negyzetRacs[r][c].setFocusable(false);
                csatater.add(negyzetRacs[r][c]);
            }
        }

        this.add(csatater);
    }
    int egysege(String string){
        String[] tomb={"fs","iz","gf","lg","ls"};
        for (int i=0;i<tomb.length;i++) {
            if(string.equals(tomb[i])) {
                return i;
            }
        }
        return -1;
    }

    /***
     *
     * @param e button lenyomasat erzekelo gomb
     * @throws InterruptedException idő miatt
     */
    void elso(ActionEvent e) throws InterruptedException {
        /*
        int tomb[]=new HolVan().ittVan(negyzetRacs,egysegTomb[soronLevoEgyseg].rovidites,egysegTomb[soronLevoEgyseg].jatekos?Color.red:Color.blue);
        System.out.println(tomb[0] + "es a masodik " + tomb[1]);*/
        /*
        for (Egyseg a: egysegTomb) {
            System.out.println(a.nev + "  " + a.jatekos);
        }*/
        //varazslas kivalasztasa
        //varakozas gonb megnyomasa

        if(e.getSource()==varakozas) {
            setSoronLevo();
        }
        //palyan vegigmenni, hogy ott van e a source button
        for (int i = 0; i < palyay; i++) {
            for (int j = 0; j < palyax; j++) {
                if (e.getSource() == negyzetRacs[i][j]){


                    //Elozo button a griden van e
                    Egyseg tamado;
                    Egyseg vedekezo;
                    for (int k = 0; k < palyay; k++) {
                        for (int l = 0; l < palyax; l++) {
                            if(negyzetRacs[k][l].equals(kivalasztottButton) && negyzetRacs[i][j]!=negyzetRacs[k][l]){

                                //mozgas
                                if (melette.melette(i,j,k,l) && negyzetRacs[i][j].getText().equals("[____]") && negyzetRacs[k][l].getText().equals(egysegTomb[soronLevoEgyseg].rovidites) && negyzetRacs[k][l].getBackground()==(egysegTomb[soronLevoEgyseg].jatekos?Color.red:Color.blue) && egysegTomb[soronLevoEgyseg].sebesseg>0 ) {
                                    negyzetRacs[i][j].setText(kivalasztottButton.getText());
                                    negyzetRacs[i][j].setBackground(negyzetRacs[k][l].getBackground());
                                    kivalasztottButton.setText("[____]");
                                    kivalasztottButton.setBackground(Color.black);
                                    egysegTomb[soronLevoEgyseg].sebesseg--;
                                    if (egysegTomb[soronLevoEgyseg].sebesseg==0) setSoronLevo();
                                    else resetSoronLevo();
                                }
                                //ilyasz
                                if (egysegTomb[soronLevoEgyseg].specialisKepesseg==1 && egysegTomb[soronLevoEgyseg].sebesseg==egysegSebesseg[soronLevoEgyseg] && !melette.melette(i,j,k,l) && ilyasz(k,l) && negyzetRacs[k][l].getBackground()==(egysegTomb[soronLevoEgyseg].jatekos?Color.red:Color.blue) && negyzetRacs[k][l].getText()==egysegTomb[soronLevoEgyseg].rovidites && negyzetRacs[i][j].getBackground()!=negyzetRacs[k][l].getBackground()) { // nincs melette egy ellenseges egyseg sem, o a kivalasztott egyseg, valid a target
                                    for (Egyseg a: egysegTomb) {
                                        if((a.rovidites ==negyzetRacs[i][j].getText()) && (negyzetRacs[i][j].getBackground()==(a.jatekos?Color.red:Color.blue))) {
                                            boolean valt= a.visszatamadas;
                                            a.visszatamadas=false;
                                            tamadasClass = new Tamadas(egysegTomb[soronLevoEgyseg],a,elsoJatekos,masodikJatekos);
                                            setSoronLevo();


                                            //visszaallitani a visszatamadast
                                            a.visszatamadas=valt;
                                        }

                                    }
                                }

                                // kozel tamadas
                                if (melette.melette(i, j, k, l) && !negyzetRacs[i][j].getText().equals("[____]") && negyzetRacs[k][l].getText().equals(egysegTomb[soronLevoEgyseg].rovidites)  && negyzetRacs[i][j].getBackground()!=negyzetRacs[k][l].getBackground() && egysegTomb[soronLevoEgyseg].sebesseg==egysegSebesseg[soronLevoEgyseg]) { //elozo gomb megkeresese, ha az nem ures terulet
                                    for (Egyseg a: egysegTomb) {
                                        if((a.rovidites==negyzetRacs[i][j].getText()) && a.jatekos!=egysegTomb[soronLevoEgyseg].jatekos && egysegTomb[soronLevoEgyseg].jatekos==(negyzetRacs[k][l].getBackground() == Color.red)   && (egysegTomb[soronLevoEgyseg].rovidites==kivalasztottButton.getText())) { //&& a.jatekos!=egysegTomb[soronLevoEgyseg].jatekos
                                            tamadasClass = new Tamadas(egysegTomb[soronLevoEgyseg],a,elsoJatekos,masodikJatekos);
                                            setSoronLevo();
                                        }
                                    }
                                }
                                // System.out.println("[" + k + "][" + l + "] --> [" + i + "][" + j + "]");
                            }

                        }
                    }

                    // hos tamadas
                    if (kivalasztottButton==tamadas) {
                        if (negyzetRacs[i][j].getBackground()==Color.blue && akcioElso) {
                            Egyseg egyseg= new EgysegMegtalal().megtalal(i,j,negyzetRacs,egysegTomb);
                            new HosTamad().tamad(egyseg,elsoJatekos);
                            akcioElso=false;
                        }


                    }
                    //VARAZSLAS
                    for (int d = 0; d < varazserok.length; d++) {

                        if (kivalasztottButton == varazserok[d] && akcioElso) {
                            switch (d) {
                                case 0: {
                                    if (negyzetRacs[i][j].getBackground()==Color.blue && elsoJatekos.getTudas()>=5) {
                                        Egyseg egyseg = new EgysegMegtalal().megtalal(i, j, negyzetRacs, egysegTomb);
                                        new Villamcsapas(egyseg, elsoJatekos);
                                        akcioElso=false;
                                    }
                                    break;
                                }
                                case 1: {
                                    if (elsoJatekos.getTudas()>=9) {

                                    }
                                    new Tuzlabda(negyzetRacs,i,j,egysegTomb,elsoJatekos);
                                    akcioElso=false;
                                    break;
                                }
                                case 2: {
                                    //csapatteszt
                                    if (new EgysegMegtalal().megtalal(i,j,negyzetRacs,egysegTomb)==egysegTomb[soronLevoEgyseg] && elsoJatekos.getTudas()>=6) {
                                        new Feltamasztas(egysegTomb[soronLevoEgyseg],elsoJatekos);
                                        akcioElso=false;
                                    }
                                    break;
                                }
                                case 3: {
                                    Egyseg ellenseg= new EgysegMegtalal().megtalal(i,j,negyzetRacs,egysegTomb);
                                    if (!ellenseg.isJatekos() && elsoJatekos.getTudas()>=8) {
                                        new LifeSteal(egysegTomb[soronLevoEgyseg],ellenseg,elsoJatekos);
                                        akcioElso=false;
                                    }
                                    break;
                                }
                                case 4: {
                                    if (negyzetRacs[i][j].getBackground()==Color.black && elsoJatekos.getTudas()<5) break;
                                    Egyseg egyseg = new EgysegMegtalal().megtalal(i,j,negyzetRacs,egysegTomb);
                                    new Teleportalas(negyzetRacs,i,j,egyseg,this,elsoJatekos);
                                    akcioElso=false;
                                    break;
                                }
                            }
                            Egyseg egyseg = new EgysegMegtalal().megtalal(i,j,negyzetRacs,egysegTomb);
                            //vege
                            kivalasztottButton = varazserok[d];
                            System.out.println("varazserokivalasztva: " + varazserokNevei[d] + " loo -->"+ i+ "][" +j);
                        }
                    }
                }
            }
        }

        kivalasztottButton= (JButton) e.getSource() ;
    }

    public boolean isAkcioElso() {
        return akcioElso;
    }

    public void setAkcioElso(boolean akcioElso) {
        this.akcioElso = akcioElso;
    }

    public boolean isAkcioMasodik() {
        return akcioMasodik;
    }

    public void setAkcioMasodik(boolean akcioMasodik) {
        this.akcioMasodik = akcioMasodik;
    }

    /***
     *
     * @param e masodik jatekos mozgasat irja le
     * @throws InterruptedException ido miatt
     */
    void masodik(ActionEvent e) throws InterruptedException {
        //ha van akcioPont, akkor tamad
        if (akcioMasodik){
            for (Egyseg a: egysegTomb) {
                if (a.jatekos && a.getOsszesEletero()>0) {
                    new Villamcsapas(a, elsoJatekos);
                    akcioElso=false;
                }


            }
        }
        //ket reszre van bontva, tavolsagi illetve kozelharci egysegekre
        //tavolsagi
        if(egysegTomb[soronLevoEgyseg].specialisKepesseg==1) {
            new Tavolsagi(egysegTomb,soronLevoEgyseg,negyzetRacs,masodikJatekos,elsoJatekos,this);
        }
        //kozelharci
        else {
            new Kozeli(egysegTomb,soronLevoEgyseg,negyzetRacs,masodikJatekos,elsoJatekos,this);
        }
        setSoronLevo();
    }

    private void soronLevoNext() {
        if (soronLevo!=null) leftPanel.remove(soronLevo);
        soronLevo= new JPanel();
        while(true) {
            soronLevoEgyseg++;
            if(soronLevoEgyseg>=egysegTomb.length){
                kor++;
                String[] alma= new String[egysegTomb.length];
                for (int i=0;i<egysegTomb.length;i++) {
                    if (egysegTomb[i].osszesEletero>0) alma[i]=egysegTomb[i].nev +(egysegTomb[i].jatekos?"[elso]":"[masodik]");
                    else {alma[i]=" ";}
                }
                System.out.println(alma[0]);
                String nemTomb= Arrays.toString(alma);
                topText.setText(kor + ". korben vagy " + nemTomb);
                for (int i=0;i<egysegTomb.length;i++) {
                    egysegTomb[i].sebesseg=egysegSebesseg[i];
                }
                soronLevoEgyseg=0;
                akcioElso=true;
                akcioMasodik=true;
            }
            if (egysegTomb[soronLevoEgyseg].eloEgysegek>0) {
                break;
            }

        }
    }

    public JButton[][] getNegyzetRacs() {
        return negyzetRacs;
    }

    //soron levo egyseg kiirasa
    void setSoronLevo(){
        soronLevoNext();
        //nyerest teszteli le
        int[] valt={0,0};
        for (Egyseg a: egysegTomb) {
            if (a.osszesEletero>0) {
                if (a.jatekos) valt[0]++;
                if (!a.jatekos) valt[1]++;
            }

        }
        if (valt[0]==0 && valt[1]==0) {
            this.setVisible(false); new Gyozelem("Dontetlen");
        }
        if (valt[0]==0) {
            this.setVisible(false); new Gyozelem("Sajnos vesztettel");}
        if (valt[1]==0) {
            this.setVisible(false); new Gyozelem("Gratulalok nyertel");}
        //tobbit tesztel
        soronLevo.setBackground(Color.gray);
        soronLevo.setPreferredSize(new Dimension(200,100));
        soronLevo.setFont(new Font("MV Boli", Font.BOLD, 15));
        soronLevo.add(new JLabel("Kivalasztott egyseg: "+egysegTomb[soronLevoEgyseg].nev));
        soronLevo.add(new JLabel(egysegTomb[soronLevoEgyseg].jatekos?" Elso jatekos ": " Masodik jatekos "));
        soronLevo.add(new JLabel("Hatralevo mozgaspont: " + egysegTomb[soronLevoEgyseg].sebesseg));
        leftPanel.add(soronLevo);
        validate();
        egysegTomb[soronLevoEgyseg].visszatamadas=true;

    }
    void resetSoronLevo(){
        if (soronLevo!=null) leftPanel.remove(soronLevo);
        soronLevo= new JPanel();
        soronLevo.setBackground(Color.gray);
        soronLevo.setPreferredSize(new Dimension(200,100));
        soronLevo.setFont(new Font("MV Boli", Font.BOLD, 15));
        soronLevo.add(new JLabel("Kivalasztott egyseg: "+egysegTomb[soronLevoEgyseg].nev));
        soronLevo.add(new JLabel(egysegTomb[soronLevoEgyseg].jatekos?" Elso jatekos ": " Masodik jatekos "));
        soronLevo.add(new JLabel("Hatralevo mozgaspont: " + egysegTomb[soronLevoEgyseg].sebesseg));
        leftPanel.add(soronLevo);
        validate();

    }

    //ilyasz metodus

    /***
     * megnezi van-e korulotte masi kegyseg
     * @param y ilyasz pozicioja vertikalis
     * @param x ilyasz pozicioja  horizontalis
     * @return true ha nincs melette, false ha van
     */
    boolean ilyasz(int y,int x){

        return new Korulotte().ilyasz(y,x,negyzetRacs,(negyzetRacs[y][x].getBackground()==Color.red?Color.blue:Color.red));
    }

    //validator


    // "[" + i + "][" + j +"]"

    /*
    //ilyasz metodus
    boolean ilyasz(int y,int x){
        for (int i=y-1;i<y+2 ;i++) {
            for (int j=x-1;j<x+2 ;j++) {
                if (i>-1 && i<10 && j<12 && j>-1) {
                    if (!Objects.equals(negyzetRacs[i][j].getText(), "[____]") && negyzetRacs[i][j].getBackground()!=(egysegTomb[soronLevoEgyseg].jatekos?Color.red:Color.blue)) {
                        return false;
                    }
                }



            }
        }

    return true;
    }
*/
    // "[" + i + "][" + j +"]"
    @Override
    public void actionPerformed(ActionEvent e) {
        this.validate();
        //FELKESZULES
        if (soronLevoEgyseg==-1) {
            //palyan vegigmenni
            for (int i = 0; i < palyay; i++) {
                for (int j = 0; j < palyax; j++) {
                    if (e.getSource() == negyzetRacs[i][j]) {
                        //egysegek lerakasa
                        for (JButton jButton : lerakEgyseg) {
                            if (kivalasztottButton == jButton && j < 2 && (negyzetRacs[i][j].getText()== "[____]")) { ///11 tot 2 re visszaallitani
                                jButton.setEnabled(false);
                                char first = kivalasztottButton.getText().charAt(0);
                                char last = kivalasztottButton.getText().charAt(kivalasztottButton.getText().length() - 1);
                                negyzetRacs[i][j].setBackground(Color.red);
                                negyzetRacs[i][j].setText(String.valueOf(first) + last);
                                negyzetRacs[i][j].setFont(new Font("sansSerif Bold", Font.BOLD, 15));
                                kivalasztottButton=negyzetRacs[i][j];
                            }
                        }
                    }
                }
            }
            //egyseglerako gomb
            for (JButton jButton : lerakEgyseg) {
                if (e.getSource() == jButton) {


                    //vegen
                    kivalasztottButton = jButton;
                }
            }
            //kezdes
            if (e.getSource().equals(kezdoButton)) {
                for (JButton jButton : lerakEgyseg) {
                    if (jButton!=null && jButton.isEnabled()) {
                        System.out.println("kiiiii");
                        return;
                    }
                }
                //egysegeket beallit
                for (Egyseg a: egysegTomb) {
                    a.eloEgysegek=a.megvett;
                    a.osszesEletero=a.megvett*a.eletero;
                }


                kezdoButton.setEnabled(false);
                kezdoButton.setText("Jatek Elkezdodott");
                soronLevo=new JPanel();
                leftPanel.remove(reset);
                tamadas.addActionListener(this);
                varakozas.addActionListener(this);
                leftPanel.add(tamadas);
                leftPanel.add(varakozas);
                setSoronLevo();
                kivalasztottButton=kezdoButton;
                kor=0;
                String[] alma= new String[egysegTomb.length];
                for (int i=0;i<egysegTomb.length;i++) {
                    alma[i]=egysegTomb[i].nev +(egysegTomb[i].jatekos?"[elso]":"[masodik]");
                }
                System.out.println(alma[0]);
                String nemTomb= Arrays.toString(alma);
                topText.setText(kor + ". korben vagy " + nemTomb);
                akcioElso=true;
                akcioMasodik=true;
            }
            //reset
            if (e.getSource().equals(reset)) {
                this.dispose();
                try {
                    this.setVisible(false);
                    this.dispose();
                    new Csata(elsoJatekos);
                } catch (InterruptedException ignored) {}
            }

            return;
        }

        //Jatek


        if (egysegTomb[soronLevoEgyseg].jatekos) {
            try {
                elso(e);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        else {
            try {
                masodik(e);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
