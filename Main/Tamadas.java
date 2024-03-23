package Main;

import FelugroAblakok.KritikusTalalat;
import FelugroAblakok.Pajzs;
import FelugroAblakok.Sebzes;
import Korulotte.HolVan;
import Mozog.Eltuntet;

import java.awt.*;
import java.util.Random;

/***
 * Lekezeli a sebzeseket, visszatamadast, mindket jatekosnal
 */
public class Tamadas {
    double tamadas;
    double visszatamadas=0;

    public Tamadas(Egyseg tamado, Egyseg vedekezo, Jatekos elsojatekos, Jatekos masodikJatekos) throws InterruptedException {
        this.tamadas = (int)Math.floor(Math.random()*(tamado.sebzesmax-tamado.sebzesmin+1)+tamado.sebzesmin);
        //kiszamolja a tamadast
        this.tamadas*=tamado.eloEgysegek;
        this.tamadas*= 1+ elsojatekos.tamadas*0.1;
        this.tamadas*= 1-masodikJatekos.vedekezes *(0.05);
        this.tamadas= (int) tamadas;
        //kritikus sebzes
        if(new Random().nextInt(100/(elsojatekos.szerencse*5))==0) {
            System.out.println("kritikus tamadas");
            new KritikusTalalat(tamado.nev + "-->" + vedekezo.nev);
            tamadas*=2;
        }
        //pajzs
        if (vedekezo.specialisKepesseg==3 && new Random().nextInt(2)==0){
            tamadas/=2;
            new Pajzs(vedekezo.nev + " pajzsa lecsokkentette az okozott sebzest");
        }
        //sebzes
        vedekezo.osszesEletero-=tamadas;
        vedekezo.eloEgysegek=(vedekezo.osszesEletero%vedekezo.eletero==0?vedekezo.osszesEletero/ vedekezo.eletero:vedekezo.osszesEletero/ vedekezo.eletero+1);
        vedekezo.label.setText(vedekezo.nev + " [" + vedekezo.eloEgysegek + "/" +  vedekezo.osszesEletero + "]  ");
        new Sebzes(tamado.nev + " " + tamadas + " sebzest vitt be " + vedekezo.nev + " egysegbe");
        if (vedekezo.osszesEletero<=0) { //meghal az egyseg
            System.out.println("meghalt" + vedekezo.nev);
            vedekezo.eloEgysegek=0;
            vedekezo.osszesEletero=0;
            vedekezo.visszatamadas=false;
            int[] tomb = new HolVan().ittVan(Palya.negyzetRacs,vedekezo.rovidites,vedekezo.jatekos? Color.red:Color.blue);
            new Eltuntet().egysegEltuntet(Palya.negyzetRacs[tomb[0]][tomb[1]]); //indexout
            vedekezo.label.setText(vedekezo.nev + " egyseg meghalt");

        }
        //visszatamadas, nincs kritikus sebzes
        if (vedekezo.visszatamadas) {
            this.visszatamadas = (int)Math.floor(Math.random()*(vedekezo.sebzesmax-vedekezo.sebzesmin+1)+vedekezo.sebzesmin);
            this.visszatamadas*=vedekezo.eloEgysegek;
            this.visszatamadas*= 1+ masodikJatekos.tamadas*0.1;
            this.visszatamadas*= 1-elsojatekos.vedekezes *(0.05);
            this.visszatamadas= (int) visszatamadas;
            tamado.osszesEletero-=visszatamadas;
            tamado.eloEgysegek=(tamado.osszesEletero%tamado.eletero==0?tamado.osszesEletero/ tamado.eletero:tamado.osszesEletero/ tamado.eletero+1);
            tamado.label.setText(tamado.nev + " [" + tamado.eloEgysegek + "/" +  tamado.osszesEletero + "]  ");
            new Sebzes(vedekezo.nev + " visszatamadt");
            if (tamado.osszesEletero<=0) { //meghal az egyseg
                tamado.eloEgysegek=0;
                tamado.osszesEletero=0;
                int[] tomb = new HolVan().ittVan(Palya.negyzetRacs,vedekezo.rovidites,vedekezo.jatekos? Color.red:Color.blue);
                new Eltuntet().egysegEltuntet(Palya.negyzetRacs[tomb[0]][tomb[1]]);
                tamado.label.setText(tamado.nev + " egyseg meghalt");

            }
        }
        if (vedekezo.specialisKepesseg!=2) {
            vedekezo.visszatamadas= false;
        }
    }


}
