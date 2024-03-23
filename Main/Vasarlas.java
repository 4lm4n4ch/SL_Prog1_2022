package Main;

import javax.swing.*;

/***
 * Vasarlas kulon class-ban, vegul nem kellett a jatekhoz
 * kepessegeket lehet vele kivalasztani
 */
public class Vasarlas extends HosBeallit{
    public static void kepessegValaszatas(int kepesseg, int hanyadikKepesseg, JButton button, JLabel vegetext) {
        int futo=5;
        for (int i=0;i<hanyadikKepesseg;i++) {
            futo+=Math.ceil(futo*0.1);
            System.out.println(futo);
        }

    }

    public Vasarlas(int nehezseg) {
        super(nehezseg);
    }
}
