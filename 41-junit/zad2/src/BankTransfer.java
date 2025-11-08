import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Klasa BankTransfer reprezentuje przelew bankowy.
 * Dane są serializowane i zapisywane do pliku.
 */
public class BankTransfer implements Serializable {

    private String name;
    private String surname;
    private double amount;
    private String sourceAccountNumber;
    private String targetAccountNumber;

    public BankTransfer(String name, String surname, double amount,
                        String sourceNumber, String targetNumber) {
        this.name = name;
        this.surname = surname;
        this.amount = amount;
        this.sourceAccountNumber = sourceNumber;
        this.targetAccountNumber = targetNumber;
    }

    public boolean doWireTransfer() {
        try {
            toFile();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private void toFile() throws IOException {
        LocalDateTime now = LocalDateTime.now();
        String date = now.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String filename = surname + "_" + date + ".ser";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
            oos.writeObject(now.toString());
        }
    }

    public static String displayFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            BankTransfer bt = (BankTransfer) ois.readObject();
            String date = (String) ois.readObject();
            return "Transfer: " + bt.name + " " + bt.surname + ", amount: " + bt.amount +
                    ", from: " + bt.sourceAccountNumber + " to: " + bt.targetAccountNumber +
                    ", date: " + date;
        }
    }
}
