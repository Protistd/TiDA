import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class BankTransferTest {

    BankTransfer bt;

    @BeforeEach
    void setUp() {
        bt = new BankTransfer("Jan","Kowalski",1000.0,
                "PL_1234_5678_9012_3456_7890_1234",
                "PL_9876_5432_1098_7654_3210_9876");
    }

    @Test
    void testDoWireTransfer() {
        assertTrue(bt.doWireTransfer());
    }

    @Test
    void testDisplayFile() throws Exception {
        bt.doWireTransfer();
        // nazwa pliku dynamiczna, trzeba pobrać ostatni wygenerowany
        File dir = new File(".");
        File[] files = dir.listFiles((d, name) -> name.startsWith("Kowalski_"));
        assertNotNull(files);
        assertTrue(files.length > 0);
        String output = BankTransfer.displayFile(files[0].getName());
        assertTrue(output.contains("Kowalski"));
        assertTrue(output.contains("1000.0"));
    }
}
