package Varazserok;

import FelugroAblakok.VarazseroHasznalat;
import Korulotte.HolVan;
import Main.*;
import Mozog.Eltuntet;

import javax.swing.*;
import java.awt.*;
/***
 * Varazserobol szarmazik
 * villamcsapas varazslatot hajtja vegre
 * egy adott elenseges egysegen nezi meg
 * adott menyisegut sebez
 * a konstruktorban
 * majd kirja a mana valtozast az ablakra
 */
public class Villamcsapas extends Varazsero {
    public Villamcsapas(Egyseg egyseg, Jatekos tamadoJatekos) throws InterruptedException {
        super();
        if (tamadoJatekos.getTudas()<5) return;
        if (egyseg.getLabel().getBackground()==(tamadoJatekos.isJatekos()?Color.blue:Color.red)) return;

            egyseg.setOsszesEletero(egyseg.getOsszesEletero()-tamadoJatekos.getVarazsero()*30);
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


        
        tamadoJatekos.setTudas(tamadoJatekos.getTudas()-5);
        Palya.leftText.setText("Elso Jatekos: " + tamadoJatekos.getTudas() + " mana");
        new VarazseroHasznalat((tamadoJatekos.isJatekos()?"elsojatekos ":"masodikjatekos ")+ egyseg.nev +"-ra/re tamadast intezett");
    }
}
