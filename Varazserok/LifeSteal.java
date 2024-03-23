package Varazserok;

import FelugroAblakok.VarazseroHasznalat;
import Korulotte.HolVan;
import Main.Egyseg;
import Main.Jatekos;
import Main.Palya;
import Main.Varazsero;
import Mozog.Eltuntet;

import javax.swing.*;
import java.awt.*;

/***
 * Egy ellenséges egyseg aletat ellopja, majd azt hozzaadja a sajathoz
 */
public class LifeSteal extends Varazsero {
    public LifeSteal(Egyseg sajatEgyseg,Egyseg ellensegesEgyseg, Jatekos jatekos) throws InterruptedException {
        if (jatekos.getTudas()<8) return;

        ellensegesEgyseg.setOsszesEletero(ellensegesEgyseg.getOsszesEletero()-jatekos.getVarazsero()*20);
        if (ellensegesEgyseg.getOsszesEletero()<=0) {
            //meghalt
            ellensegesEgyseg.setEloEgysegek(0);
            ellensegesEgyseg.setOsszesEletero(0);
            ellensegesEgyseg.setVisszatamadas(false);
            int[] tomb = new HolVan().ittVan(Palya.negyzetRacs,ellensegesEgyseg.getRovidites(),ellensegesEgyseg.isJatekos()? Color.red:Color.blue);
            new Eltuntet().egysegEltuntet(Palya.negyzetRacs[tomb[0]][tomb[1]]);
            ellensegesEgyseg.label.setText(ellensegesEgyseg.getNev() + " egyseg meghalt");
        }
        sajatEgyseg.setOsszesEletero(sajatEgyseg.getOsszesEletero()+jatekos.getVarazsero()*20);
        if (sajatEgyseg.getOsszesEletero()>sajatEgyseg.getMegvett()*sajatEgyseg.getEletero()){
            sajatEgyseg.setOsszesEletero(sajatEgyseg.getMegvett()*sajatEgyseg.getEletero());
        }
        sajatEgyseg.setEloEgysegek(sajatEgyseg.getOsszesEletero()%sajatEgyseg.getEletero()==0?sajatEgyseg.getOsszesEletero()/ sajatEgyseg.getEletero():sajatEgyseg.getOsszesEletero()/ sajatEgyseg.getEletero()+1);
        sajatEgyseg.label.setText(sajatEgyseg.nev + " [" + sajatEgyseg.getEloEgysegek() + "/" +  sajatEgyseg.getOsszesEletero() + "]  ");


        jatekos.setTudas(jatekos.getTudas()-8);
        Palya.leftText.setText("Elso Jatekos: " + jatekos.getTudas() + " mana");
        new VarazseroHasznalat((jatekos.isJatekos()?"elsojatekos ":"masodikjatekos ")+ ellensegesEgyseg.nev +"-tol ");
    }


}
