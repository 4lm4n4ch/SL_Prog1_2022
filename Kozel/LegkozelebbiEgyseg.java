package Kozel;

import javax.swing.*;
import java.awt.*;

import static java.lang.Math.abs;

/***
 * Ellenfelhez kell, megkeresi a legkozelebbi ellenseges egyseget
 */
public class LegkozelebbiEgyseg {
    public int[] kozeliItt(int a,int b,JButton[][] negyzetRacs,Color csapatSzin){
        int[][] legkozelebbiTomb=new int[10][12];
        for (int i=0;i<10;i++) {
            for (int j=0;j<12;j++) {
                if (negyzetRacs[i][j].getBackground()==csapatSzin) {
                    legkozelebbiTomb[i][j]=abs(i-a)+abs(j-b);
                }
                else legkozelebbiTomb[i][j]=Integer.MAX_VALUE;
            }
        }
        int[] legkozelebbiEgyseg={legkozelebbiTomb[0][0],0,0};
        for (int i=0;i<10;i++) {
            for (int j = 0; j < 12; j++) {
                if (legkozelebbiEgyseg[0]>legkozelebbiTomb[i][j]) {
                    legkozelebbiEgyseg[0]=legkozelebbiTomb[i][j];
                    legkozelebbiEgyseg[1]=i;
                    legkozelebbiEgyseg[2]=j;
                }
            }
        }
        return new int[]{legkozelebbiEgyseg[1],legkozelebbiEgyseg[2]};
    }
}