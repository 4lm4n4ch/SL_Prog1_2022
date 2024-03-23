package Korulotte;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/***
 * egyseget keres meg, nev, csapat alapjan
 */
public class HolVan {
    public int[] ittVan(JButton[][] negyzetRacs, String egysegNev, Color csapatSzin){
        int i;
        int j=0;
        kulsoloop:
        for (i=0;i<10;i++){
            for (j=0;j<12;j++) {
                if (Objects.equals(negyzetRacs[i][j].getText(), egysegNev) && negyzetRacs[i][j].getBackground()==csapatSzin) {
                    break kulsoloop;
                }
            }
        }


        return new int[]{i,j};
    }
}
