package Entity;

import Main.Egyseg;
import Main.Jatekos;

import javax.swing.*;
/***
 * lovas egyseg ami egy egysegbol szarmazik
 */
public class Lovas extends Egyseg {
    /***
     *
     * @param egyseg Entity to create
     * @param jatekos Playre who owns the Entity
     * @return with the Entity
     */
    public Egyseg LovasLetrehoz(Egyseg egyseg, boolean jatekos) {
        egyseg.setLabel(new JLabel());
        egyseg.setNev( "lovas");
        egyseg.setRovidites("ls");
        egyseg.setMegvett(0);
        egyseg.setAr(12);
        egyseg.setSebzesmax(8);
        egyseg.setSebzesmin(4);
        egyseg.setEletero(5);
        egyseg.setSebesseg(8);
        egyseg.setKezdemenyezes(12);
        egyseg.setSpecialisKepesseg(1);
        egyseg.setJatekos(jatekos);
        egyseg.setVisszatamadas(true);
        return egyseg;

    }
}
