package Main;
/***
 * Varazslat, innen szarmaznak a varazslatok
 * getterek, setterek vannak hozza
 */
public class Varazsero {
    int varazslat;
    int mana;

    public Varazsero(int varazslat, int mana) {
        this.varazslat = varazslat;
        this.mana = mana;
    }

    public Varazsero() {
        if(getMana()==0) setMana(getMana());
        if(getVarazslat()==0) setMana(getMana());
    }

    public int getVarazslat() {
        return varazslat;
    }

    public void setVarazslat(int varazslat) {
        this.varazslat = varazslat;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}
