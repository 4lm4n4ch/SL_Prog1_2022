package Main;

import Korulotte.EgysegMegtalal;
import Korulotte.HolVan;
import Korulotte.Korulotte;
import Kozel.LegkozelebbiEgyseg;
import Kozel.UtvonalKereses;
import Mozog.Mozgas;

import javax.swing.*;
import java.awt.*;

/***
 * Kozeli ellenfelek mozgasat, tamadasat allitja be
 * ha kozelben van egyseg, megtamadja
 * ha nincs, akkor eloindul fele
 */
public class Kozeli {
    public Kozeli(Egyseg[] egysegTomb, int soronLevoEgyseg, JButton[][] negyzetRacs, Jatekos tamado, Jatekos vedekezo,Palya palya) throws InterruptedException {
        int[] yx = new HolVan().ittVan(negyzetRacs,egysegTomb[soronLevoEgyseg].getRovidites(),tamado.jatekos? Color.red:Color.blue);
        int[] ab= new LegkozelebbiEgyseg().kozeliItt(yx[0],yx[1],negyzetRacs,tamado.jatekos?Color.blue:Color.red);
        int[] kulombsegYxAb={-yx[0]+ab[0],-yx[1]+ab[1]};

        //kozelben van ellenseges egyseg, tamad
        if (!new Korulotte().ilyasz(yx[0],yx[1],negyzetRacs,Color.red))
        {

            int[] tomb = new Korulotte().holVanKorulotte(yx[0],yx[1],negyzetRacs,Color.red);
            new Tamadas(egysegTomb[soronLevoEgyseg],new EgysegMegtalal().megtalal(tomb[0],tomb[1],negyzetRacs,egysegTomb),tamado,vedekezo);
            System.out.println(egysegTomb[soronLevoEgyseg].nev + "tamad");

            //tamadas vege
            return;
        }


        //ez a lepes
        for (int i=egysegTomb[soronLevoEgyseg].sebesseg;i>0;i--) {
            int[] hovaMegy = new UtvonalKereses().megKeres(negyzetRacs,yx[0],yx[1],ab[0],ab[1]);
            if (hovaMegy[0]==-1) continue;
            System.out.println("ide megy");
            System.out.println(hovaMegy[0] + "][" + hovaMegy[1]);
            new Mozgas().mozog(negyzetRacs, hovaMegy[0],hovaMegy[1],yx[0],yx[1],palya);
            Thread.sleep(20);
            yx[0]=hovaMegy[0];
            yx[1]=hovaMegy[1];
        }



    }
}
