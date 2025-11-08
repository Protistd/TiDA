import java.util.ArrayList;
import java.util.List;

/**
 * Klasa Calculator obsługuje podstawowe działania matematyczne
 * oraz przechowuje historię wyników.
 */
public class Calculator {

    private double result;                  // ostatni wynik
    private List<Double> history;           // historia wyników

    public Calculator() {
        this.result = 0.0;
        this.history = new ArrayList<>();
    }

    public double sum(double a, double b) {
        result = a + b;
        appendToHistory(result);
        return result;
    }

    public double subtract(double a, double b) {
        result = a - b;
        appendToHistory(result);
        return result;
    }

    public double multiplay(double a, double b) {
        result = a * b;
        appendToHistory(result);
        return result;
    }

    public double divide(double a, double b) {
        if (b == 0) throw new ArithmeticException("Division by zero!");
        result = a / b;
        appendToHistory(result);
        return result;
    }

    private void appendToHistory(double value) {
        history.add(value);
    }

    public String displayHistory() {
        return history.toString();
    }

    public double getResult() {
        return result;
    }

    public List<Double> getHistory() {
        return history;
    }
}
