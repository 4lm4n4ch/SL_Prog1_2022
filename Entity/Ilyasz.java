package Entity;

import Main.Egyseg;
import Main.Jatekos;

import javax.swing.*;

/***
 * ilyasz egyseg ami egy egysegbol szarmazik
 */
public class Ilyasz extends Egyseg {
    /***
     *
     * @param egyseg Entity to create
     * @param jatekos Playre who owns the Entity
     * @return with the Entity
     */
    public Egyseg IlyaszLetrehoz(Egyseg egyseg, boolean jatekos) {
        egyseg.setLabel(new JLabel());
        egyseg.setNev( "ilyasz");
        egyseg.setRovidites("fs");
        egyseg.setMegvett(0);
        egyseg.setAr(6);
        egyseg.setSebzesmax(4);
        egyseg.setSebzesmin(2);
        egyseg.setEletero(7);
        egyseg.setSebesseg(4);
        egyseg.setKezdemenyezes(9);
        egyseg.setSpecialisKepesseg(1);
        egyseg.setJatekos(jatekos);
        egyseg.setVisszatamadas(true);
        return egyseg;
    }
}
