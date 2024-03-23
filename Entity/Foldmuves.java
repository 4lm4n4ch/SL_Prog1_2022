package Entity;

import Main.Egyseg;
import Main.Jatekos;

import javax.swing.*;
/***
 * foldmuves egyseg ami egy egysegbol szarmazik
 */
public class Foldmuves extends Egyseg{
    /***
     *
     * @param egyseg Entity to create
     * @param jatekos Playre who owns the Entity
     * @return with the Entity
     */
    public Egyseg FoldmuvesLetrehoz(Egyseg egyseg, boolean jatekos) {
        egyseg.setLabel(new JLabel());
        egyseg.setNev( "foldmuves");
        egyseg.setRovidites("fs");
        egyseg.setMegvett(0);
        egyseg.setAr(2);
        egyseg.setSebzesmax(1);
        egyseg.setSebzesmin(1);
        egyseg.setEletero(3);
        egyseg.setSebesseg(4);
        egyseg.setKezdemenyezes(8);
        egyseg.setSpecialisKepesseg(0);
        egyseg.setJatekos(jatekos);
        egyseg.setVisszatamadas(true);
        return egyseg;
    }
}
