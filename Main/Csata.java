package Main;

/***
 * egyszeru class, meghivja a Palya classot a jatekossal
 */
public class Csata {
    Jatekos elsoJatekos;
    public Csata(Jatekos elsoJatekos) throws InterruptedException {
        this.elsoJatekos=elsoJatekos;
        new Palya(this.elsoJatekos);
    }


}
