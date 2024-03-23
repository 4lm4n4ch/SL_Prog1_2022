package Kozel;

import Korulotte.Korulotte;
import Mozog.Eltuntet;

import javax.swing.*;
import java.awt.*;

/***
 * Ellenfelnek kell, megnezi az utvonalat, az adot koordinatara
 */
public class UtvonalKereses {
    public int[] megKeres(JButton[][] negyzetRacs,int y,int x,int a,int b) {
        if (!new Korulotte().ilyasz(y,x,negyzetRacs,Color.red)) ///csak ha  a gép csinálja mukodik
        {
            return new int[]{-1,-1};
        }
        Elojel elojel = new Elojel();

        if (Math.abs(x-b)>=Math.abs(y-a)) {
            if (x-b>=0) {
                //megnezi x- iranyba 3 fele vagyis y valtoztatjuk
                try{
                    if (negyzetRacs[y][x-1].getBackground()== Color.black) return new int[]{y,x-1};
                    if (negyzetRacs[y-1][x-1].getBackground()== Color.black) return new int[]{y-1,x-1};
                    if (negyzetRacs[y+1][x-1].getBackground()== Color.black) return new int[]{y+1,x-1};
                }
                catch (IndexOutOfBoundsException ignore) {}
            }
            else {
                //megnezi x iranyba 3 fele vagyis y valtoztatjuk
                try{
                    if (negyzetRacs[y][x+1].getBackground()== Color.black) return new int[]{y,x+1};
                    if (negyzetRacs[y-1][x+1].getBackground()== Color.black) return new int[]{y-1,x+1};
                    if (negyzetRacs[y+1][x+1].getBackground()== Color.black) return new int[]{y+1,x+1};
                }
                catch (IndexOutOfBoundsException ignore) {}
            }

        }
        if (Math.abs(x-b)<=Math.abs(y-a)) {
            if (y-a>=0) {
                //megnezi y irany x valtoztat
                try{
                    if (negyzetRacs[y-1][x].getBackground()== Color.black) return new int[]{y-1,x};
                    if (negyzetRacs[y-1][x-1].getBackground()== Color.black) return new int[]{y-1,x-1};
                    if (negyzetRacs[y-1][x+1].getBackground()== Color.black) return new int[]{y-1,x+1};
                }
                catch (IndexOutOfBoundsException ignore) {}
            }
            else {
                //megnezi y irany x valtoztat
                try{
                    if (negyzetRacs[y+1][x].getBackground()== Color.black) return new int[]{y+1,x};
                    if (negyzetRacs[y+1][x-1].getBackground()== Color.black) return new int[]{y+1,x-1};
                    if (negyzetRacs[y+1][x+1].getBackground()== Color.black) return new int[]{y+1,x+1};
                }
                catch (IndexOutOfBoundsException ignore) {}
            }


        }
        //van körülötte ures hely
        System.out.println("ez random");
        return new Korulotte().holVanKorulotte(y,x,negyzetRacs,Color.black);
    }
}
