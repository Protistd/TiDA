import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @AfterEach
    void tearDown() {
        calc = null;
    }

    @Test
    void testSum() {
        assertEquals(7.0, calc.sum(3,4));
    }

    @Test
    void testSubtract() {
        assertEquals(1.0, calc.subtract(5,4));
    }

    @Test
    void testMultiplay() {
        assertEquals(20.0, calc.multiplay(5,4));
    }

    @Test
    void testDivide() {
        assertEquals(2.5, calc.divide(5,2));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calc.divide(5,0));
    }

    @Test
    void testHistory() {
        calc.sum(2,3);
        calc.subtract(10,5);
        assertTrue(calc.getHistory().size() == 2);
    }
}
