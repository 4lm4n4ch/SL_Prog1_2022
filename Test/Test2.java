package Test;

import Main.Egyseg;

import java.util.Comparator;

public class Test2 implements Comparator<Egyseg> {
    public Test2() {
    }

    public int compare(Egyseg e1, Egyseg e2) {
        return e2.getOsszesEletero() - e1.getOsszesEletero();
    }
}
