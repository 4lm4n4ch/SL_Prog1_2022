package Korulotte;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/***
 * megnezi, hogy egy koordinata kozelebe mi van
 */
public class Korulotte {
    JButton[][] negyzetRacs;

    //ilyasz metodus
    public boolean ilyasz(int y,int x,JButton[][] negyzetRacs, Color color){ //color az elenfél szinét jelenti
        for (int i=y-1;i<y+2 ;i++) {
            for (int j=x-1;j<x+2 ;j++) {
                if (i>-1 && i<10 && j<12 && j>-1) {
                    if (x==j && y==i) continue;
                    if (negyzetRacs[i][j].getBackground()==color) {
                        return false;
                    }
                }



            }
        }

        return true;
    }
    //hol van korulotte
    public int[] holVanKorulotte(int y,int x,JButton[][] negyzetRacs, Color color){ //color az elenfel szinét jelenti
        for (int i=y-1;i<y+2 ;i++) {
            for (int j=x-1;j<x+2 ;j++) {
                if (i>-1 && i<10 && j<12 && j>-1) {
                    if (x==j && y==i) continue;
                    if (negyzetRacs[i][j].getBackground()==color) {
                        return new int[]{i,j};
                    }
                }



            }
        }

        return new int[]{-1,-1};
    }
}
