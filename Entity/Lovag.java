package Entity;

import Main.Egyseg;
import Main.Jatekos;

import javax.swing.*;
/***
 * lovag egyseg ami egy egysegbol szarmazik
 */
public class Lovag extends Egyseg {
    /***
     *
     * @param egyseg Entity to create
     * @param jatekos Playre who owns the Entity
     * @return with the Entity
     */
    public Egyseg LovagLetrehoz(Egyseg egyseg, boolean jatekos) {
        egyseg.setLabel(new JLabel());
        egyseg.setNev( "lovag");
        egyseg.setRovidites("lg");
        egyseg.setMegvett(0);
        egyseg.setAr(10);
        egyseg.setSebzesmax(6);
        egyseg.setSebzesmin(3);
        egyseg.setEletero(15);
        egyseg.setSebesseg(4);
        egyseg.setKezdemenyezes(9);
        egyseg.setSpecialisKepesseg(3);
        egyseg.setJatekos(jatekos);
        egyseg.setVisszatamadas(true);
        return egyseg;

    }
}
