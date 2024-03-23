package Varazserok;

import FelugroAblakok.VarazseroHasznalat;
import Main.Egyseg;
import Main.Jatekos;
import Main.Palya;
import Main.Varazsero;
import Mozog.Mozgas;

import javax.swing.*;
import java.awt.*;
/***
 * Varazserobol szarmazik
 * teleportalas varazslatot hajtja vegre
 * random hejre teleportal
 * a konstruktorban
 * majd kirja a mana valtozast az ablakra
 */
public class Teleportalas extends Varazsero {
    public Teleportalas(JButton[][] negyzetracs, int y, int x, Egyseg egyseg, Palya palya, Jatekos jatekos) throws InterruptedException {
        super();
        if (jatekos.getTudas()<5) return;
        if (egyseg.getLabel().getBackground()==(jatekos.isJatekos()?Color.blue:Color.red)) return;
        int rnd1;
        int rnd2;
        do {
            rnd1 = (int) (Math.random() * (10));
            rnd2 = (int) (Math.random() * (12));
        } while (negyzetracs[rnd1][rnd2].getBackground() != Color.black);
        new Mozgas().mozog(negyzetracs,rnd1,rnd2,y,x,palya);
        jatekos.setTudas(jatekos.getTudas()-5);
        Palya.leftText.setText("Elso Jatekos: " + jatekos.getTudas() + " mana");
        new VarazseroHasznalat((jatekos.isJatekos()?"elsojatekos ":"masodikjatekos ")+ egyseg.nev +" el lett teleportalva");
    }
}
