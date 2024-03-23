package Main;

import javax.swing.*;

/***
 * Egyseg adatait tarolja, getterek setterekkel valtoztatni lehet
 */
public class Egyseg{


    public JLabel label;
    public String nev;
    String rovidites;
    int megvett;
    int ar;
    int sebzesmax;
    int sebzesmin;
    int eletero;
    int osszesEletero;
    int eloEgysegek;
    int sebesseg;
    int kezdemenyezes;
    int specialisKepesseg;
    boolean jatekos;
    boolean visszatamadas;

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getRovidites() {
        return rovidites;
    }

    public void setRovidites(String rovidites) {
        this.rovidites = rovidites;
    }

    public int getMegvett() {
        return megvett;
    }

    public void setMegvett(int megvett) {
        this.megvett = megvett;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public int getSebzesmax() {
        return sebzesmax;
    }

    public void setSebzesmax(int sebzesmax) {
        this.sebzesmax = sebzesmax;
    }

    public int getSebzesmin() {
        return sebzesmin;
    }

    public void setSebzesmin(int sebzesmin) {
        this.sebzesmin = sebzesmin;
    }

    public int getEletero() {
        return eletero;
    }

    public void setEletero(int eletero) {
        this.eletero = eletero;
    }

    public int getOsszesEletero() {
        return osszesEletero;
    }

    public void setOsszesEletero(int osszesEletero) {
        this.osszesEletero = osszesEletero;
    }

    public int getEloEgysegek() {
        return eloEgysegek;
    }

    public void setEloEgysegek(int eloEgysegek) {
        this.eloEgysegek = eloEgysegek;
    }

    public int getSebesseg() {
        return sebesseg;
    }

    public void setSebesseg(int sebesseg) {
        this.sebesseg = sebesseg;
    }

    public int getKezdemenyezes() {
        return kezdemenyezes;
    }

    public void setKezdemenyezes(int kezdemenyezes) {
        this.kezdemenyezes = kezdemenyezes;
    }

    public int getSpecialisKepesseg() {
        return specialisKepesseg;
    }

    public void setSpecialisKepesseg(int specialisKepesseg) {
        this.specialisKepesseg = specialisKepesseg;
    }

    public boolean isJatekos() {
        return jatekos;
    }

    public void setJatekos(boolean jatekos) {
        this.jatekos = jatekos;
    }

    public boolean isVisszatamadas() {
        return visszatamadas;
    }

    public void setVisszatamadas(boolean visszatamadas) {
        this.visszatamadas = visszatamadas;
    }

    //0 nincs
    //1 loves
    //2 vegtelen visszatamadas
    //3 meg egy specialis kepesseg
    //4 meg egy specialis kepesseg

}
