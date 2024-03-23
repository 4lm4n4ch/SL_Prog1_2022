package Main;

import Entity.*;

/***
 * Egysegesitett egysegletrehozo
 * itt lehet letrehozni az egysegeket, illetve egy tooString segitsegevel
 * lekerni ezeket az adatokat
 */
public class UjEgysegLetrehozasa {
    Egyseg egyseg;
    boolean jatekos;
    public String tooString(Egyseg egyseg){
        return egyseg.nev + " Ar: " + egyseg.ar + " Sebzes: " + egyseg.sebzesmin + "-" + egyseg.sebzesmax + " Eletero: " + egyseg.eletero + " Sebesseg: " + egyseg.sebesseg + " Kezdemenyezes: " + egyseg.kezdemenyezes + " Specialis kepesseg: " + specialis(egyseg.specialisKepesseg) + " Megvett: " + egyseg.megvett;
    }

    /***
     * Egyseget hozz letre
     * @param a hanyadik egyseget hozza letre
     * @param jatekos melyik jatekosnak hozza letre
     * @return egy letrehozott egyseggel ter vissza
     */
    public Egyseg letrehoz(int a,boolean jatekos){
        this.jatekos=jatekos;
        switch (a) {
            case 0 -> {
               return new Foldmuves().FoldmuvesLetrehoz(new Egyseg(),jatekos);
            }
            case 1 -> {
                return new Ilyasz().IlyaszLetrehoz(new Egyseg(),jatekos);
            }
            case 2 -> {
                return new Griff().GriffLetrehoz(new Egyseg(),jatekos);
            }
            case 3 -> {
                return new Lovag().LovagLetrehoz(new Egyseg(),jatekos);
            }
            case 4 -> {
                return new Lovas().LovasLetrehoz(new Egyseg(),jatekos);
            }
            default -> {
                System.err.println("ERRORR");
                return foldmuves();
            }
        }
    }

    /***
     * foldmuves Egyseget hozz letre
     * @return foldmuvesse lter vissza
     */
    public Egyseg foldmuves(){
        this.egyseg=new Egyseg();
        this.egyseg.nev="foldmuves";
        this.egyseg.rovidites="fs";
        this.egyseg.megvett=0;
        this.egyseg.ar=2;
        this.egyseg.sebzesmax=1;
        this.egyseg.sebzesmin=1;
        this.egyseg.eletero=3;
        this.egyseg.sebesseg=4;
        this.egyseg.kezdemenyezes=8;
        this.egyseg.specialisKepesseg=0;
        this.egyseg.jatekos=jatekos;
        this.egyseg.visszatamadas=true;
        return this.egyseg;
    }

    /***
     * egy ilyasz egysegget hoz letre
     * @return ilyasz egyseggel ter vissza
     */
    public Egyseg ilyasz(){
        this.egyseg=new Egyseg();
        this.egyseg.nev="ilyasz";
        this.egyseg.rovidites="iz";
        this.egyseg.megvett=0;
        this.egyseg.ar=6;
        this.egyseg.sebzesmax=4;
        this.egyseg.sebzesmin=2;
        this.egyseg.eletero=7;
        this.egyseg.sebesseg=4;
        this.egyseg.kezdemenyezes=9;
        this.egyseg.specialisKepesseg=1;
        this.egyseg.jatekos=jatekos;
        this.egyseg.visszatamadas=true;
        return this.egyseg;
    }

    /***
     * egy griff egyseget hoz letre
     * @return eg ygriff egyseggel ter vissza
     */
    public Egyseg griff(){
        this.egyseg=new Egyseg();
        this.egyseg.nev="griff";
        this.egyseg.rovidites="gf";
        this.egyseg.megvett=0;
        this.egyseg.ar=15;
        this.egyseg.sebzesmax=10;
        this.egyseg.sebzesmin=5;
        this.egyseg.eletero=30;
        this.egyseg.sebesseg=7;
        this.egyseg.kezdemenyezes=15;
        this.egyseg.specialisKepesseg=2;
        this.egyseg.jatekos=jatekos;
        this.egyseg.visszatamadas=true;
        return this.egyseg;
    }

    /***
     * lovag egyseget hozza letre
     * @return lovag egyseggel ter vissza
     */
    public Egyseg lovag(){
        this.egyseg=new Egyseg();
        this.egyseg.nev="lovag";
        this.egyseg.rovidites="lg";
        this.egyseg.megvett=0;
        this.egyseg.ar=10;
        this.egyseg.sebzesmax=6;
        this.egyseg.sebzesmin=3;
        this.egyseg.eletero=15;
        this.egyseg.sebesseg=4;
        this.egyseg.kezdemenyezes=9;
        this.egyseg.specialisKepesseg=3;
        this.egyseg.jatekos=jatekos;
        this.egyseg.visszatamadas=true;
        return this.egyseg;
    }

    /***
     * lovas egyseget hozza letre
     * @return egy lovas egyseg
     */
    public Egyseg lovas(){
        this.egyseg=new Egyseg();
        this.egyseg.nev="lovas";
        this.egyseg.rovidites="ls";
        this.egyseg.megvett=0;
        this.egyseg.ar=12;
        this.egyseg.sebzesmax=8;
        this.egyseg.sebzesmin=4;
        this.egyseg.eletero=5;
        this.egyseg.sebesseg=8;
        this.egyseg.kezdemenyezes=12;
        this.egyseg.specialisKepesseg=1;
        this.egyseg.jatekos=jatekos;
        this.egyseg.visszatamadas=true;
        return this.egyseg;
    }

    String specialis(int a) {
        switch (a) {
            case 0:
                return "nincs";
            case 1:
                return "loves";
            case 2:
                return "visszatamadas";
            case 3:
                return "pajzs";
            default:
                return "loves";
        }
    }
}
