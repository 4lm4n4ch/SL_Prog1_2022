package Varazserok;

import FelugroAblakok.VarazseroHasznalat;
import Main.Egyseg;
import Main.Jatekos;
import Main.Palya;
import Main.Varazsero;

import javax.swing.*;

/***
 * Varazserobol szarmazik
 * feltamasztas varazslatot hajtja vegre
 * a konstruktorban
 * majd kirja a mana valtozast az ablakra
 */
public class Feltamasztas extends Varazsero {
    public Feltamasztas(Egyseg egyseg, Jatekos jatekos) throws InterruptedException {
        super();
        if (jatekos.getTudas()<9) return;
        if (egyseg.getOsszesEletero()==egyseg.getEletero()*egyseg.getMegvett()) return;
        egyseg.setOsszesEletero(egyseg.getOsszesEletero()+jatekos.getVarazsero()*50);
        if (egyseg.getOsszesEletero()>egyseg.getMegvett()*egyseg.getEletero()){
            egyseg.setOsszesEletero(egyseg.getMegvett()*egyseg.getEletero());
        }
        egyseg.setEloEgysegek(egyseg.getOsszesEletero()%egyseg.getEletero()==0?egyseg.getOsszesEletero()/ egyseg.getEletero():egyseg.getOsszesEletero()/ egyseg.getEletero()+1);
        egyseg.label.setText(egyseg.nev + " [" + egyseg.getEloEgysegek() + "/" +  egyseg.getOsszesEletero() + "]  ");
        jatekos.setTudas(jatekos.getTudas()-9);
        Palya.leftText.setText("Elso Jatekos: " + jatekos.getTudas() + " mana");
        new VarazseroHasznalat((jatekos.isJatekos()?"elsojatekos ":"masodikjatekos ")+ egyseg.nev +"-et feltamasztotta");
    }


}
