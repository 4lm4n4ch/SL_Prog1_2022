package Kozel;

/***
 * Megnezi, hogy a ket koordinata egymas melett van e
 */
public class Melette {

    //kozeleben van
    public boolean melette(int i, int j, int k, int l) {
        if (i == k || i == k + 1 || i == k - 1) {
            if (j == l || j == l - 1 || j == l + 1) return true;
        }
        return false;
    }
}
