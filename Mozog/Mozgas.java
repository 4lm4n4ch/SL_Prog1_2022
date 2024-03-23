package Mozog;
import  Main.*;
import Korulotte.*;
import Kozel.*;

import javax.swing.*;
import java.awt.*;

/***
 * Egysegeket mozgat
 * megnezi ures e a terulet, ahova menni akar
 */
public class Mozgas {
    public boolean mozog(JButton[][] negyzetRacs,int i, int j, int k, int l,Palya palya) {
        //mozgás

            if (negyzetRacs[k][l]!=null) {
                negyzetRacs[i][j].setText(negyzetRacs[k][l].getText());
                negyzetRacs[i][j].setBackground(negyzetRacs[k][l].getBackground());
                negyzetRacs[k][l].setText("[____]");
                negyzetRacs[k][l].setBackground(Color.black);
                palya.validate();
                return true;
            }
            return false;
        }
}
