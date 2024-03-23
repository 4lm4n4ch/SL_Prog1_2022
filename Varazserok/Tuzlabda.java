package Varazserok;

import FelugroAblakok.VarazseroHasznalat;
import Korulotte.EgysegMegtalal;
import Korulotte.HolVan;
import Main.*;
import Mozog.Eltuntet;

import javax.swing.*;
import java.awt.*;
/***
 * Varazserobol szarmazik
 * Tuzlabda varazslatot hajtja vegre
 * egy adott teruletre sebzest visz
 * a konstruktorban
 * majd kirja a mana valtozast az ablakra
 */
public class Tuzlabda extends Varazsero {
    JButton[][] negyzetRacs;
    Egyseg[] egysegTomb;
    Jatekos jatekos;
    public Tuzlabda(JButton[][] negyzetRacs,int y, int x,Egyseg[] egysegTomb, Jatekos jatekos) throws InterruptedException {
        super();
        if (jatekos.getTudas()<9) return;
        this.jatekos=jatekos;
        this.negyzetRacs=negyzetRacs;
        this.egysegTomb = egysegTomb;
        try {if (this.negyzetRacs[y][x].getBackground() != Color.black) tuzlabdaSebzes(y,x);} catch (IndexOutOfBoundsException ignore) {}
        try {if (this.negyzetRacs[y][x+1].getBackground() != Color.black) tuzlabdaSebzes(y,x+1);} catch (IndexOutOfBoundsException ignore) {}
        try {if (this.negyzetRacs[y][x-1].getBackground() != Color.black) tuzlabdaSebzes(y,x-1);} catch (IndexOutOfBoundsException ignore) {}
        try {if (this.negyzetRacs[y+1][x].getBackground() != Color.black) tuzlabdaSebzes(y+1,x);} catch (IndexOutOfBoundsException ignore) {}
        try { if (this.negyzetRacs[y+1][x+1].getBackground() != Color.black) tuzlabdaSebzes(y+1,x+1);} catch (IndexOutOfBoundsException ignore) {}
        try {if (this.negyzetRacs[y+1][x-1].getBackground() != Color.black) tuzlabdaSebzes(y+1,x-1);} catch (IndexOutOfBoundsException ignore) {}
        try {if (this.negyzetRacs[y-1][x].getBackground() != Color.black) tuzlabdaSebzes(y-1,x);} catch (IndexOutOfBoundsException ignore) {}
        try {if (this.negyzetRacs[y-1][x+1].getBackground() != Color.black) tuzlabdaSebzes(y-1,x+1);} catch (IndexOutOfBoundsException ignore) {}
        try {if (this.negyzetRacs[y-1][x-1].getBackground() != Color.black) tuzlabdaSebzes(y-1,x-1);} catch (IndexOutOfBoundsException ignore) {}


        jatekos.setTudas(jatekos.getTudas()-9);
        Palya.leftText.setText("Elso Jatekos: " + jatekos.getTudas() + " mana");
    }

    void tuzlabdaSebzes(int a, int b) throws InterruptedException {
        Egyseg egyseg= new EgysegMegtalal().megtalal(a,b,negyzetRacs,egysegTomb);


        egyseg.setOsszesEletero(egyseg.getOsszesEletero()-(jatekos.getVarazsero()*20));
        egyseg.setEloEgysegek(egyseg.getOsszesEletero()%egyseg.getEletero()==0?egyseg.getOsszesEletero()/ egyseg.getEletero():egyseg.getOsszesEletero()/ egyseg.getEloEgysegek()+1);
        egyseg.label.setText(egyseg.nev + " [" + egyseg.getEloEgysegek() + "/" +  egyseg.getOsszesEletero() + "]  ");

        if (egyseg.getOsszesEletero()<=0) {
            //meghalt
            egyseg.setEloEgysegek(0);
            egyseg.setOsszesEletero(0);
            egyseg.setVisszatamadas(false);
            int[] tomb = new HolVan().ittVan(Palya.negyzetRacs,egyseg.getRovidites(),egyseg.isJatekos()? Color.red:Color.blue);
            new Eltuntet().egysegEltuntet(Palya.negyzetRacs[tomb[0]][tomb[1]]);
            egyseg.label.setText(egyseg.getNev() + " egyseg meghalt");
        }



        new VarazseroHasznalat((jatekos.isJatekos()?"elsojatekos ":"masodikjatekos ")+ egyseg.nev +"-ra/re Tuzbombat dobott");


    }
    
}
