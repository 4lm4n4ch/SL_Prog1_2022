package Main;

import Korulotte.*;
import Kozel.*;
import Mozog.Mozgas;

import javax.swing.*;
import java.awt.*;

/***
 * Ellenfel tavolsagi egysegeit iranyitja, megnezi van e
 * a kozelben ellenseges egyseg, ha nem tamad, ellenkezo esetben menekul
 */
public class Tavolsagi {
Egyseg[] egysegTomb;
int soronLevoEgyseg;
JButton[][] negyzetracs;
Melette melette = new Melette();
int[] yx;
int[] ab;
Egyseg vedekezo;
Palya palya;
    public Tavolsagi(Egyseg[] egysegTomb, int soronLevoEgyseg, JButton[][] negyzetracs,Jatekos tamasoJatekos, Jatekos vedekezoJatekos,Palya palya) throws InterruptedException {
        this.palya=palya;
        this.egysegTomb = egysegTomb;
        this.soronLevoEgyseg = soronLevoEgyseg;
        this.negyzetracs = negyzetracs;
        yx = new HolVan().ittVan(negyzetracs,egysegTomb[soronLevoEgyseg].rovidites,egysegTomb[soronLevoEgyseg].jatekos?Color.red:Color.blue);
        ab = new LegkozelebbiEgyseg().kozeliItt(yx[0],yx[1],negyzetracs,egysegTomb[soronLevoEgyseg].jatekos?Color.blue:Color.red);
        vedekezo=new EgysegMegtalal().megtalal(ab[0],ab[1],negyzetracs,egysegTomb);

        if (new Korulotte().ilyasz(yx[0],yx[1],negyzetracs,egysegTomb[soronLevoEgyseg].jatekos?Color.blue:Color.red)){
            //nincs melette egyseg, így tamadhat
            boolean futoVisszaTamadas=vedekezo.visszatamadas;
            vedekezo.visszatamadas=false;
            new Tamadas(egysegTomb[soronLevoEgyseg],vedekezo,tamasoJatekos,vedekezoJatekos);
            vedekezo.visszatamadas=futoVisszaTamadas;
        }
        //inkabb menekul
        else menekues();
    }
    void menekues() {
        //hova menjen
        int y=yx[0]+ (new Elojel().elojelKiszamit(yx[0]-ab[0]));
        int x=yx[1]+(new Elojel().elojelKiszamit(yx[1]-ab[1]));
        int z=0;
        for (int i=egysegTomb[soronLevoEgyseg].sebesseg;i!=0;) {
            //mozgas
            try{
                if (negyzetracs[y][x].getBackground()==Color.black) {
                    if (new Mozgas().mozog(negyzetracs,y,x,yx[0],yx[1],palya)) {
                        egysegTomb[soronLevoEgyseg].sebesseg--;
                        //itt mozgott
                        i--;
                    }

                }
            }
            catch (ArrayIndexOutOfBoundsException ignored){
            }


            if (z>=100) break;
            z++;
        }


    }



}
