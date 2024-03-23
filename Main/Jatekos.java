package Main;

/***
 * jatekos tulajdonsagait tarolja, beallitja, lekeri, modositja
 */
public class Jatekos {
    int tamadas;
    int vedekezes;
    int varazsero;
    int tudas;
    int moral;
    int szerencse;
    int penz;
    boolean[] varazserok;
    boolean jatekos;
    Egyseg[] egysegek;


//KOnstruktorok

    public Jatekos(int tamadas, int vedekezes, int varazsero, int tudas, int moral, int szerencse, int penz, boolean[] varazserok, boolean jatekos) {
        if (!jatekos) robot();
        this.tamadas = tamadas;
        this.vedekezes = vedekezes;
        this.varazsero = varazsero;
        this.tudas = tudas;
        this.moral = moral;
        this.szerencse = szerencse;
        this.penz = penz;
        this.varazserok = varazserok;
        this.jatekos = jatekos;
    }
    public Jatekos(int tamadas, int vedekezes, int varazsero, int tudas, int moral, int szerencse, int penz, boolean[] varazserok,Egyseg[] egysegek, boolean jatekos) {
        if (!jatekos) robot();
        this.tamadas = tamadas;
        this.vedekezes = vedekezes;
        this.varazsero = varazsero;
        this.tudas = tudas;
        this.moral = moral;
        this.szerencse = szerencse;
        this.penz = penz;
        this.varazserok = varazserok;
        this.egysegek = egysegek;
        this.jatekos = jatekos;
    }
    void robot(){
        egysegek=new Egyseg[5];
        int[] tomb={7,25,21,20,10};
        for (int i=0;i<5;i++) {
            egysegek[i]= new UjEgysegLetrehozasa().letrehoz(i,false);
            egysegek[i].megvett=tomb[i];
            egysegek[i].eloEgysegek=tomb[i];
            egysegek[i].osszesEletero=tomb[i]*egysegek[i].eletero;
        }

    }


    public Jatekos() {
    }

    //get set
    public int getTamadas() {
        return tamadas;
    }

    public void setTamadas(int tamadas) {
        if (tamadas<0) {
            this.tamadas=0;
            return;
        }
        if (tamadas>10) {
            this.tamadas = tamadas;
            return;
        }
        this.tamadas = tamadas;
    }

    public int getVedekezes() {
        return vedekezes;
    }

    public void setVedekezes(int vedekezes) {
        if (vedekezes<0) {
            this.vedekezes=0;
            return;
        }
        if (vedekezes>10) {
            this.vedekezes = vedekezes;
            return;
        }
        this.vedekezes = vedekezes;
    }

    public int getVarazsero() {
        return varazsero;
    }

    public void setVarazsero(int varazsero) {
        if (varazsero<0) {
            this.varazsero=0;
            return;
        }
        if (varazsero>10) {
            this.varazsero = varazsero;
            return;
        }
        this.varazsero = varazsero;
    }

    public int getTudas() {
        return tudas;
    }

    public void setTudas(int tudas) {
        if (tudas<0) {
            this.tudas=0;
            return;
        }
        if (tudas>10) {
            this.tudas = tudas;
            return;
        }
        this.tudas = tudas;
    }

    public int getMoral() {
        return moral;
    }

    public void setMoral(int moral) {
        if (moral<0) {
            this.moral=0;
            return;
        }
        if (moral>10) {
            this.moral = moral;
            return;
        }
        this.moral = moral;
    }

    public int getSzerencse() {
        return szerencse;
    }

    public void setSzerencse(int szerencse) {
        if (szerencse<0) {
            this.szerencse=0;
            return;
        }
        if (szerencse>10) {
            this.szerencse = szerencse;
            return;
        }
        this.szerencse = szerencse;
    }

    public int getPenz() {
        return penz;
    }

    public void setPenz(int penz) {
        this.penz = penz;
    }

    public boolean[] getVarazserok() {
        return varazserok;
    }

    public void setVarazserok(boolean[] varazserok) {
        this.varazserok = varazserok;
    }


    public boolean isJatekos() {
        return jatekos;
    }

    public void setJatekos(boolean jatekos) {
        this.jatekos = jatekos;
    }

//
}
