package Entity;

import Main.Egyseg;
import Main.Jatekos;

import javax.swing.*;
/***
 * griff egyseg ami egy egysegbol szarmazik
 */
public class Griff extends Egyseg {
    /***
     *
     * @param egyseg Entity to create
     * @param jatekos Playre who owns the Entity
     * @return with the Entity
     */
    public Egyseg GriffLetrehoz(Egyseg egyseg, boolean jatekos) {
        egyseg.setLabel(new JLabel());
        egyseg.setNev( "griff");
        egyseg.setRovidites("gf");
        egyseg.setMegvett(0);
        egyseg.setAr(15);
        egyseg.setSebzesmax(10);
        egyseg.setSebzesmin(5);
        egyseg.setEletero(30);
        egyseg.setSebesseg(7);
        egyseg.setKezdemenyezes(15);
        egyseg.setSpecialisKepesseg(2);
        egyseg.setJatekos(jatekos);
        egyseg.setVisszatamadas(true);
        return egyseg;

    }
}
