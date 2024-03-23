package Test;

import Main.Egyseg;

import java.util.Comparator;

public class Test3 implements Comparator<Egyseg> {
    public Test3() {
    }

    public int compare(Egyseg e1, Egyseg e2) {
        return e2.getMegvett() - e1.getMegvett();
    }
}
