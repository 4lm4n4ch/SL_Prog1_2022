package Main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * az ellenfel egysegeit rakja le a palyara, 4 kulombozo variansa letezik
 */
public class EllenfelLerak {
    public void lerak(JButton[][] negyzetRacs) {
        int rnd = (int) (Math.random() * (4));
        String[] tomb= {"fs","iz","gf","lg","ls"};
        int[] tomb1 = {10, 11, 11, 10, 10};
        int[] tomb2 = {7, 9, 8, 8, 6, 6, 8, 7, 7, 5, 2, 0, 2, 0, 1, 3, 1, 3, 1, 2};
        for (int i=0;i<tomb.length;i++) {
            negyzetRacs[tomb2[i+rnd*5]][tomb1[i]].setText(tomb[i]);
            negyzetRacs[tomb2[i+rnd*5]][tomb1[i]].setFont(new Font("sansSerif Bold", Font.BOLD, 15));
            negyzetRacs[tomb2[i+rnd*5]][tomb1[i]].setBackground(Color.blue);
        }

    }
}
