
package Test;

import Entity.Foldmuves;
import Entity.Griff;
import Entity.Ilyasz;
import Entity.Lovag;
import Main.Egyseg;
import Main.Jatekos;
import Main.UjEgysegLetrehozasa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Test4 {
    Test4() {
    }

    @Test
    void setTudas() {
        Jatekos jatekos = new Jatekos();
        jatekos.setTudas(1);
        Assertions.assertEquals(1, jatekos.getTudas());
        jatekos.setTudas(111);
        Assertions.assertEquals(10, jatekos.getTudas());
        jatekos.setTudas(-1);
        Assertions.assertEquals(0, jatekos.getMoral());
    }

    @Test
    void setMoral() {
        Jatekos jatekos = new Jatekos();
        jatekos.setMoral (3);
        Assertions.assertEquals(3, jatekos.getTudas());
        jatekos.setMoral(1);
        Assertions.assertEquals(1, jatekos.getTudas());
        jatekos.setMoral(9999);
        Assertions.assertEquals(10, jatekos.getTudas());
        jatekos.setMoral(-8);
        Assertions.assertEquals(0, jatekos.getTudas());
    }

    @Test
    void setSzerencse() {
        Jatekos jatekos = new Jatekos();
        jatekos.setSzerencse(3);
        Assertions.assertEquals(3, jatekos.getSzerencse());
        jatekos.setSzerencse(1);
        Assertions.assertEquals(3, jatekos.getSzerencse());
        jatekos.setSzerencse(999);
        Assertions.assertEquals(10, jatekos.getSzerencse());
        jatekos.setSzerencse(-10);
        Assertions.assertEquals(0, jatekos.getSzerencse());
    }

    @Test
    void setVarazserok() {
        Jatekos jatekos = new Jatekos();
        jatekos.setVarazserok(new boolean[]{true,true,true,true,true});
        boolean[] tomb = new boolean[]{true,true,true,true,true};
        boolean[] tomb1 = new boolean[]{false,false,true,true,true};
        boolean[] tomb2 = new boolean[]{false,true,false,true,true};
        Assertions.assertEquals(tomb, jatekos.getVarazserok());
        jatekos.setVarazserok(tomb1);
        Assertions.assertEquals(tomb1, jatekos.getVarazserok());
        jatekos.setVarazserok(tomb2);
        Assertions.assertEquals(tomb2, jatekos.getVarazserok());
    }

    @Test
    void setVarazsero() {
        Jatekos jatekos = new Jatekos();
        jatekos.setVarazsero(3);
        Assertions.assertEquals(3, jatekos.getVarazsero());
        jatekos.setVarazsero(-1);
        Assertions.assertEquals(-1, jatekos.getVarazsero());
        jatekos.setVarazsero(999);
        Assertions.assertEquals(10, jatekos.getVarazsero());
    }

    @Test
    void setVedekezes() {
        Jatekos jatekos = new Jatekos();
        jatekos.setVedekezes(1);
        Assertions.assertEquals(1, jatekos.getVedekezes());
        jatekos.setVedekezes(3);
        Assertions.assertEquals(3, jatekos.getVedekezes());
        jatekos.setVedekezes(999);
        Assertions.assertEquals(10, jatekos.getVedekezes());
        jatekos.setVedekezes(-10);
        Assertions.assertEquals(0, jatekos.getVedekezes());
    }

    @Test
    void setTamadas() {
        Jatekos jatekos = new Jatekos();
        jatekos.setTamadas(3);
        Assertions.assertEquals(3, jatekos.getTamadas());
        jatekos.setTamadas(-1);
            Assertions.assertEquals(0, jatekos.getTamadas());
        jatekos.setTamadas(9999);
        Assertions.assertEquals(10, jatekos.getTamadas());
    }

    @Test
    void egysegLetrehoz(){
        Egyseg egyseg = new Foldmuves();
        new Foldmuves().FoldmuvesLetrehoz(egyseg,true);
        Assertions.assertTrue(egyseg.isJatekos());
        Assertions.assertEquals(2,egyseg.getAr());
        Assertions.assertEquals(4,egyseg.getSebesseg());
    }
    @Test
    void egysegLetrehoz2(){
        Egyseg egyseg = new Ilyasz();
        new Ilyasz().IlyaszLetrehoz(egyseg,false);
        Assertions.assertFalse(egyseg.isJatekos());
        Assertions.assertEquals(6,egyseg.getAr());
        Assertions.assertEquals(4,egyseg.getSebesseg());
    }
    @Test
    void egysegLetrehoz3(){
        Egyseg egyseg = new Griff();
        new Griff().GriffLetrehoz(egyseg,true);
        Assertions.assertTrue(egyseg.isJatekos());
        Assertions.assertEquals(15,egyseg.getAr());
        Assertions.assertEquals(7,egyseg.getSebesseg());
    }
    @Test
    void egysegLetrehoz4(){
        Egyseg egyseg = new Lovag();
        new Lovag().LovagLetrehoz(egyseg,true);
        Assertions.assertTrue(egyseg.isJatekos());
        Assertions.assertEquals(10,egyseg.getAr());
        Assertions.assertEquals(4,egyseg.getSebesseg());
    }
}
