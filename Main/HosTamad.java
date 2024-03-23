package Main;

import FelugroAblakok.VarazseroHasznalat;
import Korulotte.HolVan;
import Mozog.Eltuntet;

import java.awt.*;

/***
 * ha egy hos tamad, ez a class kezeli le
 */
public class HosTamad {
    void tamad(Egyseg egyseg, Jatekos jatekos) throws InterruptedException {
        egyseg.setOsszesEletero(egyseg.getOsszesEletero()-jatekos.getVarazsero()*10);
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
        new VarazseroHasznalat((egyseg.isJatekos()?"elsojatekos ":"masodikjatekos ")+ egyseg.nev +"-ra/re tamadast intezett");
    }
}
