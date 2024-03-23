package Test;
import Main.Egyseg;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class Test {
    private Egyseg egyseg;
    @BeforeEach
    public void setUp() {
        egyseg = new Egyseg();
    }
    @AfterAll
    public static void tearDown() {
        System.out.println("Teszteles befejezve!");
    }
}
