package Korulotte;
import  Main.*;
import Korulotte.*;
import Kozel.*;

import javax.swing.*;
import java.awt.*;

/***
 * Megkeres egy egyseget a csatateren, koordinatak alapjan
 */
public class EgysegMegtalal {
    public Egyseg megtalal(int y, int x, JButton[][] negyzetRacs, Egyseg[] egysegTomb){
        for (Egyseg a: egysegTomb) {
            if (a.getRovidites().equals(negyzetRacs[y][x].getText()) && negyzetRacs[y][x].getBackground()==(a.isJatekos()? Color.red:Color.blue)){
                return a;
            }
        }
        return egysegTomb[0];
    }
}
