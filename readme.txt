
A játék célja, hogy minél hosszabb ideig lekössön, és szórakoztasson.
Futtatás:
„javac -cp . Main\Main.java”
„java -cp . Main.Main”
A játékmenetet:
Itt a nehézséget kell kiválasztanod, mely alapján kapsz megfelelõ mennyiségû pénzt
    könnyû ->1300 pénz
    közepes ->1000 pénz
    nehéz -> 700 pénz

A nehézség kiválasztása után a hõsöd tulajdonságait kell kiválasztanod.

Ezen kívül tudsz még varázslatokat is venni, csak egyszer. A varázslat manaköltségét is ott nézheted meg.

Miután végeztél, és rányomtál a folytatásra, az egységeidet tudod megvenni.
Az elsõ öt sorban láthatod az egységet, tulajdonságait, legvégén a különleges képességeit, majd, hogy mennyit vásároltál az adott egységbõl.
A játékban található egy fekete input mezõt, ide tudod beírni,
Hogy a kiválasztott egységbõl mennyit szeretnél megvenni.
A kiválasztott egységet az elõtte található lenyíló fülön tudod kiválasztani.
Ezután a Vetel gombbal tudod véglegesíteni a döntésedet. Amennyiben az adott egységbõl
Utána még egyszer szeretnél venni, megteheted, amennyiben van elég pénzed,
Ekkor a megvett egységek hozzáadódnak a már meglévõ seregedhez.

Érdemes elhasználnod az összes pénzedet, ugyanis ezután már nem lesz rá lehetõséged.

A játék gomb megnyomása után megjelenik a csatatér, bal oldalán a te egységeid, varázslataid.
Jobb oldalán az ellenfél egységei, varázslatai találhatóak, ezen felül itt tudod megtekinteni.
Az ellenfél által választott tulajdonságpontokat is.
Az egységek neve után a meglévõ katonák száma, illetve az életeik összege látható.
([katonak szama/Összes életerõ])
A játékos neve után(Elso Jatékos vagy Második Játékos) található a hõs manája.

Ezután elkezdheted lerakni az egységeidet, a baloldali két sorba.
ezt úgy tudod megtenni, hogy elõszõr a baloldali egységre,
majd a csatatéren az általad szimpatikusnak vélt területre kattintasz,
 majd miután sikeresen lehelyezted az egységeidet, a Kezdes gombra kattintva indíthatod el a játékot.

A felsõ sorban látható az, hogy hanyadik körben vagy, utána meg balról jobbra, az egységek, az alapján,
hogy a körben ki-ki után következik(értelem szerûen a bal oldali kezd hamarabb).

Saját egységeid mozgását egyesével tudod végrehajtani, addig, míg elfogy a mozgás pontod, amit bal oldalon a
szürke téglalapban ír. Ha eleget mozogtál, nem kell elhasználnod az összes lépéspontot, nyomd meg a tovább gombot.

Ahhoz, hogy az ellenfél egységei mozogjanak, rá kell kattintanod a csatatérre, vagy az oldalsó gombok egyikére.
Ha valaki támadod, vagy varázslatot használt, akkor egy kis ablak jelenik meg bal fölül, amely egy idõ után eltûnik, de be is zárhatod. Itt jelzi a visszatámadást, illetve a kritikus sebzést is.

Az hogy éppen melyik egység lép most, azt baloldalt egy szürke dobozban láthatod.
Várakozáshoz a Varakozas gombot kell megnyomnod, varázslatokhoz az adott varázslat kiválasztása után a csatatérre való kattintással aktiválhatod, a hõs támadása is hasonló képpen mûködik.



A játékban található új egységek a lovag, illetve a lovas. A lovag különleges képessége a pajzzsal való
hárítás, mely 50% eséllyel kivédi a sebzés felét. A lovas egy távolsági egység, mondhatni egy lovasíjász.
Többi tulajdonságát az egységek vásárlása közben tudod megnézni.

Az új varázslatok a teleportálás, illettve az életlopás, vagyis a lifesteal.

A lifeSteal-el a játékos varázseröjének 20 szorosának megfelelõ Életerõt tudsz ellopni egy ellenséges
egységtõl, majd azt a soron lévõ egységednek odaadni, aki így gyógyulni fog.

A telepotálással egy általad kiválasztott egységet(ellenfél vagy saját) tudsz véletlenszerûen
elteleportálni a pályán.

A tûzlabdát bárhova, a villámcsapás viszont csak ellenséges egységre tudod csak kijátszani.
A feltámasztás csakis az éppen soron lévõ egységre tudod felhasználni, úgy hogy rákattintasz.

Ha a játéknak vége van, azt az jelzi, hogy egy új ablak jelenik meg, rajta egy piros gombbal, illetve egy felirattal, hogy ki nyert.

A program swinget (https://docs.oracle.com/javase/8/docs/api/javax/swing/package-summary.html) használ, ennek a beüzemeléséhez javaslom az Idea nevû programot. A program a javax.swing packageet használja. A program szigorúan a java 17. et használja.
A java classok package-be vannak rendezve, a programot a Main package Main class-al(!) tudod elindítani. 
A Tesztelések a Test packageben vannak.
Az egység classok az Entity packageben vannak.
A JavaDoc a Java Dock mappában található

